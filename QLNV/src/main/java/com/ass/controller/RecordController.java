package com.ass.controller;

import com.ass.model.Depart;
import com.ass.model.Records;
import com.ass.model.Staffs;
import com.ass.service.DepartService;
import com.ass.service.RecordService;
import com.ass.service.StaffsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordsService;
    @Autowired
    private StaffsService staffsService;
    @ModelAttribute("staffs")
    public Iterable<Staffs> staffs(){
        return staffsService.findAll();
    }
    @GetMapping("/records")
    public ModelAndView listRecords(){
        Iterable<Records> records = recordsService.findAll();
        ModelAndView modelAndView = new ModelAndView("/records/list");
        modelAndView.addObject("records", records);
        return modelAndView;
    }
    @GetMapping("/create-records")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("records/create");
        modelAndView.addObject("records", new Records());
        return modelAndView;
    }

    @PostMapping("/create-records")
    public ModelAndView saveRecord(@ModelAttribute("records") Records records){
        recordsService.save(records);
        ModelAndView modelAndView = new ModelAndView("/records/create");
        modelAndView.addObject("records", new Records());
        modelAndView.addObject("message", "New record created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-records/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Records> record = recordsService.findById(id);
        if(record != null) {
            ModelAndView modelAndView = new ModelAndView("/records/edit");
            modelAndView.addObject("records", record);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-records")
    public ModelAndView updateRecords(@ModelAttribute("records") Records record){
        recordsService.save(record);
        ModelAndView modelAndView = new ModelAndView("/records/edit");
        modelAndView.addObject("records", record);
        modelAndView.addObject("message", "records updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-records/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Records> record = recordsService.findById(id);
        if(record != null) {
            ModelAndView modelAndView = new ModelAndView("/records/delete");
            modelAndView.addObject("records", record);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-records")
    public String deleteProvince(@ModelAttribute("records") Records record){
        recordsService.remove(record.getId());
        return "redirect:records";
    }

}
