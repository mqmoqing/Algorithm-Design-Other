package study.designMode.single;

/**
 * @author mq
 * @create 2023-02-17 16:42
 */
public class SecurityLazySingleton {
    private SecurityLazySingleton(){}
    private static volatile SecurityLazySingleton singleton = null;
    public static SecurityLazySingleton getSingleton(){
        if(singleton == null){
            synchronized (SecurityLazySingleton.class){
                if(singleton==null){
                    singleton = new SecurityLazySingleton();
                }
            }
        }
        return singleton;
    }

}
