package com.javaproject.store.repositories;

import com.javaproject.store.dtos.UserSummary;
import com.javaproject.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {



    List<Profile> findByLoyaltyPointsGreaterThan(int loyaltyPoints);


}
