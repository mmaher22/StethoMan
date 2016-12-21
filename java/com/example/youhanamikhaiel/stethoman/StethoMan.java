package com.example.youhanamikhaiel.stethoman;

import android.app.Application;

/**
 * Created by MohamedMaher on 12/16/2016.
 */

public class StethoMan extends Application {

    private int id = 0;
    private char type = 'N';
    private int viewdocid, viewpatid;
    private int id2 =0;

    public int getid() {
        return id;
    }
    public char gettype() {
        return type;
    }

    public int getid2() {
        return id2;
    }

    public void setid(int var1, char var2) {
        this.id = var1;
        this.type = var2;
    }


    public void setid2(int var1) {
        this.id2 = var1;
    }

    public void setviewdocid(int var1) {
        this.viewdocid = var1;
    }

    public int getviewdocid() {
        return viewdocid;
    }

    public void setviewpatid(int var1) {
        this.viewpatid = var1;
    }

    public int getviewpatid() {
        return viewpatid;
    }
}
