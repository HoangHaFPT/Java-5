package com.poly.tutor.B5_CRUDJPA_JoinBang.repository;

import com.poly.tutor.B5_CRUDJPA_JoinBang.entity.NhaXuatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer> {
}
