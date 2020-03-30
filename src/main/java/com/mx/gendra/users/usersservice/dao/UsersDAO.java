package com.mx.gendra.users.usersservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.gendra.users.usersservice.entitys.User;

public interface UsersDAO extends JpaRepository<User, Long> {
}
