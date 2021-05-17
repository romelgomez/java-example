package com.autana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autana.domains.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
