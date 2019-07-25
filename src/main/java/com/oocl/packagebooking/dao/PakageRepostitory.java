package com.oocl.packagebooking.dao;

import com.oocl.packagebooking.entity.Pakage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PakageRepostitory extends JpaRepository<Pakage,Integer> {
    @Query(value = "select * from PAKAGE where STATUS = ?1",nativeQuery = true)
    List<Pakage> findAllPakageByStatus(int status);
}
