package vn.edu.eiu.student_view.final_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.eiu.student_view.final_test.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsernameIgnoreCase(String username);
}
