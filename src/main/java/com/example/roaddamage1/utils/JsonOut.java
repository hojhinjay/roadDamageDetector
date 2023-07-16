package com.example.roaddamage1.utils;

import com.google.gson.Gson;

import java.io.PrintWriter;

public class JsonOut {

    public static void out(PrintWriter out, Object o){
        //JSONObject jso=JSONObject.fromObject(o);
        Gson gson = new Gson();
        out.print(gson.toJson(o));
    }
}
