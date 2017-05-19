package de.jboka.shareviewtryout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Activity activity;
    private RecyclerView recyclerView;
    private MyRecylcleListAdapter recylcleListAdapter;
    private List<MyListItem> itemList = new ArrayList<>();
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        activity = this;

        recyclerView = (RecyclerView) findViewById(R.id.rvMain);
        cardView = (CardView) findViewById(R.id.card);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        setItemClickListener();
    }

    private void fillRecyclerView(){
        for(int i=0; i<10; i++){
            MyListItem item = new MyListItem("Title " + i, "Description " + i);
            itemList.add(item);
            Log.d("MYAPP", item.getTitle());
        }

        recylcleListAdapter = new MyRecylcleListAdapter(itemList, this);
        recyclerView.setAdapter(recylcleListAdapter);
    }

    private void setItemClickListener(){
        recylcleListAdapter.SetOnItemClickListener(new MyRecylcleListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, recylcleListAdapter.getItem(position).getTitle() + " clicked", Toast.LENGTH_SHORT).show();
                MyListItem item = recylcleListAdapter.getItem(position);
                Intent intent = new Intent(context, ShareToActivity.class);
                intent.putExtra("shareCard", item);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view.findViewById(R.id.card), "card");
                startActivity(intent, optionsCompat.toBundle());
            }
        });
    }
}
