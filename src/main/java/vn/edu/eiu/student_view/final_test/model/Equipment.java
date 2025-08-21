package vn.edu.eiu.student_view.final_test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Equipment")
public class Equipment {
    @Id
    @Column(name = "equipmentId",columnDefinition = "CHAR(10)")
    private String equipmentId;

    @Column(name = "equipmentName",columnDefinition = "VARCHAR(150)")
    @Size(min = 5, max = 100,message = "Name must be between 5 and 100 characters")
    private String equipmentName;

    @Column(name = "equipmentType",columnDefinition = "DECIMAL(10,2)",nullable = false)
    @Min(value = 1000,message = "Purchase price must be greater than 1000")
    private double purchasePrice;

    @Column(name = "quantityAvailable",columnDefinition = "INT",nullable = false)
    @Min(value = 1,message = "Quantity must be between 0-500")
    @Max(value = 500,message = "Quantity must be between 0-500")
    private int quantityAvailable;

//    @Column(name = "purchaseDate",columnDefinition = "DATETIME")
//    @CreationTimestamp
//    private LocalDateTime purchaseDate;

    @ManyToOne
    @JoinColumn(name = "equipmentTypeId")
    private EquipmentType equipmentType;

    public Equipment(String equipmentId, String equipmentName, double purchasePrice, int quantityAvailable) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.purchasePrice = purchasePrice;
        this.quantityAvailable = quantityAvailable;

    }
}
