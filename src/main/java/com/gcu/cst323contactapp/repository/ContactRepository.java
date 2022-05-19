package com.gcu.cst323contactapp.repository;

import com.gcu.cst323contactapp.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
}
