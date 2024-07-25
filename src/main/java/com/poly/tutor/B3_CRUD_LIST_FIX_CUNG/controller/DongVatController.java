package com.poly.tutor.B3_CRUD_LIST_FIX_CUNG.controller;

import com.poly.tutor.B3_CRUD_LIST_FIX_CUNG.entity.DongVat;
import com.poly.tutor.B3_CRUD_LIST_FIX_CUNG.service.DongVatService;
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
public class DongVatController {

    private DongVatService dongVatService = new DongVatService();

    @GetMapping("/dong-vat/hien-thi-tat-ca")
    public String hienThiDanhSachDongVat(Model model) {
        model.addAttribute("dv1", new DongVat());
        model.addAttribute("lists", dongVatService.getAll());
        return "buoi3/dongvat";
    }

    @PostMapping("/dong-vat/add")
    public String themDongVat(@Valid @ModelAttribute("dv1") DongVat dongVat, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lists", dongVatService.getAll());
            return "buoi3/dongvat";
        }
        dongVatService.addDongVat(dongVat);
        return "redirect:/dong-vat/hien-thi-tat-ca";
    }

    @GetMapping("/dong-vat/view-update/{ma}")
    public String viewUpdate(@PathVariable String ma, Model model) {
        DongVat dongVat = dongVatService.detail(ma);
        model.addAttribute("dv", dongVat);
        return "buoi3/update-dong-vat";
    }

    @PostMapping("/dong-vat/update/{ma}")
    public String update(@PathVariable String ma, @Valid @ModelAttribute("dv") DongVat dongVat,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dv", dongVat);
            return "redirect:/dong-vat/view-update/" + ma;
        }
        dongVatService.update(dongVat, ma);
        return "redirect:/dong-vat/hien-thi-tat-ca";
    }

    @GetMapping("/dong-vat/remove/{ma}")
    public String remove(@PathVariable String ma) {
        dongVatService.remove(ma);
        return "redirect:/dong-vat/hien-thi-tat-ca";
    }

    @GetMapping("/dong-vat/search")
    public String search(Model model, @RequestParam(required = false) String tenSearch,
                         @RequestParam(required = false) Double canNangMinSearch,
                         @RequestParam(required = false) Double canNangMaxSearch) {
        model.addAttribute("lists", dongVatService.search(tenSearch, canNangMinSearch, canNangMaxSearch));
        model.addAttribute("dv1", new DongVat());
        return "buoi3/dongvat";
    }

}
