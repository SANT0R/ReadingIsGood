package com.msantor.bookshop.service;

import com.msantor.bookshop.dao.ClientRepository;
import com.msantor.bookshop.dao.OrderRepository;
import com.msantor.bookshop.dto.ClientDTO;
import com.msantor.bookshop.dto.OrderDTO;
import com.msantor.bookshop.exception.ApiRequestException;
import com.msantor.bookshop.mapper.ClientMapper;
import com.msantor.bookshop.mapper.OrderMapper;
import com.msantor.bookshop.model.ClientEntity;
import com.msantor.bookshop.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository entityRepository;


    private OrderRepository orderRepository;
    private ClientMapper entityMapper;

    private OrderMapper orderMapper;

    @Override
    public void add(ClientDTO client) {


        entityRepository.save(entityMapper.toEntity(client));

    }

    @Override
    public void update(ClientDTO client) {

        ClientEntity entity = entityRepository.getOne(client.getId());
        if (entity.getId() != null) {

            entityRepository.save(entityMapper.toEntity(client));

        } else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public List<ClientDTO> getAll() {


        return entityMapper.toDTOList(entityRepository.findAll());
    }


    @Override
    public ClientDTO getById(Long id) {

        ClientEntity entity = entityRepository.getOne(id);

        if (entity != null){

            return entityMapper.toDTO(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public List<ClientDTO> getByName(String fullName) {

        List<ClientEntity> clientEntities = entityRepository.findByFullNameContains(fullName);

        return entityMapper.toDTOList (clientEntities);

    }



    @Override
    public List<OrderDTO> getAllOrders(Long id) {


        ClientEntity entity = entityRepository.getOne(id);

        List<OrderEntity> orderEntityList = new ArrayList<OrderEntity>();
        orderEntityList.addAll(entityRepository.getOne(id).getOrderEntities());

        return orderMapper.toDTOList(orderEntityList);
    }




    @Override
    public List<Map<String,Object>> getStatistics(Long id) {



        return orderRepository.getOrdersByDate(id);
    }





    @Override
    public void deleteByName(String fullName) {


        ClientEntity entity = entityRepository.findByFullName(fullName);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        ClientEntity entity = entityRepository.getOne(id);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the client number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);

        }


    }


}