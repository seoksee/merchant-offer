package com.example.merchantoffer.controller;

import com.example.merchantoffer.exception.ResourceNotFoundException;
import com.example.merchantoffer.model.Offer;
import com.example.merchantoffer.model.OfferType;
import com.example.merchantoffer.repository.OfferRepository;
import com.example.merchantoffer.repository.OfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OfferController {

    private static int currentPage = 1;
    private static int pageSize = 5;

    @Autowired
    OfferRepository offerRepository;

//    @GetMapping("/offers")
//    public List<Offer> getAllOffers() {
//        return offerRepository.findAll();
//    }

    @GetMapping("/offers")
    public Page<Offer> search(@RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size,
                              @RequestParam("offerType") Optional<OfferType>  offerType) {
        page.ifPresent(p -> currentPage = p);
        size.ifPresent(s -> pageSize = s);
        Sort sort = Sort.by(new Order(Sort.Direction.DESC, "id"));

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, sort);

        if(offerType == null)
            return offerRepository.findAll(pageable);
        else
            return offerRepository.findByOfferType(offerType, pageable);
    }

    @PostMapping("/offers")
    public Offer createOffer(@Valid @RequestBody Offer offer) {
        return offerRepository.save(offer);
    }

    @GetMapping("/offers/{id}")
    public Offer getOfferById(@PathVariable(value="id") Long offerId) {
        return offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer", "id", offerId));
    }

    @PutMapping("/offers/{id}")
    public Offer updateOffer(@PathVariable(value="id") Long offerId, @Valid @RequestBody Offer offerDetails) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer", "id", offerId));

        offer.setName(offerDetails.getName());
        offer.setDescription(offerDetails.getDescription());
        offer.setOfferType(offerDetails.getOfferType());
//        offer.setOfferTypeId(offerDetails.getOfferTypeId());
        offer.setPoints(offerDetails.getPoints());
        offer.setCashRebate(offerDetails.getCashRebate());
        offer.setStartDate(offerDetails.getStartDate());
        offer.setEndDate(offerDetails.getEndDate());

        Offer updatedOffer = offerRepository.save(offer);
        return updatedOffer;
    }

    @DeleteMapping("/offers/{id}")
    public ResponseEntity<?> deleteOffer(@PathVariable(value = "id") Long offerId) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer", "id", offerId));
        offerRepository.delete(offer);

        return ResponseEntity.ok().build();
    }
}
