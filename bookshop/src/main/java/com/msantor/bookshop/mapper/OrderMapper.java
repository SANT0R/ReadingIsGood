package com.msantor.bookshop.mapper;

import com.msantor.bookshop.dto.OrderDTO;
import com.msantor.bookshop.model.OrderEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    @Named("toEntity")
    OrderEntity toEntity(OrderDTO dto);

    @Named("toDTO")
    OrderDTO toDTO(OrderEntity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<OrderEntity> toEntityList(List<OrderDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<OrderDTO> toDTOList(List<OrderEntity> entityList);

}