package com.javaproject.store;

import com.javaproject.store.entities.Address;
import com.javaproject.store.entities.Profile;
import com.javaproject.store.entities.Tag;
import com.javaproject.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

        public static void main(String[] args) {
//            ApplicationContext context= SpringApplication.run(StoreApplication.class, args);
           var user=User.builder()
                   .name("John")
                   .email("john@gmail.com")
                   .password("1234")
                   .build();


           var profile= Profile.builder()
                           .bio("John")
                                   .build();

           user.setProfile(profile);
           profile.setUser(user);
            System.out.println(user);


        }

}
