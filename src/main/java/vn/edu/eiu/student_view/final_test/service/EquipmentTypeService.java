package vn.edu.eiu.student_view.final_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.student_view.final_test.model.EquipmentType;
import vn.edu.eiu.student_view.final_test.repository.EquipmentTypeRepo;

import java.util.List;

@Service
public class EquipmentTypeService {

    @Autowired
    private EquipmentTypeRepo equipmentTypeRepo;

    public void save(EquipmentType equipmentType){
        equipmentTypeRepo.save(equipmentType);
    }

    public void delete(EquipmentType equipmentType){
        equipmentTypeRepo.delete(equipmentType);
    }
    public List<EquipmentType> findAll(){
        return equipmentTypeRepo.findAll();
    }
}
