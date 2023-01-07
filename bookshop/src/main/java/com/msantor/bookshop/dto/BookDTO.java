package com.msantor.bookshop.dto;

import com.msantor.bookshop.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookDTO extends BaseDTO {

    private static final long serialVersionUID = 3983723742950421458L;
    private String fullName;

    private String publisher;

    private LocalDate releaseYear;

    private String type;

    private String description;

    private int page;

    private int stock;



}