package servlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Администратор on 16.03.2016.
 */
public class ServletUtil {
    private static ClassPathXmlApplicationContext context;

    {
        context = new ClassPathXmlApplicationContext("servise.xml");
    }

    public static ClassPathXmlApplicationContext getContext() {
        return context;
    }
}
