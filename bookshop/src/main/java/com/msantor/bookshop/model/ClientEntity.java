package com.msantor.bookshop.model;

import com.msantor.bookshop.model.base.UserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table(name="ClientEntity")
@Entity
@Data
public class ClientEntity extends UserModel {

    private static final long serialVersionUID = -6858890208229888077L;
    @OneToMany(mappedBy = "clientEntity" , cascade = CascadeType.ALL)
    private Set<OrderEntity> orderEntities = new HashSet<>();

}