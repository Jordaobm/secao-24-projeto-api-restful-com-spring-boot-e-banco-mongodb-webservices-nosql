package com.springbootmongodb.demo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParam(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }
}
