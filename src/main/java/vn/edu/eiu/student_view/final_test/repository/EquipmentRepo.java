package vn.edu.eiu.student_view.final_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.student_view.final_test.model.Equipment;

import java.util.List;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
    List<Equipment> findByEquipmentName(String equipmentName);
}
