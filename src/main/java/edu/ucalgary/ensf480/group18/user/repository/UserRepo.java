package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
