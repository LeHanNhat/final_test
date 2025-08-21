package vn.edu.eiu.student_view.final_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.student_view.final_test.model.Equipment;
import vn.edu.eiu.student_view.final_test.repository.EquipmentRepo;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepo equipmentRepo;

    public void save(Equipment equipment){
        equipmentRepo.save(equipment);
    }

    public void delete(Equipment equipment){
        equipmentRepo.delete(equipment);
    }

    public Equipment findById(String equipmentId){
        return equipmentRepo.findById(equipmentId).orElseThrow();
    }
    public List<Equipment> findByName(String equipmentName){
        return equipmentRepo.findByEquipmentName(equipmentName);
    }
    public List<Equipment> findAll(){
        return equipmentRepo.findAll();
    }

    public void deleteById(String equipmentId){
        equipmentRepo.deleteById(equipmentId);
    }

    public boolean checkExist(String equipmentId){
        return equipmentRepo.existsById(equipmentId);
    }
}
