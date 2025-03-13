package study.test;

/**
 * 字符串测试
 * @author mq
 * @create 2024-12-19 16:05
 */
public class StringTest {
    private Object name;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }


    public static void main(String[] args) {
        String a = "moqing";
        String b = new String("moqing");
        StringTest stringTest = new StringTest();
        stringTest.setName("moqing" );
        String c = stringTest.getName().toString();
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(c==a);
    }
}
