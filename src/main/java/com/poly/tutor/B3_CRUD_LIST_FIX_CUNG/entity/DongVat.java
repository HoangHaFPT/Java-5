package com.poly.tutor.B3_CRUD_LIST_FIX_CUNG.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DongVat {
    //    ma – String , ten – String, gioiTinh – boolean, canNang - Double , khuVuc – String

    @NotEmpty(message = "Ma khong duoc trong")
    private String ma;

    private String ten;
    private boolean gioiTinh;
    private Double canNang;
    private String khuVucSong;
}
