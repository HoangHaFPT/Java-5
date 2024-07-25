package com.poly.tutor.B4_CRUD_JPA.repository;

import com.poly.tutor.B4_CRUD_JPA.entity.Category1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category1,Long> {
    // CRUD 1 bang k can phai viet
}
