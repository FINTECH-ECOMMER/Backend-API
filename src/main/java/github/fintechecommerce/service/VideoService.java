package github.fintechecommerce.service;

import github.fintechecommerce.entity.Product;
import github.fintechecommerce.entity.Video;
import github.fintechecommerce.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;


    public Video findVideoById(BigInteger videoId) {

        return videoRepository.findByVideoId(videoId);
    }

    public List<Video> findAllVideos() {

        return videoRepository.findAll();
    }
}
