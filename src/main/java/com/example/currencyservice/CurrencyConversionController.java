package com.example.currencyservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private String APIKey = "vKqtvA8EVLKTXgDeBwiSrOykB9aynRoc";

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public Object convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", APIKey);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = "https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + quantity.toString();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseObj = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        System.out.println(responseObj);

        return responseObj.getBody();
    }
}
