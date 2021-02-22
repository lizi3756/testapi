package com.lizi.utils;

import java.io.*;

public class TestFileUtil {


    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return TestFileUtil.class.getResource("/").getPath();

    }


    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static File readFile(String pathName) {

        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.dir") + File.separator + pathName);
    }


    /**
    * 将字符串写到文件中
    */
    public static void   writeFile(String filepath,String str){
        File file= new File(filepath);
        if(file.exists()){
            file.delete();
        }
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(str);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //writeFile("report/a.txt", "test");
    }
}
