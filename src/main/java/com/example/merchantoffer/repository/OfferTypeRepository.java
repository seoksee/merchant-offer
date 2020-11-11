package com.example.merchantoffer.repository;

import com.example.merchantoffer.model.OfferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferTypeRepository extends JpaRepository<OfferType, Long> {

    @Query("select name from offer_types")
    List<String> findName();
}
