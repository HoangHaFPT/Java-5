package com.poly.tutor.B1_2_CRUD_LIST_FIX_CUNG.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {

    //    @NotNull
//    @NotBlank(message = "Id khong duoc de trong")
    private Integer id;

    @NotEmpty(message = "Ma khong duoc de trong")
    private String ma;

    @NotEmpty(message = "Ten khong duoc de trong")
    private String ten;

    //    @NotNull
//    @NotBlank(message = "Gia khong duoc de trong")
    private Integer gia;

    //    @NotEmpty(message = "Gia khong duoc de trong")
    private String loai;

}
