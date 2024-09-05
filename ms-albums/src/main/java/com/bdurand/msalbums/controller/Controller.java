package com.bdurand.msalbums.controller;

import com.bdurand.msalbums.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
public class Controller {

    @Autowired
    AlbumService albumService;

    @GetMapping
    public String getAll() {
        return albumService.getAlbums();
    }
}
