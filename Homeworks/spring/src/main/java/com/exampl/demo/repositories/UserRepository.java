package com.exampl.demo.repositories;

import com.exampl.demo.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByRoleId(Long roleId);
    Page<User> findByRoleId(Long roleId, Pageable pageable);
}
