package com.example.dell.apptest;

/**
 * Created by DELL on 01/09/2016.
 */
public class Character {

String type;
int power;
int speed;
char rank;


    public Character (String s,int p,int sp,char c){

        type=s;
        power=p;
        speed=sp;
        rank=c;


    }

    public String getType() {
        return type;
    }
}
