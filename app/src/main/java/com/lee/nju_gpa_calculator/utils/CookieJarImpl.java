package com.lee.nju_gpa_calculator.utils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Guo on 2017/1/18.
 *
 * 保存和管理教务系统Cookie的类
 * 将其添加到OkHttpClient可实现对Cookie的自动化管理
 */
public class CookieJarImpl implements CookieJar {

    private static final String EAS_VALIDATE_CODE = "http://elite.nju.edu.cn/jiaowu/ValidateCode.jsp";
    private static List<Cookie> cookies;

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> cookies) {
        if(httpUrl.toString().equals( EAS_VALIDATE_CODE )) {
            this.cookies = cookies;
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        if (cookies != null) {
            return cookies;
        } else {
            return new ArrayList();
        }
    }

    public static void clearCookies() {
        cookies = null;
    }
}
