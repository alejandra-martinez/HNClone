package com.example.HackerNews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HNService service;


    @RequestMapping(value = "/beststories")
    public long[] getBestStories() {
        return service.getBestStories();
    }

    @RequestMapping(value="story/{id}")
    public ResponseEntity<Story> getStory(@PathVariable long id){
        return service.getStory(id);
    }
}
