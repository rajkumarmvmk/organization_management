package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,String> {
    boolean existsByClientCode(String clientCode);
    @Query("SELECT c FROM ClientEntity c WHERE c.clientCode = :clientCode")
    ClientEntity findByClientsCode(@Param("clientCode") String clientCode);
    void deleteByClientCode (String clientCode);

}
