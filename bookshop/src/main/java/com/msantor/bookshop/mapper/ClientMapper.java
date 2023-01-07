package com.msantor.bookshop.mapper;

import com.msantor.bookshop.dto.ClientDTO;
import com.msantor.bookshop.model.ClientEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Named("toEntity")
    ClientEntity toEntity(ClientDTO dto);

    @Named("toDTO")
    ClientDTO toDTO(ClientEntity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<ClientEntity> toEntityList(List<ClientDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<ClientDTO> toDTOList(List<ClientEntity> entityList);

}