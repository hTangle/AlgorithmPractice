package com.nevergetme.algorithmCompetition;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLReader {
    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x;
    }
}
