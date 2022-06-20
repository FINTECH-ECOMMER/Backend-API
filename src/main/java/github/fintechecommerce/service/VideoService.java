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

    @Cacheable(value = KEY, key = "#videoId", unless = "#result ==  null")
    public Video fetchVideoById(BigInteger videoId) {

        return videoRepository.findByVideoId(videoId);
    }

    @Cacheable(value = KEY, unless = "#result ==  null")
    public List<Video> fetchAllVideos() {

        return videoRepository.findAll();
    }
}
