package com.msantor.bookshop.dao;

import com.msantor.bookshop.model.BookEntity;
import com.msantor.bookshop.model.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository entityRepository ;
    @Autowired
    private BookRepository bookRepository ;

    Long firstId = 448L; //deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.

    private void addEntity(){

        OrderEntity entity = new OrderEntity();
        entity.setStartDate(LocalDate.now());
        entity.setFinishDate(LocalDate.now());

        Set<BookEntity> books = new HashSet<>();

        BookEntity book1 = new BookEntity();
        book1.setId(295L);
        books.add(book1);
        BookEntity book2 = new BookEntity();
        book2.setId(296L);
        books.add(book2);
        BookEntity book3 = new BookEntity();
        book3.setId(297L);
        books.add(book3);

        entity.setBookEntities(books);
        entityRepository.save(entity);
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity();


        OrderEntity entity = entityRepository.getOne(firstId);
        assertEquals(entity.getId(), firstId);

    }


    @Test
    void deleteByIdTest(){//"firstId" deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.



        entityRepository.deleteAll();

        firstId++;

        addEntity();

        entityRepository.deleteById(firstId);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();

        addEntity();


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity();
        OrderEntity entity = entityRepository.getOne(firstId);

        assertEquals(entity.getId(), firstId);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity();

        addEntity();

        addEntity();


        assertEquals(entityRepository.count(), 3);

        OrderEntity entity1 = entityRepository.getOne(firstId);

        assertEquals(entity1.getId(), firstId);

        OrderEntity entity2 = entityRepository.getOne(firstId+1);

        assertEquals(entity2.getId(), firstId+1);

        OrderEntity entity3 = entityRepository.getOne(firstId+2);

        assertEquals(entity3.getId(), firstId+2);
    }



}