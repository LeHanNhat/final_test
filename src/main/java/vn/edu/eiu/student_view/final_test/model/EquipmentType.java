package vn.edu.eiu.student_view.final_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EquipmentType")
public class EquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipmentTypeId")
    private long id;

    @Column(name = "typeName",columnDefinition = "VARCHAR(100)",nullable = false,unique = true)
    private String typeName;

    @Column(name = "description",columnDefinition = "VARCHAR(255)")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "equipmentType")
    private List<Equipment> equipments = new ArrayList<>();

    public void addEquipment(Equipment equipment){
        equipments.add(equipment);
        equipment.setEquipmentType(this);

    }
    public void removeEquipment(Equipment equipment){
        equipments.remove(equipment);
        equipment.setEquipmentType(null);
    }

    public EquipmentType(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
    }
}
