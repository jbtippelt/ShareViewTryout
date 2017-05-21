package de.jboka.shareviewtryout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Created by Jakob on 19.05.17.
 */

public class MyRecylcleListAdapter  extends RecyclerView.Adapter<MyRecylcleListAdapter.ViewHolder> {

    private List<MyListItem> itemList;
    private Context context;

    private int mExpandedPosition = -1;
    OnItemClickListener clickListener;

    public MyRecylcleListAdapter(List<MyListItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyListItem item = itemList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvDesc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public MyListItem getItem(int position){
        return itemList.get(position);
    }

    public void setJobList(List<MyListItem> list){
        this.itemList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvTitle;
        public TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            tvDesc = (TextView) itemView.findViewById(R.id.itemDesc);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }
}