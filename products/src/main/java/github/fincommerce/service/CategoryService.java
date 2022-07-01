package github.fincommerce.service;

import github.fincommerce.entity.Category;
import github.fincommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CategoryService {

    public static final String KEY = "CATEGORIES";

    @Autowired
    private CategoryRepository categoryRepository;

    @Cacheable(value = KEY, key = "#categoryId", unless = "#result == null")
    public Category fetchByCategoryId(BigInteger categoryId) {
        var category = categoryRepository.findByCategoryId(categoryId);

        if (category == null)
            throw new RuntimeException("Unexpected result!");

        return (Category) category;
    }

    @Cacheable(value = KEY, unless = "#result == null")
    public List<Category> fetchAllCategories() {
        return categoryRepository.findAll();
    }
}
