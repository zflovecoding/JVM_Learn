package com.geekpig.classloader;


import com.sun.deploy.uitoolkit.impl.fx.FXWindow;
import com.sun.nio.zipfs.ZipInfo;
import sun.misc.Launcher;
import sun.security.util.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("============Bootstrap class loader=================");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("===========extension class loader========");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:扩展类加载器
        ClassLoader classLoader1 = ZipInfo.class.getClassLoader();/*

        //JDK1.8.0_311: why?
        if CurveDB.class.getClassLoader()-------------classLoader1=null
        if FXWindow.class.getClassLoader()-------------NoClassDefFoundErrorException
        if ZipInfo.class.getClassLoader()-------------sun.misc.Launcher$ExtClassLoader@677327b6

        */
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@1540e19d

    }


}
