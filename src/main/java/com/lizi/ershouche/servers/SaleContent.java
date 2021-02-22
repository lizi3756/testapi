package com.lizi.ershouche.servers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author: lizi
 * @Date: 2020/10/26 2:21 下午
 * 测试从excel中读取商机id（zhaosiyu_wb）
 */
public class SaleContent {
    public static  String cookies ="id58=CoDYml9xiy1R9chlAwMDAg==; _bu=2018052914320018250fd5; bj58bsp_login_token_shccrm=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYwMzczNDgwNCwic3lzIjoic2hjY3JtIiwiaWF0IjoxNjAzNjkxNjA0LCJ1c2VySWQiOiIyMDE4MDUyOTE0MzIwMDE4MjUwZmQ1IiwianRpIjoiMjAyMDEwMjYxMzUzMjQxYzgwZjIwYiIsIm9yZ0lkIjoiMjAyMDA2MDExMDAyMDAxMzUyNjgzZiIsImVtYWlsIjoiemhhbmdqaW5nbGlANTguY29tIiwicmVhbG5hbWUiOiLlvKDmlazkuL0ifQ.xSdI0jWtuBR0Cosi6y-N78S8rroPM_g7PzB8ePpyQxQ; bj58bsp_logininfo=userid%3D2018052914320018250fd5%26username%3Dzhangjingli%26realname%3D%E5%BC%A0%E6%95%AC%E4%B8%BD%26orgid%3D202006011002001352683f%26dutyid%3D201101101655507f728cae%26eamil%3Dzhangjingli%4058.com%26dutyid%3D201101101655507f728cae%26siteTime%3D05BD738AA7AC149D500125E90F3286D011B626AF9EF581D5B%26sitekey%3D8C465C6879B682586E49393FDACCB419A183B10E8002D2903B94556BEF1A7FB07; bj58bsp_login_token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1OCBHcm91cCBFbXBsb3llZXMiLCJhdWQiOiJ6aGFuZ2ppbmdsaSIsImlzcyI6IjU4IG1pcyBlcCIsImV4cCI6MTYwMzc3OTEwNywiaWF0IjoxNjAzNjkyNzA3LCJqdGkiOiIyMDE4MDUyOTE0MzIwMDE4MjUwZmQ1In0.9XMc21ekmJnW8e0GIF56iZ6QTQpi4aCWf1HTD3NZCSs; JSESSIONID=A7C1F51788532F7B5376CBC82A8CB931";
    //读取excel中的商机id
    public static void readExcel(String filePath)  {
        try {
            XSSFWorkbook workbook =new XSSFWorkbook(filePath);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            for(int i = firstRowNum;i<=lastRowNum;i++){
                String s = sheet.getRow(i).getCell(0).toString();
                //System.out.println("第"+i+"行的内容为"+s);
                getContent(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void getContent(String id) throws Exception {
        HttpGet getMethod;
        String url ="http://shccrmv2.union.vip.58.com/cardealer/cardealerdtl/"+id;
        CloseableHttpClient httpClient =HttpClients.createDefault();
        getMethod= new HttpGet(url);
        getMethod.addHeader("Cookie",cookies);
        HttpResponse response=httpClient.execute(getMethod);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);
    }



    public static void main(String[] args) throws Exception {
        //readExcel("/Users/zhangjingli/1.xlsx");
        //getContent("1305448590138728450");

    }
}
