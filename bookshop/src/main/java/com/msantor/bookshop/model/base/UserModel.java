package com.msantor.bookshop.model.base;

import com.msantor.bookshop.config.security.ApiUserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class UserModel  extends BaseModel implements Serializable {


    private static final long serialVersionUID = 3766500994656537938L;

    @Column(unique = true, nullable = false)
    private String userName ;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password ;

    @Column(nullable = false)
    private String phone ;

    @Column(nullable = false)
    private String eMail;


    @Column(nullable = false)
    private ApiUserRole role;

}