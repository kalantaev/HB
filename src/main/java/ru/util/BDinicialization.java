package ru.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;
import ru.DAO.CommentariyDAO;
import ru.DAO.ContentDAO;
import ru.DAO.UserDAO;
import ru.entity.Commentariy;
import ru.entity.Content;
import ru.entity.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalantaev Alexandr on 15.05.2016.
 */
//@Configuration
public class BDinicialization {


        ///@Bean(name = "dataSource")
        public DataSource dataSource() {
            System.out.println("!!!!!!!!!!!!!!!!!!");
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("classpath:myscript.sql")
                    .build();
        }



}
