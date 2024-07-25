package com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.controller;

import com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.entity.SanPham1;
import com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.repository.LoaiSPRepository;
import com.poly.tutor.B6_CRUDJPA_JoinBang_Search_PhanTrang.repository.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanPham1Controller {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSPRepository loaiSPRepository;

    @GetMapping("/san-pham/hien-thi-tat-ca")
    public String hienThiDanhSachSanPham(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<SanPham1> listSanPham = sanPhamRepository.findAll(pageable);
        model.addAttribute("sanPhamRequest", new SanPham1());
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("listLoaiSanPham", loaiSPRepository.findAll());
        return "/buoi6/home";
    }

    @PostMapping("/san-pham/add1")
    public String addSanPham(@Valid @ModelAttribute("sanPhamRequest") SanPham1 sanPham1, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/buoi6/home";
        }
        sanPhamRepository.save(sanPham1);
        return "redirect:/san-pham/hien-thi-tat-ca";
    }

    @GetMapping("/san-pham/remove1/{id}")
    public String removeSanPham(@PathVariable Integer id) {
        sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/hien-thi-tat-ca";
    }

    @GetMapping("/san-pham/view-update1/{id}")
    public String viewUpdateSanPham(@PathVariable Integer id, Model model) {
        model.addAttribute("sp", sanPhamRepository.findById(id).get());
        model.addAttribute("listLoaiSanPham", loaiSPRepository.findAll());
        return "/buoi6/update";
    }

    @PostMapping("/san-pham/update1/{id}")
    public String updateSanPham(@Valid @ModelAttribute("sp") SanPham1 sanPham1, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listLoaiSanPham", loaiSPRepository.findAll());
            return "/buoi6/update";
        }
        sanPhamRepository.save(sanPham1);
        return "redirect:/san-pham/hien-thi-tat-ca";
    }

    @GetMapping("/san-pham/search")
    public String searchSanPham(@RequestParam String tenSearch, @RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        if (tenSearch.isEmpty()) {
            return "redirect:/san-pham/hien-thi-tat-ca";
        }
        Pageable pageable = PageRequest.of(number, 2);
        Page<SanPham1> listSanPham = sanPhamRepository.findAllByTen(tenSearch, pageable);
        model.addAttribute("sanPhamRequest", new SanPham1());
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("listLoaiSanPham", loaiSPRepository.findAll());
        return "/buoi6/home";
    }
}
