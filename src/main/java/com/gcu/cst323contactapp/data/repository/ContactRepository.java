package com.gcu.cst323contactapp.data.repository;

import com.gcu.cst323contactapp.data.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
}
