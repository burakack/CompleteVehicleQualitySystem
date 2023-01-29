package com.BurakAciker.UserManagementService.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class RestRequestsServiceImpl implements RestRequestsService {

    @Override
    public String roleCheck (String role, String token) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:3000/api/v1/auth/is"+role;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        return restTemplate.postForObject(url, entity, String.class);
    }

}