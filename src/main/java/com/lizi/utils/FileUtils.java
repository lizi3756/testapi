package com.lizi.utils;
/*
 * @author lizi

 * @date  2020/7/14 14:39
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.IOException;
public class FileUtils {
    private static final Log log = LogFactory.getLog(FileUtils.class);


    /**
     * 根据文件全路径判断文件是否存在
     *
     * @param filePath
     * @return 存在/不存在
     */
    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * 根据文件全路径判断文件是否存在
     * 存在：返回该文件
     * 不存在：创建文件并返回
     *
     * @param filePath
     * @return 该文件
     */
    public static File isFileExistsAndCreateFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                log.error(filePath + "create failed!");
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 根据目录全路径判断是否存在
     * 存在：返回该目录
     * 不存在：创建目录并返回
     *
     * @param dirPath
     * @return 该文件
     */
    public static File isDirExistsAndCreateDirReFile(String dirPath) {
        File file =new File(dirPath);
        //如果文件夹不存在则创建
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("目录不存在");
            file.mkdir();
            return file;
        } else {
            System.out.println("目录存在");
            return file;
        }
    }


    /**
     * 根据目录全路径判断是否存在
     * 存在：返回该目录
     * 不存在：创建目录并返回
     *
     * @param dirPath
     * @return 该文件
     */
    public static String isDirExistsAndCreateDirReStr(String dirPath) {
        File file =new File(dirPath);
        //如果文件夹不存在则创建
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("目录不存在");
            file.mkdir();
        } else {
            System.out.println("目录存在");
        }
        return dirPath;

    }

    /**
     * 根据目录全路径判断是否存在
     *
     * @param dirPath
     * @return 存在/不存在
     */
    public static boolean isDirExists(String dirPath) {
        File file =new File(dirPath);

        if (!file.exists() && !file.isDirectory()) {
            return false;
        } else {
            System.out.println("目录存在");
            return true;
        }
    }

    public static void main(String[] args) {
        File dirExists = isFileExistsAndCreateFile("/Users/zhangjingli/Work1/1.txt");
        System.out.println(dirExists);
    }
}

