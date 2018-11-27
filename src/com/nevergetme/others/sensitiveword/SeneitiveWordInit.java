package com.nevergetme.others.sensitiveword;

import org.jetbrains.annotations.NotNull;
import sun.net.www.http.Hurryable;

import java.sql.*;
import java.util.*;

public class SeneitiveWordInit {
    public static void main(String[] args){
        SeneitiveWordInit s=new SeneitiveWordInit();
    }
    private String ENCODE="utf-8";
    public HashMap wordsMap;
    public SeneitiveWordInit(){
        initKeyWord();
        System.out.println(wordsMap);
    }
    public void checkSensitiveWords(String input,int beginIndex){
        boolean flag=false;
        char word=0;
        HashMap currentMap=wordsMap;
        StringBuffer sb=new StringBuffer();
        for(int i=beginIndex;i<input.length();i++){
            word=input.charAt(i);
            Object tempObj=currentMap.get(word);
            if(tempObj!=null){
                HashMap map=(HashMap)tempObj;
                if(map.get("isend").equals("true")){
                    break;
                }
            }
        }
    }
    public void checkSensitiveWords(String input,int beginIndex,StringBuffer sb){
    }
    public void initKeyWord(){
        //Set<String> keySet=readSensitiveWordFromMySQL();
        Set<String> keySet=new HashSet<>();
        keySet.add("中国人");
        keySet.add("中国男人");
        keySet.add("中金");
        keySet.add("北京");
        generateWordsMap(keySet);
    }
    private void generateWordsMap(Set<String> keySet){
        //需要实现一个森林
        //输入一个字符串，首先判断
        wordsMap=new HashMap(keySet.size());
        Iterator<String> it=keySet.iterator();
        String keyWord=null;
        HashMap currentMap=null;
        while (it.hasNext()){
            keyWord=it.next();
            currentMap=wordsMap;
            for(int i=0;i<keyWord.length();i++){
                char keyChar=keyWord.charAt(i);
                currentMap=generateWordsMap(keyChar,currentMap,i==keyWord.length()-1?true:false);
            }
        }
    }
    private HashMap generateWordsMap(char target,HashMap currentMap,boolean isEnd){
        Object tempMap=currentMap.get(target);
        if(tempMap==null){
            HashMap map=new HashMap();
            map.put("isend",isEnd);
            currentMap.put(target,map);
            return map;
        }else{
            HashMap map=(HashMap)tempMap;
            map.put("isend",isEnd);
            return map;
        }
    }
    private Set<String> readSensitiveWordFromMySQL(){
        Set<String> keySet=new HashSet<>();
        //List<String> list=new ArrayList<>();
        Connection conn;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/Sensitiveword";
        String user="hzw";
        String password="hzw123456";
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            if(!conn.isClosed()){
                System.out.println("Success");
            }
            Statement statement=conn.createStatement();
            String sql="select * from words";
            ResultSet rs=statement.executeQuery(sql);
            String words=null;
            while (rs.next()){
                words=rs.getString("words");
                keySet.add(words);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keySet;
    }
}
