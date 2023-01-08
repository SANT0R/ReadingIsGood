package com.msantor.bookshop.dto;

import com.msantor.bookshop.dto.base.BaseDTO;
import com.msantor.bookshop.model.ClientEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends BaseDTO {


    private static final long serialVersionUID = -8346283353054250213L;
    private LocalDate startDate;

    private LocalDate finishDate ;

    private LocalDate returnDate;

    private Set<BookDTO> books = new HashSet<>();

    private ClientEntity clientEntity;

}