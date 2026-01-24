package com.javaproject.store.services;

import com.javaproject.store.entities.Address;
import com.javaproject.store.entities.Category;
import com.javaproject.store.entities.Product;
import com.javaproject.store.entities.User;
import com.javaproject.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final EntityManager em;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showEntityStates(){
        var user= User.builder()
                .name("John Doe")
                .email("johndoe@gmail.com")
                .password("12345")
                .build();

        if(em.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");


        userRepository.save(user);

        if(em.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");



    }


    @Transactional
    public void showRelatedEntities(){
//        var user = userRepository.findById(2L).orElseThrow();
//        System.out.println(user.getEmail());

        var profile= profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getName());
    }


    public void fetchAddresses(){
        var address= addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getUser().getName());

    }

    public void persistRelated(){
        var user= User.builder()
                .name("John Doe")
                .email("johndoe@gmail.com")
                .password("12345")
                .build();

        var address= Address.builder()
                .street("123 Main St")
                .city("Main St")
                .zip("12345")
                .state("state")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated(){
        var user=userRepository.findById(5L).orElseThrow();
        var address=user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }


    @Transactional
    public void manageProducts() {
//        var user= userRepository.findById(2L).orElseThrow();
//        var products= productRepository.findAll();
//        products.forEach(user::addFavoriteProduct);
//        userRepository.save(user);
//

        productRepository.deleteById(4L);


//        var category= categoryRepository.findById((byte)1).orElseThrow();
//
//        var product = Product.builder()
//                .name("product 2")
//                .description("description 2")
//                .price(BigDecimal.valueOf(10.00))
//                .category(category)
//                .build();
//
//        productRepository.save(product);



    }

    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10),(byte)1);
    }

    @Transactional
    public void fetchProducts(){
        var products=productRepository.findProducts(BigDecimal.valueOf(1), BigDecimal.valueOf(15));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUser(){
        var user= userRepository.findByEmail("johnsmith@gmail.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers(){
        var users= userRepository.findAllWithAddress();

        users.forEach(u->{
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }


}
