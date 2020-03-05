package com.ass.controller;

import com.ass.model.Depart;
import com.ass.model.Staffs;
import com.ass.responsitory.StaffsResponsitory;
import com.ass.service.DepartService;
import com.ass.service.StaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class DepartController {
    @Autowired
    private StaffsService staffsService;
    @Autowired
    private DepartService departService;
    @Autowired
    private StaffsResponsitory staffsResponsitory;

    @GetMapping("/departs")
    public ModelAndView listDeparts(){
        Iterable<Depart> departs = departService.findAll();
        ModelAndView modelAndView = new ModelAndView("/departs/list");
        modelAndView.addObject("departs", departs);
        return modelAndView;
    }
    @GetMapping("/create-departs")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("departs/create");
        modelAndView.addObject("departs", new Depart());
        return modelAndView;
    }

    @PostMapping("/create-departs")
    public ModelAndView saveDepart(@ModelAttribute("departs") Depart departs){
        departService.save(departs);
        ModelAndView modelAndView = new ModelAndView("/departs/create");
        modelAndView.addObject("departs", new Depart());
        modelAndView.addObject("message", "New Depart created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-departs/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Depart> depart = departService.findById(id);
        if(depart != null) {
            ModelAndView modelAndView = new ModelAndView("/departs/edit");
            modelAndView.addObject("departs", depart);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-departs")
    public ModelAndView updateProvince(@ModelAttribute("departs") Depart depart){
        departService.save(depart);
        ModelAndView modelAndView = new ModelAndView("/departs/edit");
        modelAndView.addObject("departs", depart);
        modelAndView.addObject("message", "departs updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-departs/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Depart> depart = departService.findById(id);
        if(depart != null) {
            ModelAndView modelAndView = new ModelAndView("/departs/delete");
            modelAndView.addObject("departs", depart);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-departs")
    public String deleteProvince(@ModelAttribute("departs") Depart depart){
        departService.remove(depart.getId());
        return "redirect:departs";
    }


//    @GetMapping("/view-departs/{id}")
//    public ModelAndView viewProvince(@PathVariable("id") Long id){
//        Optional<Depart> depart = departService.findById(id);
//        if(depart == null){
//            return new ModelAndView("/error.404");
//        }
//        Iterable<Staffs> staffs = staffsResponsitory.findAllByDepart(depart.get());
//        ModelAndView modelAndView = new ModelAndView("/departs/view");
//        modelAndView.addObject("departs", depart);
//        modelAndView.addObject("staffs", staffs);
//        return modelAndView;
//    }

}
