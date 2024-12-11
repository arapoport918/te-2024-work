package com.techelevator.service;

import com.techelevator.model.TaxRate;

import java.math.BigDecimal;

public interface TaxRateService {

    double getTaxRate(String state);

}
