package com.nevergetme.algorithmCompetition;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLReader {
    public static List<String> readSeneitiveWordFromMySQL(){
        List<String> list=new ArrayList<>();
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
            //PreparedStatement pstmt=conn.prepareStatement("insert into words values(NULL,?)");

            String sql="select * from words";
            ResultSet rs=statement.executeQuery(sql);
            String words=null;
            while (rs.next()){
                words=rs.getString("words");
                list.add(words);
                //System.out.println(words);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<String> readSensitiveWord() throws Exception {
        List<String> list=new ArrayList<>();
        File file=new File("../SensitiveWord.txt");
        InputStreamReader read = new InputStreamReader(new FileInputStream(file));
        try {
            if(file.isFile()&&file.exists()){
                BufferedReader bufferedReader=new BufferedReader(read);
                String txt=null;
                while ((txt=bufferedReader.readLine())!=null){
                    //System.out.println(txt);
                    if(!txt.equals("")){
                        list.add(txt);
                    }
                }
            }
        }catch (Exception e) {
            throw e;
        }finally{
            read.close();     //关闭文件流
            return list;
        }
    }
    public static void main(String[] args) throws Exception {
        List<String> list=readSeneitiveWordFromMySQL();
        System.out.println(list);
//        List<String> list=readSensitiveWord();
//        Connection conn;
//        String driver="com.mysql.jdbc.Driver";
//        String url="jdbc:mysql://localhost:3306/Sensitiveword";
//        String user="hzw";
//        String password="hzw123456";
//        try {
//            Class.forName(driver);
//            conn= DriverManager.getConnection(url,user,password);
//            if(!conn.isClosed()){
//                System.out.println("Success");
//            }
//            Statement statement=conn.createStatement();
//            PreparedStatement pstmt=conn.prepareStatement("insert into words values(NULL,?)");
//            for(String txt:list){
//                pstmt.setString(1,txt);
//                pstmt.executeUpdate();
//            }
////            String sql="select * from words";
////            ResultSet rs=statement.executeQuery(sql);
////            String words=null;
////            while (rs.next()){
////                words=rs.getString("words");
////                System.out.println(words);
////            }
//            //rs.close();
//            conn.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
