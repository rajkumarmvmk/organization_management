package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
}
