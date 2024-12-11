package com.techelevator.service;

import org.springframework.web.client.RestTemplate;

public class RestTaxRateService implements TaxRateService {


    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public double getTaxRate(String state) {
        return restTemplate.getForObject("https://teapi.netlify.app/api/statetax?state=" + state, double.class);
    }
}
