package com.msantor.bookshop.dao;

import com.msantor.bookshop.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


    @Query(value = "SELECT DATEADD(MONTH, DATEDIFF(MONTH, 0, ordr.START_DATE), 0), sum(ordr.BOOK_COUNT) as totalbook,count(ordr.AMOUNT) as totalorder,count(ordr.amount) as totalamount " +
            "FROM ORDER_ENTITY as ordr  WHERE ordr.CLIENT_ENTITY_ID = :clientId GROUP BY DATEADD(MONTH, DATEDIFF(MONTH, 0, ordr.START_DATE), 0)", nativeQuery = true)
    List<Map<String,Object>> getOrdersByDate(@Param("clientId") Long clientId);


}

