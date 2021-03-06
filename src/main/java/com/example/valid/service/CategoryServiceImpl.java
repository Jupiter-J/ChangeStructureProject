package com.example.valid.service;

import com.example.valid.domain.category.CategoryEntity;
import com.example.valid.domain.category.CategoryRepository;
import com.example.valid.response.ResponseModel;
import com.example.valid.response.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        //set사용하지 않고 build를 사용
        CategoryEntity categoryEntity = CategoryEntity.builder()
                        .category(dto.getCategory()).build();
        categoryEntity = this.categoryRepository.save(categoryEntity);

        return new CategoryDto(categoryEntity);
    }

    @Override
    public Collection<CategoryDto> readAllCategory() {
        List<CategoryDto> categoryDtoList =new ArrayList<>();
        this.categoryRepository.findAll().forEach(categoryEntity ->
                categoryDtoList.add(
                        new CategoryDto(
                                categoryEntity.getCategoryId(),
                                categoryEntity.getCategory()
                        )
                ));

        return categoryDtoList;
    }

    @Override
    public CategoryDto readCategory(Long categoryId) {
        Optional<CategoryEntity> categoryEntityOptional = this.categoryRepository.findById(categoryId);
        if (categoryEntityOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        CategoryEntity categoryEntity = categoryEntityOptional.get();

        return new CategoryDto(
                categoryEntity.getCategoryId(),
                categoryEntity.getCategory()
        );
    }

    @Override
    public boolean updateCategory(Long categoryId, CategoryDto dto) {
        Optional<CategoryEntity> categoryEntityOptional = this.categoryRepository.findById(categoryId);

        if (categoryEntityOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        CategoryEntity categoryEntity = categoryEntityOptional.get();
        categoryEntity.setCategory(dto.getCategory());

        this.categoryRepository.save(categoryEntity);
        return true;
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        Optional<CategoryEntity> categoryEntityOptional = this.categoryRepository.findById(categoryId);
        if (categoryEntityOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        CategoryEntity categoryEntity = categoryEntityOptional.get();
        this.categoryRepository.delete(categoryEntity);

        return true;
    }










}
