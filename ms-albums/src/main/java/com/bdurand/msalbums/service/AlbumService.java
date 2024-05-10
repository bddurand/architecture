package com.bdurand.msalbums.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {


    @Autowired
    RestTemplate restTemplate;

    public String getAlbums() {
        String url = "https://jsonplaceholder.typicode.com/albums";
        return restTemplate.getForObject(url, String.class);
    }
}
