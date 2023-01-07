package com.msantor.bookshop.service;

import com.msantor.bookshop.dto.ClientDTO;
import com.msantor.bookshop.dto.OrderDTO;

import java.util.List;
import java.util.Map;


public interface ClientService {

    /**
     * Get all clients
     * @return List<ClientDTO>
     */
    List<ClientDTO> getAll();

    /**
     * Get a client by id
     * @param id -
     * @return ClientDTO
     */
    ClientDTO getById(Long id);

    /**
     * Get a client by full name
     * @param fullName -
     * @return List<ClientDTO>
     */
    List<ClientDTO> getByName(String fullName);


    /**
     * @param id -
     * Get all orders of the client
     */
    List<OrderDTO> getAllOrders(Long id);

    /**
     * Delete all clients
     */
    void deleteAll();

    /**
     * Delete a client by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Get all statistics of the client by id
     * @param id -
     */
    List<Map<String,Object>> getStatistics(Long id);

    /**
     * Delete a client by name
     * @param fullName -
     */
    void deleteByName(String fullName);

    /**
     * Update a client
     * @param client -
     */
    void update(ClientDTO client);

    /**
     * Add a client
     * @param client -
     */
    void add(ClientDTO client);


}