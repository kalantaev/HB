package servlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Администратор on 16.03.2016.
 */
public class ServletUtil {
    private static ClassPathXmlApplicationContext context;

    public static ClassPathXmlApplicationContext getContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("servise.xml");
            return context;
        }
        return context;
    }
}
