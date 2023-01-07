package com.msantor.bookshop.service;

import com.msantor.bookshop.dto.OrderDTO;

import java.util.List;


public interface OrderService {

    /**
     * Get all rents
     * @return List<OrderDTO>
     */
    List<OrderDTO> getAll();

    /**
     * Get a rent by id
     * @param id -
     * @return OrderDTO
     */
    OrderDTO getById(Long id);

    /**
     * Delete all rents
     */
    void deleteAll();

    /**
     * Delete a rent by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Update a rent
     * @param rent -
     */
    void update(OrderDTO rent);

    /**
     * Add a rent
     * @param rent -
     */
    void add(OrderDTO rent);

}