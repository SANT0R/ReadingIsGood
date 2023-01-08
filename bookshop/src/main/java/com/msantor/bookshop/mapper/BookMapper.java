package com.msantor.bookshop.mapper;

import com.msantor.bookshop.dto.BookDTO;
import com.msantor.bookshop.model.BookEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Named("toEntity")
    BookEntity toEntity(BookDTO dto);

    @Named("toDTO")
    BookDTO toDTO(BookEntity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<BookEntity> toEntityList(List<BookDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<BookDTO> toDTOList(List<BookEntity> entityList);

}