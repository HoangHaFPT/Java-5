package com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.repository;

import com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.entity.LoaiSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSPRepository  extends JpaRepository<LoaiSP,Integer> {
}
