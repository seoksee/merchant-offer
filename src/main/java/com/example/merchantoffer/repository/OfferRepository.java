package com.example.merchantoffer.repository;

import com.example.merchantoffer.model.Offer;
import com.example.merchantoffer.model.OfferType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Page<Offer> findByOfferType(Optional<OfferType> id, Pageable pageable);
}
