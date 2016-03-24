package controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
