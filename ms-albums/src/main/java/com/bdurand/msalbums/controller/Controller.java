package com.bdurand.msalbums.controller;

import com.bdurand.msalbums.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    AlbumService albumService;

    @GetMapping("/albums")
    public String getAll() {
        return albumService.getAlbums();
    }
}
