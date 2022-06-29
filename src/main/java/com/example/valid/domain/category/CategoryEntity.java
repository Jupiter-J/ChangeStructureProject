package com.example.valid.domain.category;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(name = "CategoryEntity")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotEmpty(message = "공백이 안됩니다")
    @Size( max = 20, message = "20글자 이하만 가능")
    private String category;



}
