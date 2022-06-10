package github.fintechecommerce.controller;

import github.fintechecommerce.entity.Image;
import github.fintechecommerce.model.ResponseModel;
import github.fintechecommerce.service.ImageService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Image>> getImages() {
        return new ResponseModel<>(imageService.fetchAllImages());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Image> getImage(@NonNull @PathVariable("id") BigInteger ImageId) {

        return new ResponseModel<>(imageService.fetchImageById(ImageId));
    }
}
