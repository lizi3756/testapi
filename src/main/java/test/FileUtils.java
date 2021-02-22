package test;
/*
 * @author lizi

 * @date  2020/8/18 14:08
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtils {

    public static void main(String[] args)throws Exception{
//文件bai绝对路径du改成你自己的文件路径
        FileReader fr=new FileReader("D:\\workspace\\MyLearn\\count.txt");
//可以换成工程目录下的其他文本文件
        BufferedReader br=new BufferedReader(fr);
        while(br.readLine()!=null){
            String s=br.readLine();
            System.out.println(s);
        }
        br.close();
    }

}