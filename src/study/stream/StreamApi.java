package study.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author mq
 * @create 2022-10-14 10:43
 */
public class StreamApi {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    //练习1
    @Test
    public void test1(){
        Collections.sort(emps, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException  {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        System.out.println("***********************");

        Runnable r2 = () -> System.out.println("我爱北京故宫");

        r2.run();
    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12,21);
        System.out.println(compare1);

        System.out.println("***********************");
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(32,21);
        System.out.println(compare2);


        System.out.println("***********************");
        //方法引用
        Comparator<Integer> com3 = Integer :: compare;

        int compare3 = com3.compare(32,21);
        System.out.println(compare3);
    }
    //练习4
    @Test
    public void test4(){

    }

//    //练习2
//    @Test
//    public void test2(){
//        String trimStr = strHandler("\t\t\t 尚硅谷IT教育   ", (str) -> str.trim());
//        System.out.println(trimStr);
//
//        String upper = strHandler("abcdef", (str) -> str.toUpperCase());
//        System.out.println(upper);
//
//        String newStr = strHandler("世界那么大，我想去看看", (str) -> str.substring(2, 5));
//        System.out.println(newStr);
//    }
//
//    //需求：用于处理字符串
//    public String strHandler(String str, MyFunction mf){
//        return mf.getValue(str);
//    }
//
//    //练习3
//    @Test
//    public void test3(){
//        op(100L, 200L, (x, y) -> x + y);
//
//        op(100L, 200L, (x, y) -> x * y);
//    }
//
//    //需求：对于两个 Long 型数据进行处理
//    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
//        System.out.println(mf.getValue(l1, l2));
//    }

}
