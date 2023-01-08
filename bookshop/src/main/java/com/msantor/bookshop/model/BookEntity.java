package com.msantor.bookshop.model;

import com.msantor.bookshop.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table(name="BookEntity")
@Entity
@Data
public class BookEntity extends BaseModel {

    private static final long serialVersionUID = -7599045333722607430L;
    @Column(name="fullName" , nullable = false)
    private String fullName;

    @Column(name="publisher" , nullable = false)
    private String publisher;

    @Column(name="releaseYear" , nullable = false)
    private LocalDate releaseYear;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    @Column(name="page" , nullable = false)
    private int page;

    @Column(name="stock" , nullable = false)
    private int stock;

    @ManyToMany(mappedBy = "bookEntities", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<OrderEntity> orderEntities = new HashSet<>();


}