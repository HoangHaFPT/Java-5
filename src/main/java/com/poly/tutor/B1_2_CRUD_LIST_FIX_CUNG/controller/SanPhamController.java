package com.poly.tutor.B1_2_CRUD_LIST_FIX_CUNG.controller;

import com.poly.tutor.B1_2_CRUD_LIST_FIX_CUNG.entity.SanPham;
import com.poly.tutor.B1_2_CRUD_LIST_FIX_CUNG.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanPhamController {

    private SanPhamService service = new SanPhamService();

    @GetMapping("/san-pham/view-all")
    public String hienThi(Model model) {
        model.addAttribute("lists", service.getAll());
        model.addAttribute("sp", new SanPham()); // KHỞI TẠO 1 ĐỐI TƯỢNG RỖNG ĐỂ SANG FORM HỨNG LỖI
        return "buoi1/buoi1";
    }

    @GetMapping("/san-pham/remove/{ma1}")
    public String xoaSanPham(@PathVariable String ma1) {
        service.xoaSanPham(ma1);
        return "redirect:/san-pham/view-all"; // CHUYEN VE TRANG CHU
    }

    @GetMapping("/san-pham/detail/{ma1}")
    public String detailSanPham(@PathVariable String ma1, Model model) {
        SanPham sp = service.detailSanPham(ma1);
        model.addAttribute("sp", sp);
        model.addAttribute("lists", service.getAll());
        return "buoi1/buoi1";
    }

    @PostMapping("/san-pham/add")
    public String addSanPham(@Valid @ModelAttribute("sp") SanPham sp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lists", service.getAll());
            return "buoi1/buoi1";
        }
        service.addSanPham(sp);
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("/san-pham/view-update/{ma1}")
    public String viewUpdate(@PathVariable String ma1, Model model) {
        SanPham sp = service.detailSanPham(ma1);
        model.addAttribute("sp", sp);
        model.addAttribute("lists", service.getAll());
        return "buoi1/update";
    }

    @PostMapping("/san-pham/update/{ma}")
    public String updateSanPham(@PathVariable String ma, @Valid @ModelAttribute("sp") SanPham sp,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sp", sp);
            return "redirect:/san-pham/view-update/" + ma;
        }
        service.updateSanPham(sp, ma);
        return "redirect:/san-pham/view-all";
    }
}
