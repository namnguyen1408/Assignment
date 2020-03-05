package com.ass.controller;

import com.ass.model.Depart;
import com.ass.model.Staffs;
import com.ass.service.DepartService;
import com.ass.service.StaffsService;
import com.ass.service.StaffsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StaffsController {
    @Autowired
    private StaffsService staffsService;
    @Autowired
    private DepartService departService;

    @ModelAttribute("departs")
    public Iterable<Depart> departs(){
        return departService.findAll();
    }


    @GetMapping("/staffs")
    public ModelAndView listProvinces(){
        Iterable<Staffs> staffs = staffsService.findAll();
        ModelAndView modelAndView = new ModelAndView("/staffs/list");
        modelAndView.addObject("staffs", staffs);
        return modelAndView;
    }
    @GetMapping("/create-staffs")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("staffs/create");
        modelAndView.addObject("staffs", new Staffs());
        return modelAndView;
    }

    @PostMapping("/create-staffs")
    public ModelAndView saveStaffs(@ModelAttribute("staffs") Staffs staffs){
        staffsService.save(staffs);
        ModelAndView modelAndView = new ModelAndView("/staffs/create");
        modelAndView.addObject("staffs", new Staffs());
        modelAndView.addObject("message", "New staff created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-staffs/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Staffs> staffs = staffsService.findById(id);
        if(staffs != null) {
            ModelAndView modelAndView = new ModelAndView("/staffs/edit");
            modelAndView.addObject("staffs", staffs);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }

    }
    @PostMapping("/edit-staffs")
    public ModelAndView updateStaffs(@ModelAttribute("province") Staffs staffs){
        staffsService.save(staffs);
        ModelAndView modelAndView = new ModelAndView("/staffs/edit");
        modelAndView.addObject("staffs", staffs);
        modelAndView.addObject("message", "staffs updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-staffs/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Staffs> province = staffsService.findById(id);
        if(province != null) {
            ModelAndView modelAndView = new ModelAndView("/staffs/delete");
            modelAndView.addObject("staffs", province);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-staffs")
    public String deleteStaffs(@ModelAttribute("staffs") Staffs staffs){
        staffsService.remove(staffs.getId());
        return "redirect:staffs";
    }
}
