package com.msantor.bookshop.model;

import com.msantor.bookshop.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Table(name="OrderEntity")
@Entity
@Data
public class OrderEntity extends BaseModel {

    private static final long serialVersionUID = 6756764858273649500L;
    @Column(name="startDate" , nullable = false)
    private LocalDate startDate ;

    @Column(name="finishDate" , nullable = false)
    private LocalDate finishDate ;

    @Column(name="returnDate" )
    private LocalDate returnDate ;

    @Column(name="amount" , nullable = false)
    private BigDecimal amount ;


    @Column(name="bookCount" , nullable = false)
    private int bookCount ;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "order_books",
            joinColumns = { @JoinColumn(name = "orders_id") },
            inverseJoinColumns = { @JoinColumn(name = "books_id") })
    private Set<BookEntity> bookEntities = new HashSet<>();

    @ManyToOne
    private ClientEntity clientEntity;




}