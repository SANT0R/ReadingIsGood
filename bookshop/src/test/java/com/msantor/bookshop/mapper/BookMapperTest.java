package com.msantor.bookshop.mapper;

import com.msantor.bookshop.dto.BookDTO;
import com.msantor.bookshop.model.BookEntity;
import com.msantor.bookshop.model.ClientEntity;
import com.msantor.bookshop.model.OrderEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookMapperTest {

    @Spy
    BookMapperImpl entityMapperImpl;


    private BookEntity addEntity(Long id,String fullName){
        BookEntity book = new BookEntity();
        book.setId(id);
        book.setFullName(fullName);
        book.setType("sadfsd");
        book.setDescription("dsfgash");
        book.setPublisher("dfghj dsdf");
        book.setReleaseYear(LocalDate.now());
        book.setPage(800);
        book.setStock(800);


        ClientEntity client = new ClientEntity();
        client.setId(30L);
        client.setEMail("alskdmlaks@gmail.com");
        client.setFullName("msantor");
        client.setPassword("1234");
        client.setPhone("30203320");

        OrderEntity rent = new OrderEntity();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());
        rent.setClientEntity(client);
        rent.getBookEntities().add(book);

        client.getOrderEntities().add(rent);

        return book;
    }

    @Test
    void toDTOTest() {


        BookEntity entity = addEntity(20L,"Mehmet Santor");


        BookDTO entityDTO = entityMapperImpl.toDTO(entity);
        assertEquals(entityDTO.getId(), entity.getId());
    }


    @Test
    void toDTOListTest() {


        BookEntity entity1 = addEntity(20L,"Mehmet Santor");


        BookEntity entity2 = addEntity(30L,"Mehmet asdfg");


        List<BookEntity> entities = Arrays.asList(entity1, entity2);

        List<BookDTO> entityDTOList = entityMapperImpl.toDTOList(entities);
        assertEquals(entityDTOList.get(0).getId(), entity1.getId());
        assertEquals(entityDTOList.get(1).getId(), entity2.getId());
    }


    @Test
    void toEntityTest() {


        BookEntity entity = addEntity(20L,"Mehmet Santor");


        BookDTO entityDTO = entityMapperImpl.toDTO(entity);

        BookEntity entity1 = entityMapperImpl.toEntity(entityDTO);

        assertEquals(entity1.getId(), entityDTO.getId());

    }

    @Test
    void toEntityListTest() {


        BookEntity entity1 = addEntity(20L,"Mehmet Santor");


        BookEntity entity2 = addEntity(30L,"Mehmet asdfg");


        List<BookEntity> entities = Arrays.asList(entity1, entity2);

        List<BookDTO> entityDTOList = entityMapperImpl.toDTOList(entities);

        List<BookEntity> entityList = entityMapperImpl.toEntityList(entityDTOList);


        assertEquals(entityDTOList.get(0).getId(), entityList.get(0).getId());
        assertEquals(entityDTOList.get(1).getId(), entityList.get(1).getId());
    }

}