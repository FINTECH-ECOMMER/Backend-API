package github.fintechecommerce.controller;

import github.fintechecommerce.model.GeneralResponse;
import github.fintechecommerce.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping(path = "${api_prefix}/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping({"", "/"})
    public GeneralResponse getVideos() {
        return new GeneralResponse(videoService.findAllVideos());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public GeneralResponse getVideo(@PathVariable("id") BigInteger videoId) {

        return new GeneralResponse(videoService.findVideoById(videoId));
    }
}
