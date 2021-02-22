package test;

import java.io.*;

/**
 * @Author: lizi
 * @Date: 2020/10/22 8:24 下午
 * 字符流，读取文件内容
 */
public class ReadFile {
    public static void main(String[] args) throws Exception {
        readFile1("/Users/zhangjingli/Documents/a.txt");
       // readFile3("/Users/zhangjingli/Documents/a.txt");
       // readFile4("/Users/zhangjingli/Documents/a.txt");
    }
    public static void readFile1(String filepath) throws Exception{
        InputStream inputStream =null;
        OutputStream outputStream =null;
        File file=new File("/Users/zhangjingli/Documents/1.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        try{
            inputStream =new FileInputStream(filepath);
            outputStream =new FileOutputStream(file);
            byte[] bytes =new byte[64];
            int i;
            while ((i= inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,i);
                outputStream.flush();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void readFile2(String filepath){
        Reader reader =null;
        Writer writer =null;
        try{
            reader= new FileReader(filepath);
            writer =new FileWriter("/Users/zhangjingli/Documents/2.txt");
            char[] chars = new char[64];
            int i;
             while ((i=reader.read(chars))!=-1){
                 writer.write(chars, 0, i);
                 writer.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile3(String filepath){
        BufferedInputStream bi =null;
        BufferedOutputStream bo =null;
        try {
            bi = new BufferedInputStream(new FileInputStream(filepath));
            bo = new BufferedOutputStream(new FileOutputStream("/Users/zhangjingli/Documents/3.txt"));
            byte[] b = new byte[1024];
            int i;
            while ((i = bi.read(b))!= -1){
                bo.write(b,0,i);
                bo.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bi !=null){
                    bi.close();
                }
                if(bo !=null){
                    bo.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }    //字符缓冲流
    public static void readFile4(String filepath) throws Exception {
        BufferedReader br = null;
        BufferedWriter bw = null;
        File file = new File(filepath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            bw = new BufferedWriter(new FileWriter("/Users/zhangjingli/Documents/c.txt"));

            String s;
            while ((s=br.readLine()) != null){
                //(s=br.readLine())!=""//报空指针，文件结束的判断为null
                bw.write(s);
                bw.newLine();//按行读取，写入一个分行符，否则所有内容都在一行显示
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(br!=null){
                    br.close();
                }
                if(bw!=null){
                    bw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
