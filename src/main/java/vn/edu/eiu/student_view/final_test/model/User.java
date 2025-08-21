package vn.edu.eiu.student_view.final_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long id;
    @Column(name = "username",columnDefinition = "VARCHAR(50)",nullable = false,unique=true)
    private String username;
    @Column(name = "password",columnDefinition = "VARCHAR(255)",nullable = false)
    private String password;
    @Column(nullable = false)
    private int role;

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
