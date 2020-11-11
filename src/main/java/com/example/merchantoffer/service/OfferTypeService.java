package com.example.merchantoffer.service;

import com.example.merchantoffer.model.OfferType;
import com.example.merchantoffer.repository.OfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferTypeService {

    @Autowired
    OfferTypeRepository offerTypeRepository;

    public List<String> findName() {
        List<String> offerTypes = offerTypeRepository.findName();
        return offerTypes;
    }
}
