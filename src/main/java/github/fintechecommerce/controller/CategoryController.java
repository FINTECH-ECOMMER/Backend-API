package github.fintechecommerce.controller;


import github.fintechecommerce.entity.Category;
import github.fintechecommerce.model.ResponseModel;
import github.fintechecommerce.service.CategoryService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Category>> getCategories(){return new ResponseModel<>(categoryService.fetchAllCategories());}

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Category> getCategory(@NonNull @PathVariable("id") BigInteger categoryId){
        return  new ResponseModel<>(categoryService.fetchByCategoryId(categoryId));
    }
}
