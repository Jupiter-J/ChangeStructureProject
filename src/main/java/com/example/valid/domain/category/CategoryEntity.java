package com.example.valid.domain.category;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Builder
@Data //setter로 변경하기
@Table(name = "CategoryEntity")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotEmpty(message = "공백이 안됩니다")
    @Size( max = 20, message = "20글자 이하만 가능")
    private String category;

    public CategoryEntity(){

    }
    //생성과 동시에 바로 빌더를 사용하여 수정을 하기 위해서 (set없애기) -> 빌더패턴을 사용
    public CategoryEntity(Long categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }
}

