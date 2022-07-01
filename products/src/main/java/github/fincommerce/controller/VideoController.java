package github.fincommerce.controller;

import github.fincommerce.entity.Video;
import github.fincommerce.model.ResponseModel;
import github.fincommerce.service.VideoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Video>> getVideos() {
        return new ResponseModel<>(videoService.fetchAllVideos());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Video> getVideo(@NonNull @PathVariable("id") BigInteger videoId) {

        return new ResponseModel<>(videoService.fetchVideoById(videoId));
    }
}
