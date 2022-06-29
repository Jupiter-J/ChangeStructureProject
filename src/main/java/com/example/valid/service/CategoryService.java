package com.example.valid.service;


import com.example.valid.response.dto.CategoryDto;


import java.util.Collection;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto dto);
    Collection<CategoryDto> readAllCategory();
    CategoryDto readCategory(Long categoryId);
    boolean updateCategory(Long categoryId, CategoryDto dto);
    boolean deleteCategory(Long categoryId);

}
