package com.nimvb.app.service.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtil {

    public static String parentPackage(Class<?> clazz) {
        String currentPackage = clazz.getPackage().getName();
        return (currentPackage.substring(0, currentPackage.lastIndexOf(".")));
    }

    public static URL parentPackageURI(Class<?> clazz) {
        String parentPackage = parentPackage(clazz);
        if (!parentPackage.startsWith(".")) {
            parentPackage = String.format(".%s", parentPackage);
            if (!parentPackage.endsWith(".")) {
                parentPackage = String.format("%s.", parentPackage);
            }
        }
        parentPackage = parentPackage.replaceAll("\\.", "/");
        return clazz.getResource(parentPackage);
    }

    public static File parentPackageAsFile(Class<?> clazz) {
        return new File(parentPackageURI(clazz).getFile());
    }

    public static List<Class<?>> getChildClasses(File file, Class<?> superClass) {
        return getClasses(
                file
                , dir -> dir.endsWith(".class")
                , path -> {
                    String parentPackage = parentPackage(superClass);
                    path = path.substring(0, path.lastIndexOf(".class"));
                    path = path.replaceAll("/", ".");
                    path = String.format("%s.%s", parentPackage, path);
                    return path;
                }
                , clazz -> {

                    if (clazz.getSuperclass().getName().equals(superClass.getName())) {
                        return true;
                    }
                    return false;
                });
    }

    public static List<Class<?>> getClasses(File file, DirectoryItemFilter filter, DirectoryItemMap itemMap, ClazzFilter clazzFilter) {
        List<Class<?>> clazzes = new ArrayList<>();
        if (file.isDirectory()) {
            for (String item : file.list()) {
                if (filter.filter(item)) {
                    item = itemMap.map(item);
                    try {
                        Class<?> clazz = Class.forName(item);
                        if (clazzFilter.filter(clazz)) {
                            clazzes.add(clazz);
                        }

                    } catch (ClassNotFoundException e) {

                    }
                }
            }


        }
        return clazzes;
    }

    public interface DirectoryItemFilter {

        public boolean filter(String dir);
    }

    public interface DirectoryItemMap {
        public String map(String path);
    }

    public interface ClazzFilter {
        public boolean filter(Class<?> clazz);
    }
}
