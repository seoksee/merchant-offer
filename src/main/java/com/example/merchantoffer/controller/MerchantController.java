package com.example.merchantoffer.controller;

import com.example.merchantoffer.exception.ResourceNotFoundException;
import com.example.merchantoffer.model.Merchant;
import com.example.merchantoffer.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MerchantController {

    @Autowired
    MerchantRepository merchantRepository;

    @GetMapping("/merchants")
    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    @PostMapping("/merchants")
    public Merchant createMerchant(@Valid @RequestBody Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @GetMapping("/merchants/{id}")
    public Merchant getMerchantById(@PathVariable(value = "id") Long merchantId) {
        return merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantId));
    }

    @PutMapping("/merchants/{id}")
    public Merchant updateMerchant(@PathVariable(value = "id") Long merchantId, @Valid @RequestBody Merchant merchantDetails) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantId));

        merchant.setName(merchantDetails.getName());
        merchant.setPhone(merchantDetails.getPhone());
        merchant.setAddress(merchantDetails.getAddress());
        //when updating merchant, users are not allowed to change the offers.
        Merchant updatedMerchant = merchantRepository.save(merchant);
        return updatedMerchant;
    }

    @DeleteMapping("/merchants/{id}")
    public ResponseEntity<?> deleteMerchant(@PathVariable(value = "id") Long merchantId) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantId));

        merchantRepository.delete(merchant);

        return ResponseEntity.ok().build();
    }
}
