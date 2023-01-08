package com.msantor.bookshop.service;

import com.msantor.bookshop.dao.BookRepository;
import com.msantor.bookshop.dto.BookDTO;
import com.msantor.bookshop.exception.ApiRequestException;
import com.msantor.bookshop.mapper.BookMapper;
import com.msantor.bookshop.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository entityRepository;


    private BookMapper entityMapper;


    @Override
    public void add(BookDTO book) {

        entityRepository.save(entityMapper.toEntity(book));

    }

    @Override
    public void update(BookDTO book) {

        BookEntity entity = entityRepository.getOne(book.getId());
        if (entity.getId() != null) {

            entityRepository.save(entityMapper.toEntity(book));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<BookDTO> getAll(Boolean atStock) {

        List<BookEntity> bookEntities;

        bookEntities = entityRepository.findAll();
        if (atStock) {
            bookEntities.removeIf(book -> book.getStock() == 0);
        }
        return entityMapper.toDTOList(bookEntities);
    }



    @Override
    public BookDTO getById(Long id) {

        BookEntity entity = entityRepository.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<BookDTO> getByName(String fullName) {

        List<BookEntity> bookEntities = entityRepository.findByFullNameContains(fullName);

        return entityMapper.toDTOList (bookEntities);

    }

    @Override
    public void deleteByName(String fullName) {


        BookEntity entity = entityRepository.findByFullName(fullName);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        BookEntity entity = entityRepository.getOne(id);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }


    }


}