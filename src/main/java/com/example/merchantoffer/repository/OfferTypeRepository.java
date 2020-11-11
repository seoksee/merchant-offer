package com.example.merchantoffer.repository;

import com.example.merchantoffer.model.OfferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferTypeRepository extends JpaRepository<OfferType, Long> {
}
