package test;
/*
 * @author lizi

 * @date  2020/8/18 15:17
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AllAsString {
    public static void main(String[] args) throws Exception {
       /* String filePath="/Users/zhangjingli/Documents/a.txt";
        String read = read(filePath);//读取文件中的内容，返回string
        String data = data(read);
        String[] str = data.split(" ");
        find(str);*/
        data("im  is  a goo ");

    }
    //以空格分割（多个空格算一个），输出
    public static String data(String s){
        //String[] str = s.split("\\s+");
        String[] str = s.split(" +");
        int len= str.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(str[i]+" ");//正序输出
            //sb.append(str[len-i-1]+" ");逆序输出
        }
        System.out.println("data方法的输出："+sb.toString());
        return sb.toString();
    }
    public static String read(String filePath) throws Exception {
        File file = new File(filePath);
        StringBuilder sb=new StringBuilder();//存放文件中的内容
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"))) {
            String s = null;
            while ((s=br.readLine())!= null) {
                sb.append(s+" ");
                //System.out.println(s);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static  void  find(String str[]){

        Map<String,Integer> map =new HashMap<String,Integer>();
        for (String s: str) {
            if(!s.equals(" ")){
                if(!map.containsKey(s)){//map里面没有，就增加，有的话，就+1
                    map.put(s,1);
                }else {
                    map.put(s,map.get(s)+1);
                }

            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println("key="+entry.getKey()+" and value "+entry.getValue());
        }

    }
}
