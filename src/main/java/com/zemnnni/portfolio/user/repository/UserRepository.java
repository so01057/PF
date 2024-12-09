package com.zemnnni.portfolio.user.repository;

import com.zemnnni.portfolio.user.domain.entity.User;
import com.zemnnni.portfolio.user.repository.querydsl.UserRepositoryDSL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>, UserRepositoryDSL {
}
