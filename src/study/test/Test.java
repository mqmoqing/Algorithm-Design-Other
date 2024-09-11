package study.test;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author mq
 * @create 2022-11-24 15:27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Test.addNum("0000"));
    }
    public static String addNum(String str) {
        String numStr = str.substring(str.length() - 4); //取出最后四位数字
        if (!numStr.equals("")) { //如果最后四位不是数字，抛NumberFormatException异常
            int n = numStr.length(); //取出字符串的长度
            int num = Integer.parseInt(numStr) + 1; //将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return str.subSequence(0, str.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

}
