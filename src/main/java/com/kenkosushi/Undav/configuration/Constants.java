package com.kenkosushi.Undav.configuration;

/**
 * Created by leo on 11/10/17.
 */
public class Constants {

    // Spring Security

    public static final String LOGIN_URL = "/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT

    public static final String ISSUER_INFO = "https://www.kenkosushi.com/";
    public static final String SUPER_SECRET_KEY = "kenko";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
}
