package com.msantor.bookshop.mapper;

import com.msantor.bookshop.config.security.ApiUserRole;
import com.msantor.bookshop.dto.ClientDTO;
import com.msantor.bookshop.model.BookEntity;
import com.msantor.bookshop.model.ClientEntity;
import com.msantor.bookshop.model.OrderEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ClientMapperTest {

    @Spy
    ClientMapperImpl entityMapperImpl;

    @Spy
    private PasswordEncoder passwordEncoder;

    private ClientEntity addEntity(Long id,String fullName){

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
        client.setFullName(fullName);
        client.setUserName(fullName);
        client.setPassword(passwordEncoder.encode("Santor123"));
        client.setRole(ApiUserRole.ADMIN);
        client.setEMail("sdfd");
        client.setPhone("45296656");

        OrderEntity rent = new OrderEntity();
        rent.setId(20L);
        rent.setStartDate(LocalDate.now());
        rent.setFinishDate(LocalDate.now());
        rent.setClientEntity(client);
        rent.getBookEntities().add(book);

        client.getOrderEntities().add(rent);


        return client;
    }

    @Test
    void toDTOTest() {


        ClientEntity entity = addEntity(20L,"Mehmet Santor");


        ClientDTO entityDTO = entityMapperImpl.toDTO(entity);
        assertEquals(entityDTO.getId(), entity.getId());
    }


    @Test
    void toDTOListTest() {


        ClientEntity entity1 = addEntity(20L,"Mehmet Santor");


        ClientEntity entity2 = addEntity(30L,"Mehmet asdfg");


        List<ClientEntity> entities = Arrays.asList(entity1, entity2);

        List<ClientDTO> entityDTOList = entityMapperImpl.toDTOList(entities);

        assertEquals(entityDTOList.get(0).getFullName(), entity1.getFullName());
        assertEquals(entityDTOList.get(1).getFullName(), entity2.getFullName());
    }


    @Test
    void toEntityTest() {


        ClientEntity entity = addEntity(20L,"Mehmet Santor");


        ClientDTO entityDTO = entityMapperImpl.toDTO(entity);

        ClientEntity entity1 = entityMapperImpl.toEntity(entityDTO);

        assertEquals(entity1.getId(), entityDTO.getId());

    }

    @Test
    void toEntityListTest() {


        ClientEntity entity1 = addEntity(20L,"Mehmet Santor");


        ClientEntity entity2 = addEntity(30L,"Mehmet asdfg");


        List<ClientEntity> entities = Arrays.asList(entity1, entity2);

        List<ClientDTO> entityDTOList = entityMapperImpl.toDTOList(entities);

        List<ClientEntity> entityList = entityMapperImpl.toEntityList(entityDTOList);


        assertEquals(entityDTOList.get(0).getId(), entityList.get(0).getId());
        assertEquals(entityDTOList.get(1).getId(), entityList.get(1).getId());
    }

}