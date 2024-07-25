package com.poly.tutor.B5_CRUDJPA_JoinBang.controller;

import com.poly.tutor.B5_CRUDJPA_JoinBang.entity.Sach;
import com.poly.tutor.B5_CRUDJPA_JoinBang.repository.NhaXuatBanRepository;
import com.poly.tutor.B5_CRUDJPA_JoinBang.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SachController {

    @Autowired
    private SachRepository repository;

    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;

    @GetMapping("/sach/hien-thi")
    public String hienThiSach(Model model) {
        // load table
        model.addAttribute("lists", repository.findAll());
        // load cbb
        model.addAttribute("listNXB", nhaXuatBanRepository.findAll());
        return "buoi5/sach";
    }

    @PostMapping("/sach/add")
    public String addSach(Sach sach) {
        repository.save(sach);
        return "redirect:/sach/hien-thi";
    }

    @GetMapping("/sach/detail/{id}")
    public String detailSach(@PathVariable Integer id, Model model) {
        Sach sach = repository.findById(id).get();
        model.addAttribute("s", sach);
        // load table
        model.addAttribute("lists", repository.findAll());
        // load cbb
        model.addAttribute("listNXB", nhaXuatBanRepository.findAll());
        return "buoi5/sach";
    }

    @GetMapping("/sach/remove/{id}")
    public String removeSach(@PathVariable Integer id) {
        repository.deleteById(id);
        return "redirect:/sach/hien-thi";
    }
}
