package com.example.merchantoffer.controller;

import com.example.merchantoffer.exception.ResourceNotFoundException;
import com.example.merchantoffer.model.OfferType;
import com.example.merchantoffer.repository.OfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OfferTypeController {

    @Autowired
    OfferTypeRepository offerTypeRepository;

    @GetMapping("/offerTypes")
    public List<OfferType> getAllOfferTypes() {
        return offerTypeRepository.findAll();
    }

    @GetMapping("/offerTypeNames")
    public List<String> getAllOfferTypeNames() {
        return offerTypeRepository.findName();
    }

    @PostMapping("/offerTypes")
    public OfferType createOfferType(@Valid @RequestBody OfferType offerType) {
        return offerTypeRepository.save(offerType);
    }

    @GetMapping("/offerTypes/{id}")
    public OfferType getOfferTypeById(@PathVariable(value="id") Long offerTypeId) {
        return offerTypeRepository.findById(offerTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("OfferType", "id", offerTypeId));
    }

    @PutMapping("/offerTypes/{id}")
    public OfferType updateOfferType(@PathVariable(value="id") Long offerTypeId, @Valid @RequestBody OfferType offerTypeDetails) {
        OfferType offerType = offerTypeRepository.findById(offerTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("OfferType", "id", offerTypeId));

        offerType.setName(offerTypeDetails.getName());

        OfferType updatedOfferType = offerTypeRepository.save(offerType);
        return updatedOfferType;
    }

    @DeleteMapping("/offerTypes/{id}")
    public ResponseEntity<?> deleteOfferType(@PathVariable(value = "id") Long offerTypeId) {
        OfferType offerType = offerTypeRepository.findById(offerTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("OfferType", "id", offerTypeId));
        offerTypeRepository.delete(offerType);

        return ResponseEntity.ok().build();
    }
}
