package com.nevergetme.algorithmCompetition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtil {
    //get方式登录
    public static void requestNetForGetLogin(final String username, final String password) {

        //在子线程中操作网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                //urlConnection请求服务器，验证
                try {
                    //1：url对象
                    //http://www.nevergetme.com:8080/SpringExamFirst_war/user/login?username=user&password=pass
                    URL url = new URL("http://localhost:8080/user/login?username=" + URLEncoder.encode(username) + "&password=" + URLEncoder.encode(password) + "");
                    //2;url.openconnection
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //3
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(10 * 1000);
                    //4
                    int code = conn.getResponseCode();
                    if (code == 200) {
                        InputStreamReader is = new InputStreamReader(conn.getInputStream());
                        BufferedReader bufferedReader = new BufferedReader(is);
                        StringBuffer strBuffer = new StringBuffer();
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            strBuffer.append(line);
                        }
                        String result = strBuffer.toString();
//                        String result = StreamUtil.stremToString(inputStream);
                        System.out.println("=====================服务器返回的信息：：" + result);
                        boolean isLoginsuccess = false;
                        if (result.contains("success")) {
                            isLoginsuccess = true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args){
        requestNetForPOSTLogin("毛泽东你好");
    }

    //post方式登录
    public static void requestNetForPOSTLogin(String words) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //urlConnection请求服务器，验证
                try {
                    //1：url对象
                    URL url = new URL("http://www.nevergetme.com:8080/SpringExamFirst_war/user/sensitiveword");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //3设置请求参数
                    conn.setRequestMethod("POST");
                    conn.setConnectTimeout(10 * 1000);
                    //请求头的信息
                    String body = "words="+words;
                    conn.setRequestProperty("Content-Length", String.valueOf(body.length()));
                    conn.setRequestProperty("Cache-Control", "max-age=0");
                    //设置conn可以写请求的内容
                    conn.setDoOutput(true);
                    conn.getOutputStream().write(body.getBytes());

                    //4响应码
                    int code = conn.getResponseCode();
                    System.out.println(code);
                    if (code == 200) {
                        InputStreamReader is = new InputStreamReader(conn.getInputStream());
                        BufferedReader bufferedReader = new BufferedReader(is);
                        StringBuffer strBuffer = new StringBuffer();
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            strBuffer.append(line);
                        }
                        String result = strBuffer.toString();
                        System.out.println("=====================服务器返回的信息：：" + result);
                        boolean isLoginsuccess = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
