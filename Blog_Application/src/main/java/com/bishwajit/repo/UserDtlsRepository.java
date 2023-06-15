package com.bishwajit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bishwajit.entity.UserDtlsEntity;

public interface UserDtlsRepository extends JpaRepository<UserDtlsEntity, Integer> {
	
	UserDtlsEntity findByEmail(String email);

	UserDtlsEntity findByEmailAndPassword(String email,String password);
}
