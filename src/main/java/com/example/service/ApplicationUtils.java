package com.example.service;

import com.example.repo.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ApplicationUtils {
    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();

    public static void storeLoginedUser(HttpSession session, UserRepository loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }


    public static void storeLoginedUserJwt(HttpSession session, String token) {
        session.setAttribute("loginedUserJwt", token);
    }

    public static String getLoginedUserJwt(HttpSession session) {
        String jwt = (String) session.getAttribute("loginedUserJwt");
        return jwt;
    }
}
