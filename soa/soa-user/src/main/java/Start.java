import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZhengQin
 */
public class Start {
    public static void main(String[] args) throws Exception{
        //com.alibaba.dubbo.container.Main.main(args);
        (new ClassPathXmlApplicationContext(new String[] { "classpath:/spring/spring-config.xml" })).start();
        // 保持main方法不退出
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }
}
