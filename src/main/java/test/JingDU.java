package test;

import java.io.*;
import java.math.BigDecimal;

/**
 * @Author: lizi
 * @Date: 2020/10/21 10:17 上午
 */
public class JingDU {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try {
            //得到输入流
            in = new FileInputStream("/Users/zhangjingli/Documents/a.txt");
            //得到输出流
            File file = new File("/Users/zhangjingli/Documents/b.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file, true);
            int i;//从输入流读取一定数量的字节，返回 0 到 255 范围内的 int 型字节值
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*public static void main(String[] args) {
        System.out.println("0.05+0.01="+(0.05+0.01));
        BigDecimal f1= new BigDecimal("0.05");
        //BigDecimal f2 =new BigDecimal("0.01");
        BigDecimal f2 =BigDecimal.valueOf(0.01);
        System.out.println(f2.add(f1));
    }*/
}
