package vn.edu.eiu.student_view.final_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.student_view.final_test.model.User;
import vn.edu.eiu.student_view.final_test.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void save(User user){
        userRepo.save(user);
    }

    public User findByUsername(String username){
        return userRepo.findByUsernameIgnoreCase(username);
    }
}
