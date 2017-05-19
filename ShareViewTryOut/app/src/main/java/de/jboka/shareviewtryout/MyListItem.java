package de.jboka.shareviewtryout;

import java.io.Serializable;

/**
 * Created by Jakob on 19.05.17.
 */

public class MyListItem implements Serializable {

    private String title;
    private String desc;

    public MyListItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
