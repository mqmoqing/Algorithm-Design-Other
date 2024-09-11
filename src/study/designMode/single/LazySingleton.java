package study.designMode.single;

/**
 * @author mq
 * @create 2023-02-17 16:27
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    public LazySingleton(){}
    public static synchronized LazySingleton getlazySingleton(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
