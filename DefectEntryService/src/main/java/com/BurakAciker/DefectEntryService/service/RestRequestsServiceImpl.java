package com.BurakAciker.DefectEntryService.service;


import com.BurakAciker.DefectEntryService.resource.DefectEntryServiceController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class RestRequestsServiceImpl implements RestRequestsService {
    private final Logger logger = LogManager.getLogger(DefectEntryServiceController.class);
    @Value("${host}")
    private String host;
    @Override
    public String roleCheck (String role, String token) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://"+host+":3000/api/v1/auth/is"+role;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        logger.info("Role check request sent parameters: role:"+role+" token:"+token);
        return restTemplate.postForObject(url, entity, String.class);
    }

}