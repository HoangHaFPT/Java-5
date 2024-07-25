package com.poly.tutor.B3_CRUD_LIST_FIX_CUNG.service;

import com.poly.tutor.B3_CRUD_LIST_FIX_CUNG.entity.DongVat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DongVatService {

    private List<DongVat> dongVatList = new ArrayList<>();

    public DongVatService() {
        dongVatList.add(new DongVat("M1", "Ten1", true, 1.0, "KVS1"));
        dongVatList.add(new DongVat("M2", "Ten2", false, 2.0, "KVS2"));
        dongVatList.add(new DongVat("M3", "Ten3", true, 3.0, "KVS3"));
        dongVatList.add(new DongVat("M4", "Ten4", false, 4.0, "KVS4"));
        dongVatList.add(new DongVat("M5", "Ten5", true, 5.0, "KVS5"));
    }

    public List<DongVat> getAll() {
        return dongVatList;
    }

    public void addDongVat(DongVat dongVat) {
        dongVatList.add(dongVat);
    }

    public DongVat detail(String ma) {
        for (DongVat dongVat : dongVatList) {
            if (dongVat.getMa().equalsIgnoreCase(ma)) {
                return dongVat;
            }
        }
        return null;
    }

    public void update(DongVat dongVat, String ma) {
        for (int i = 0; i < dongVatList.size(); i++) {
            if (dongVatList.get(i).getMa().equalsIgnoreCase(ma)) {
                dongVatList.set(i, dongVat);
            }
        }
    }

    public void remove(String ma) {
        for (int i = 0; i < dongVatList.size(); i++) {
            if (dongVatList.get(i).getMa().equalsIgnoreCase(ma)) {
                dongVatList.remove(i);
            }
        }
    }

    public List<DongVat> search(String ten, Double canNangMin, Double canNangMax) {
        double min = canNangMin != null ? canNangMin : Double.MIN_VALUE;
        double max = canNangMax != null ? canNangMax : Double.MAX_VALUE;

        return dongVatList.stream()
                .filter(dongVat -> ten.isEmpty() || dongVat.getTen().equalsIgnoreCase(ten))
                .filter(dongVat -> dongVat.getCanNang() >= min && dongVat.getCanNang() <= max)
                .collect(Collectors.toList());
    }

}
