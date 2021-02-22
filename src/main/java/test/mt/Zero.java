package test.mt;
/*
 * @author lizi

 * @date  2020/9/25 17:13
 */

public class Zero {

    public static void main(String[] args) {
        int[] a = { 0, 9, 0, 4, 5};
        int[] ints = zeroMove1(a);
        for (int i:ints){
            System.out.println(i);
        }
    }
    //创建一个新的数组存放
    public static int[] zeroMove1(int[] arry){

        int[] b = new int[arry.length];
        int idx = 0;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] != 0) {
                b[idx] = arry[i];
                idx++;
            } else {
                b[b.length - 1 - idx] = arry[i];
            }
        }
        return b;
    }
    //先找出所有不为0的数字，放置在以j=0开始的原数组中
    public static int[] zeroMove2(int[] arry){
        int j =0;
        for(int i=0;i<arry.length;i++){
            if (arry[i]!=0){
                arry[j]=arry[i];
                j++;
            }
        }
        for(int k=j;k<arry.length;k++){
            arry[k]=0;
        }
        return arry;
    }
//没看懂
    public static int[] moveZeroes(int[] nums) {
        int size = nums.length;
        int startIndex = 0;// 0元素开始的位置
        int endIndex = 0;// 0元素结束的位置
        int currentNum;
        int i= 0;
        // 第一步：找到第一个0元素开始的位置
        // 并将第一个0元素的游标赋值给startIndex&endIndex
        while(i < size){
            currentNum = nums[i];
            if (currentNum == 0) {
                startIndex = i;
                endIndex = i;
                break;
            }
            ++i;
        }
        // 如果当前数组中没有找到0元素，则推出
        if (nums[endIndex] != 0)
            return nums;

        // 将当前i的值加1；直接从刚才0元素位置的后一位置开始循环
        ++i;
        while (i < size) {
            currentNum = nums[i];
            if (currentNum == 0){//如果当前元素等于0，则将i值赋值给endIndex
                endIndex = i;
            } else {
                // 如果不为0
                //则将当前元素赋值给nums[startIndex]
                // 并将当前位置的元素赋值为0
                // startIndex和endIndex都加1；
                nums[startIndex] = currentNum;
                nums[i] = 0;
                ++startIndex;
                ++endIndex;
            }
            ++i;
        }
        return nums;
    }

}
