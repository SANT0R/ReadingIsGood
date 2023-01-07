package com.msantor.bookshop.dto;

import com.msantor.bookshop.dto.base.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientDTO extends UserDTO {


    private static final long serialVersionUID = 6015444793203227879L;
}