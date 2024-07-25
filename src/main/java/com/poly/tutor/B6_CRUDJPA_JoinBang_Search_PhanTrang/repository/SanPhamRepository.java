package com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.repository;

import com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.entity.SanPham1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham1, Integer> {
    Page<SanPham1> findAllByTen(String tenSearch, Pageable pageable);
}
