package com.poly.tutor.B5_CRUDJPA_JoinBang.repository;

import com.poly.tutor.B5_CRUDJPA_JoinBang.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
}
