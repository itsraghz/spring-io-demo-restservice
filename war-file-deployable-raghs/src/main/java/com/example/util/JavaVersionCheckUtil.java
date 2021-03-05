package com.example.util;

public class JavaVersionCheckUtil {
    public static void getJavaVersion() {
        //System.out.println("JAVA DEV       ver.: " + com.sun.deploy.config.BuiltInProperties.CURRENT_VERSION);
        System.out.println("JAVA RUN     v. X.Y: " + System.getProperty("java.specification.version") );
        //System.out.println("JAVA RUN v. W.X.Y.Z: " + com.sun.deploy.config.Config.getJavaVersion() ); //_javaVersionProperty
        System.out.println("JAVA RUN  full ver.: " + System.getProperty("java.runtime.version")  + " (may return unknown)" );
        //System.out.println("JAVA RUN       type: " + com.sun.deploy.config.Config.getJavaRuntimeNameProperty() );
    }
}
