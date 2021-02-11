package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertyUtil {

    @Autowired
    ResourceLoader resourceloader;

    public static final String PROPERTY_FILE_NAME = "resources.properties";

    public static Properties _properties = new Properties();

    static {
        loadProps(PROPERTY_FILE_NAME);
    }

    private static void loadProps(String fileName) {

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        try {
            if (null != is) {
                _properties.load(is);
            }
        } catch (IOException e) {
            System.err.println("Exception while loading properties from the file [" + fileName + "]");
            e.printStackTrace();
        }

        System.out.println("Properties are loaded from the fileName [" + fileName + "]");
        System.out.println("Total lines read : " + _properties.size());
    }

    public static String getProperty(String key) {
        return getProperty(key, true, null);
    }

    public static String getProperty(String key, boolean stripQuotes, String defaultValue)
    {
        String value = String.valueOf(_properties.get(key));

        //System.out.println("value :: " + value);

        if(null==value || value.trim().length()==0) {
            if(null!=defaultValue) {
                value = defaultValue;
            }
        }

        //System.out.println("(2) value :: " + value);

        List<String> elementsToReplace = Arrays.asList("'", "\"");

        for(String s : elementsToReplace) {
            value = value.replaceAll(s, "");
            //System.out.println("... value after replacing - [ "+ s + "] : " + value);
        }

        //System.out.println("(3) Final value :: " + value);

        value = value.trim();

        return value;
    }

    public static String[] getPropArray(String key) {
        return PropertyUtil.getArray(PropertyUtil.getProperty(key));
    }

    public static List<String> getList(String data) {
        return getList(data, ",");
    }

    public static String[] getArray(String data) {
        return getArray(data, ",");
    }

    public static String[] getArray(String data, String delimiter) {
        String[] strArray= new String[]{};
        return getList(data, delimiter).toArray(strArray);
    }

    public static List<String> getList(String data, String delimiter) {
        List<String> strList = new ArrayList<>();

        if(null==data || data.trim().length()==0) {
            return strList;
        }

        StringTokenizer st = new StringTokenizer(data, delimiter);

        while(st.hasMoreTokens()) {
            strList.add(st.nextToken().trim());
        }

        return strList;
    }

    public static void printAllProperties() {
        Set<Object> keys = _properties.keySet();
        Iterator<Object> iterator = keys.iterator();
        String key, value;
        List<String> strList;
        while(iterator.hasNext()) {
            key = String.valueOf(iterator.next());
            value = PropertyUtil.getProperty(key);

            System.out.println("Key : " + key + ", value : [" + value + "]");

            strList = getList(value);
            System.out.println("List size : " + strList.size());
            System.out.println("List Elements : " + strList);
        }

    }

    public static void printActualKeysForConstants() {
        Set<Object> keys = _properties.keySet();
        Iterator<Object> iterator = keys.iterator();
        String baseKey, uniqueKey, key, value;
        List<String> strList;
        while(iterator.hasNext()) {
            key = String.valueOf(iterator.next());

            uniqueKey = key.substring(key.lastIndexOf(".")+1);
            baseKey = key.substring(0, key.lastIndexOf("."));

            System.out.println("public static final String KEY_" + uniqueKey.toUpperCase() + " = KEY_BASE + KEY_SEPARATOR + \"" + uniqueKey + "\";");

        }
    }

    public static void main(String[] args) {
        System.out.println(PropertyUtil._properties);
        PropertyUtil.printAllProperties();
        PropertyUtil.printActualKeysForConstants();
    }

}
