package com.msantor.bookshop.service;

import com.msantor.bookshop.dao.OrderRepository;
import com.msantor.bookshop.dto.BookDTO;
import com.msantor.bookshop.dto.OrderDTO;
import com.msantor.bookshop.mapper.OrderMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository rentRepository;

    @Spy
    private OrderMapperImpl rentMapper;

    @InjectMocks
    private OrderServiceImpl rentService;

    private BookDTO addBook(Long id, int pageNum, int stock){

        BookDTO entity = new BookDTO();
        entity.setId(id);
        entity.setFullName("fullName");
        entity.setType("sadfsd");
        entity.setDescription("dsfgash");
        entity.setPublisher("dfghj dsdf");
        entity.setReleaseYear(LocalDate.now());
        entity.setPage(pageNum);
        entity.setStock(stock);

        return entity;
    }

    private OrderDTO addEntity(){

        OrderDTO entity = new OrderDTO();
        entity.setId(20L);
        entity.setStartDate(LocalDate.now());
        entity.getBooks().add(addBook(2L,245,13));
        entity.getBooks().add(addBook(4L,148,100));
        entity.getBooks().add(addBook(3L,763,7));

        rentService.add(entity);

        return entity;
    }



    @Test
    void addTest() {

        OrderDTO rentAdd = addEntity();

        LocalDate actual1 = rentAdd.getFinishDate() ;
        LocalDate expected1 = LocalDate.now().plusDays((245+763+148)/5);

        assertEquals(actual1, expected1);

        Set<BookDTO> books = rentAdd.getBooks();

        List<Integer> expected2 = new ArrayList<>();
        expected2.add (12);
        expected2.add (99);
        expected2.add (6);


        List<Integer> actual2 = new ArrayList<>();

        for (BookDTO book :books){

            actual2.add(book.getStock()) ;
        }

        assertEquals(expected2,actual2 );


    }

}