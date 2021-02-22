package data;
/*
 * @author lizi

 * @date  2020/7/24 16:56
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class BigDataFast {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
        long start = System.currentTimeMillis();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection(
                        "jdbc:mysql://test-bic01.db.58dns.org:53004/db58_shc_trade_saas",
                        "trade_saas_wr", "4cd208420073bcba");

        connection.setAutoCommit(false);
        PreparedStatement cmd = connection
                .prepareStatement("insert into t_local_copy2(code,name) values(?,?)");

        for (int i = 0; i < 1000; i++) {

            // cmd.setInt(1, i);
            int code =i+20000;
            cmd.setInt(1, code);
            String string=getRandomString(4);
            cmd.setString(2,string);
            cmd.addBatch();
            if(i%100==0){
                cmd.executeBatch();
            }
        }
        cmd.executeBatch();
        connection.commit();

        cmd.close();
        connection.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);//从62个字母和数字中随机取一个
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
