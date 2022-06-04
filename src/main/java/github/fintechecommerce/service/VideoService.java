package github.fintechecommerce.service;

import github.fintechecommerce.entity.Video;
import github.fintechecommerce.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VideoService {
    public static final String KEY = "VIDEOS";

    @Autowired
    private VideoRepository videoRepository;

    @Cacheable(value = KEY, key = "#videoId", condition = "#result !=  null")
    public Video fetchVideoById(BigInteger videoId) {

        var video    =  videoRepository.findByVideoId(videoId);

        return  video;
    }

    @Cacheable(value = KEY, condition = "#result !=  null")
    public List<Video> fetchAllVideos() {

        return videoRepository.findAll();
    }
}
