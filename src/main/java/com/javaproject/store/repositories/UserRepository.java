package com.javaproject.store.repositories;

import com.javaproject.store.dtos.UserSummary;
import com.javaproject.store.entities.Address;
import com.javaproject.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(attributePaths = {"tags","addresses"})
    Optional<User> findByEmail(String email);
    Optional<User> findById(long id);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findAllWithAddress();


    @Query("select u.id as id, u.email as email from User u where u.profile.loyaltyPoints > :loyaltyPoints order by u.email")
    List<UserSummary> findLoyalUsers(@Param("loyaltyPoints") int loyaltyPoints);


}
