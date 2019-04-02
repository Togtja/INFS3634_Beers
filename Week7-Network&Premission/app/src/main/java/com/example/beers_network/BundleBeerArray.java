package com.example.beers_network;

import java.io.Serializable;
import java.util.ArrayList;

class BundleBeerArray implements Serializable {
    //to passing data, must implements Serializable
    //remember also need to implements Serializable in your "MyObject"
    public ArrayList<Beer> mlist;

    public BundleBeerArray(ArrayList<Beer> mlist) {
        this.mlist = mlist;
    }

    public ArrayList<Beer> getmlist(){
        return this.mlist;
    }

}