package study.test;



/**
 * @author mq
 * @create 2022-11-24 15:27
 */
public class Test {

    private Test(){}

    private static volatile Test singleton =null;

    public static Test getSingleton(){
        if(singleton == null){
            synchronized (Test.class){
                if (singleton == null){
                    singleton = new Test();
                }
            }
        }
        return singleton;
    }

}
