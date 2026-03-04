package com.ottclone.Controller;

import com.ottclone.Entity.Video;
import com.ottclone.Service.YoutubeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/youtube")
public class YoutubeController {

    private final YoutubeService youtubeService;

    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @GetMapping("/search")
    public List<Video> search(@RequestParam String query) {

        return youtubeService.searchVideos(query);

    }
}