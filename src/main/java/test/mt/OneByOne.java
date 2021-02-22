package test.mt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
 * @author lizi
 * @date  2020/8/18 15:21
 */
//一行一行读文件，然后统计词频
public class OneByOne {
    public static void main(String[] args) throws Exception {
        String filePath="C:\\Users\\zhangjingli\\Desktop\\11.txt";
        String s=null;
        Map<String,Integer> map=new HashMap<String,Integer>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"))) {
          while((s=br.readLine())!=null){
               String[] str = s.split("\\s+");//分割，多空格的时候正则表达式    \s表示匹配任何空白字符，+表示匹配一次或多次。
              for (String s1:str) {//判断每一行，如果map中存在key=s1的，则其value+1;如果不存在，则增加
                  if(!map.containsKey(s1)){
                      map.put(s1,1);
                  }else {
                      map.put(s1,map.get(s1)+1);
                  }
              }
           }

        }catch (Exception e){
            e.printStackTrace();
        }
        for (Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+"的个数为："+entry.getValue());
        }
    }
}
