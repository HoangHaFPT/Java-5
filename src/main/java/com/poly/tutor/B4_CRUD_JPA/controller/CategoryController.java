package com.poly.tutor.B4_CRUD_JPA.controller;

import com.poly.tutor.B4_CRUD_JPA.entity.Category1;
import com.poly.tutor.B4_CRUD_JPA.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping("/hien-thi")
    public String hienThiCate(Model model){
        model.addAttribute("lists",repo.findAll());
        return "buoi4/cate";
    }

    @GetMapping("/view-add")
    public String viewAdd() {
        return "buoi4/add";
    }

    @PostMapping("/add")
    public String add(Category1 category1) {
        repo.save(category1);
        return "redirect:/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        Category1 category1 = repo.findById(id).get();
        model.addAttribute("cate", category1);
        return "buoi4/update";
    }

    @PostMapping("/update/{id}")
    public String update(Category1 category1) {
        repo.save(category1);
        return "redirect:/hien-thi";
    }
}
