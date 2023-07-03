package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,String> {
    boolean existsByClientCode(String clientCode);
    ClientEntity findByClientCode(String clientCode);
    void deleteByClientCode (String clientCode);

}
