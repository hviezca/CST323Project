package com.gcu.cst323contactapp.repository;

import com.gcu.cst323contactapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
