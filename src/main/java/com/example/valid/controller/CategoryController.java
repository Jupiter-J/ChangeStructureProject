package com.example.valid.controller;


import com.example.valid.response.dto.CategoryDto;
import com.example.valid.service.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;
    public CategoryController(CategoryServiceImpl categoryServiceImpl){
        this.categoryServiceImpl = categoryServiceImpl;
    }


    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto){
        //파라미터로 받는다 -> valid 어노테이션 검색
        return ResponseEntity.ok(categoryServiceImpl.createCategory(dto));
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDto>> readAllCategory(){
        return ResponseEntity.ok(categoryServiceImpl.readAllCategory());
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> readCategory(@PathVariable("categoryId") Long categoryId){

        CategoryDto categoryDto = this.categoryServiceImpl.readCategory(categoryId);

        if (categoryDto == null)
            return ResponseEntity
                    .notFound()
                    .build();
        else
            return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable("categoryId") Long categoryId,
                                                      @RequestBody CategoryDto dto){

        if (!categoryServiceImpl.updateCategory(categoryId, dto))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoryId);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Long categoryId){
        if (!categoryServiceImpl.deleteCategory(categoryId))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoryId);
    }






}
