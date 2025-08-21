package vn.edu.eiu.student_view.final_test.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.eiu.student_view.final_test.model.Equipment;
import vn.edu.eiu.student_view.final_test.model.EquipmentType;
import vn.edu.eiu.student_view.final_test.service.EquipmentService;
import vn.edu.eiu.student_view.final_test.service.EquipmentTypeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    EquipmentService equipmentServ;
    @Autowired
    EquipmentTypeService equipmentTypeServ;

    @GetMapping("/equipments")
    public String equipment(@RequestParam(value = "keyword", defaultValue = "") String keyword, Model model){
        List<Equipment> equipments = new ArrayList<>();
        if (keyword.isBlank()) {
            equipments = equipmentServ.findAll();
        } else {
            equipments = equipmentServ.findByName(keyword);
        }
        model.addAttribute("equipments",equipments);
        return "equipment-list";
    }

    @GetMapping("equipments/add")
    public String addEquipment(Model model){
        List<EquipmentType> equipmentTypes = equipmentTypeServ.findAll();
        model.addAttribute("equipmentTypes",equipmentTypes);
        model.addAttribute("equipment",new Equipment());
        model.addAttribute("type","add");
        return "equipment-form";
    }
    @PostMapping("equipments/form")
    public String saveEquipment(@Valid @ModelAttribute Equipment e, BindingResult bindingResult,Model model,@RequestParam("type") String type){
        if (bindingResult.hasErrors()){
            model.addAttribute("equipmentTypes",equipmentTypeServ.findAll());
            model.addAttribute("type",type);
            return "equipment-form";
        }
        if (type.equals("add")){
           if(equipmentServ.checkExist(e.getEquipmentId())){
               model.addAttribute("equipmentTypes",equipmentTypeServ.findAll());
               model.addAttribute("dupplicatedId",e.getEquipmentId());
               return "equipment-form";
           }
        }

        equipmentServ.save(e);
        return "redirect:/equipments";
    }

    @GetMapping("equipments/edit/{id}")
    public String editEquipment(@PathVariable("id") String id, Model model){
        Equipment equipment = equipmentServ.findById(id);
        model.addAttribute("equipment",equipment);

        List<EquipmentType> equipmentTypes = equipmentTypeServ.findAll();
        model.addAttribute("equipmentTypes",equipmentTypes);
        model.addAttribute("type","edit");

        return "equipment-form";

    }
    @GetMapping("equipments/delete/{id}")
    public String deleteEquipment(@PathVariable("id") String id){
        equipmentServ.deleteById(id);
        return "redirect:/equipments";
    }

}
