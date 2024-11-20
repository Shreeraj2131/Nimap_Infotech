package com.nimap.demo.service;

import com.nimap.demo.entity.Category;
import com.nimap.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    public Page<Category> getAllCategories(int page) {
        return categoryRepository.findAll(PageRequest.of(page - 1, 10));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
