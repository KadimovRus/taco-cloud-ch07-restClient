package com.example.tacocloudch07restclient;

import com.example.tacocloudch07restclient.config.MyConfig;
import com.example.tacocloudch07restclient.entity.Ingredient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class TacoCloudCh07RestClientApplication {

    public static void main(String[] args) {
        //SpringApplication.run(TacoCloudCh07RestClientApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        RestClient restClient = context.getBean("restClient", RestClient.class);

        Ingredient ingredient = restClient.getIngredientById("FLTO");

        System.out.println(ingredient);
    }

}
