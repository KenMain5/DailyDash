package com.DailyDash.AccountManagement.repository;

import com.DailyDash.AccountManagement.entity.AccountValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountValidationRepository extends JpaRepository<AccountValidation, Integer> {
    Optional<AccountValidation> findAccountValidationByDashUserIdAndCodeGenerated(int userId, int codeGenerated);
    Optional<AccountValidation> findAccountValidationByDashUserId(int userId);
}
