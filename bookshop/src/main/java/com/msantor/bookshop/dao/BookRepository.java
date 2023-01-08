package com.msantor.bookshop.dao;

import com.msantor.bookshop.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity findByFullName(String fullName);

    List<BookEntity> findByFullNameContains(String fullName);



}