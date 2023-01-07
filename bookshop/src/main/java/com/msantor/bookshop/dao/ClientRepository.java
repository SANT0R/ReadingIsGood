package com.msantor.bookshop.dao;

import com.msantor.bookshop.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {


    ClientEntity findByFullName(String fullName);
    ClientEntity findByUserName(String userName);

    List<ClientEntity> findByFullNameContains(String fullName);
    List<ClientEntity> findByUserNameContains(String userName);





}