package com.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.model.UserDetail;

@Repository
public interface UserRepo extends JpaRepository<UserDetail, Integer> {

	public boolean existsByEmail(String email);

	public UserDetail findByEmail(String email);

}
