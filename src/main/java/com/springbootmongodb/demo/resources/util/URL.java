package com.springbootmongodb.demo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }


    public static Date convertDate(String date, Date defaultValue) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
