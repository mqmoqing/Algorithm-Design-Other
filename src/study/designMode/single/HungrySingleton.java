package study.designMode.single;

/**
 * @author mq
 * @create 2023-02-17 16:19
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getSingleton() {
        return singleton;
    }
}
