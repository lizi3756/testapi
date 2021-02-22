package test;
/*
 * @author lizi

 * @date  2020/8/6 19:53
 */
//输入2056,输出“CAB”
public class excellie {
    public static String lie(int index){
        StringBuilder sb =new StringBuilder();
        if(index<0){
            return "bucunzai";
        }
        while(index>0){
            index--;
            sb.append((char)(index%26+'A'));
            index = index/26;
        }
        System.out.println(sb.reverse());
        return "s";
    }

    public static void main(String[] args) {
        lie(2056);
    }

}
