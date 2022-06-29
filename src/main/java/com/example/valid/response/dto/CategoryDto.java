package com.example.valid.response.dto;

import com.example.valid.domain.category.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long categoryId;
    private String category;


    //entity의 값을 바로 dto로 반환하기시키기 위해
    public CategoryDto(CategoryEntity categoryEntity){
        this.categoryId = categoryEntity.getCategoryId();
        this.category = categoryEntity.getCategory();
    }

}
