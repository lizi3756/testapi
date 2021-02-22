package test;
/*
 * @author lizi

 * @date  2020/8/6 19:37
 */
//输入ABC，，输出1,2,3
public class excelhang {
    public static void main(String[] args) {
        System.out.println(hang("CAB"));
    }
    public static int  hang(String str){
        int ans=0,len=str.length();
        for(int i = 0;i < len;i++){
            ans =ans*26+(str.charAt(i)-'A'+1);
        }
        return ans ;
    }
}
