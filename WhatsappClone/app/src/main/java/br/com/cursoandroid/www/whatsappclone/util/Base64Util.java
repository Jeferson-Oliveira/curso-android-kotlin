package br.com.cursoandroid.www.whatsappclone.util;

import android.util.Base64;

/**
 * Created by jeferson.jesus on 18/04/18.
 */
public class Base64Util {
    public static String encode(String value)  {
        return Base64.encodeToString(value.getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
    }
    public static String decode(String value) {
        return new String(Base64.decode(value, Base64.DEFAULT));
    }
}