package com.example.C35.repository;

import com.example.C35.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    public Optional<AppUser> findByUsername(String username);

}
