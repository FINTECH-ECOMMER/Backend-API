package github.fincommerce.service;

import github.fincommerce.entity.Image;
import github.fincommerce.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ImageService {
    public static final String KEY = "IMAGES";

    @Autowired
    private ImageRepository imageRepository;

    @Cacheable(value = KEY, key = "#imageId", unless = "#result ==  null")
    public Image fetchImageById(BigInteger imageId) {

        return imageRepository.findByImageId(imageId);
    }

    @Cacheable(value = KEY, unless = "#result ==  null")
    public List<Image> fetchAllImages() {

        return imageRepository.findAll();
    }
}
