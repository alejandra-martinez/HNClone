package com.example.HackerNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class HNService {
    @Autowired
    private RestTemplate restTemplate;
    private final String baseUrl = "https://hacker-news.firebaseio.com/v0/";


    public long[] getBestStories() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(baseUrl+"beststories.json" , HttpMethod.GET, entity, long[].class).getBody();
    }

    public ResponseEntity<Story> getStory(long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return new ResponseEntity<Story>(restTemplate.getForObject(baseUrl+"/item/"+id+".json",Story.class),HttpStatus.OK);

    }
}