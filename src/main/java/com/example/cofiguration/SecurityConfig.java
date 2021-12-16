package com.example.cofiguration;

import java.util.*;

public class SecurityConfig {

    public static final String ROLE_ADMINISTRATOR = "ADMINISTRATOR";
    public static final String ROLE_USER = "USER";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {
        List<String> userUrlPatterns = new ArrayList<String>();
        userUrlPatterns.add("/");
        mapConfig.put(ROLE_USER, userUrlPatterns);

        List<String> adminUrlPatterns = new ArrayList<String>();
        adminUrlPatterns.add("/");
        mapConfig.put(ROLE_ADMINISTRATOR, adminUrlPatterns);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}
