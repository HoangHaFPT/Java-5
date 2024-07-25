package com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SanPham")
public class SanPham1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    @NotBlank(message = "Ma khong duoc de trong!")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Ten khong duoc de trong!")
    private String ten;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "Website")
    private String website;

    @Column(name = "GiaBan")
    private Double giaBan;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "IdLoaiSP", referencedColumnName = "Id")
    private LoaiSP loaiSP;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
