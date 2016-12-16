package com.example.youhanamikhaiel.stethoman;

import android.app.Application;

/**
 * Created by MohamedMaher on 12/16/2016.
 */

public class StethoMan extends Application {

    private int id = 0;
    private char type = 'N';

    public int getid() {
        return id;
    }
    public char gettype() {
        return type;
    }

    public void setid(int var1, char var2) {
        this.id = var1;
        this.type = var2;
    }
}
