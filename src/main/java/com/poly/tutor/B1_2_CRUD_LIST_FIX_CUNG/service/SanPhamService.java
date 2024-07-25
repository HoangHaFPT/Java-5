package com.poly.tutor.B1_2_CRUD_LIST_FIX_CUNG.service;

import com.poly.tutor.B1_2_CRUD_LIST_FIX_CUNG.entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {

    private List<SanPham> lists = new ArrayList<>();

    public SanPhamService() {
        // add lan luot cac phan tu
        lists.add(new SanPham(1, "ms01", "laptop1", 20000, "van phong"));
        lists.add(new SanPham(2, "ms02", "laptop2", 20000, "van phong 1"));
        lists.add(new SanPham(3, "ms03", "laptop3", 20000, "van phong 2"));
        lists.add(new SanPham(4, "ms04", "laptop4", 20000, "van phong 3"));
        lists.add(new SanPham(5, "ms05", "laptop5", 20000, "van phong 4"));
        lists.add(new SanPham(6, "ms06", "laptop6", 20000, "van phong"));
    }

    public List<SanPham> getAll() {
        return lists;
    }

    public void xoaSanPham(String ma) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getMa().equalsIgnoreCase(ma)) {
                lists.remove(i);
            }
        }
    }

    public SanPham detailSanPham(String ma) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getMa().equalsIgnoreCase(ma)) {
                return lists.get(i);
            }
        }
        return null;
    }

    public void addSanPham(SanPham sanPham) {
        lists.add(sanPham);
    }

    public void updateSanPham(SanPham sanPham, String ma) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getMa().equalsIgnoreCase(ma)) {
                lists.set(i, sanPham);
            }
        }
    }
}
