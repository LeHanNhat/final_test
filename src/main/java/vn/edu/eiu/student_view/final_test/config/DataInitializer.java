package vn.edu.eiu.student_view.final_test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.eiu.student_view.final_test.model.Equipment;
import vn.edu.eiu.student_view.final_test.model.EquipmentType;
import vn.edu.eiu.student_view.final_test.model.User;
import vn.edu.eiu.student_view.final_test.service.EquipmentService;
import vn.edu.eiu.student_view.final_test.service.EquipmentTypeService;
import vn.edu.eiu.student_view.final_test.service.UserService;



@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private UserService userServ;


    @Override
    public void run(String... args) throws Exception {
        Equipment e1 = new Equipment("E1","Electro1",2000,200);
        Equipment e2 = new Equipment("E2","Electro2",2000,200);
        Equipment e3 = new Equipment("E3","Electro3",2000,200);
        Equipment e4 = new Equipment("E4","Electro4",2000,200);


        EquipmentType type1 = new EquipmentType("Electronics","");
        EquipmentType type2 = new EquipmentType("Furniture","");
        type1.addEquipment(e1);
        type1.addEquipment(e2);
        type2.addEquipment(e3);
        type2.addEquipment(e4);
        equipmentTypeService.save(type1);
        equipmentTypeService.save(type2);

        User admin = new User("admin","admin",1);
        User staff = new User("staff","staff",2);
        User student = new User("student","student",3);
        userServ.save(admin);
        userServ.save(staff);
        userServ.save(student);

    }
}
