package com.pacmanface.jpatacos.data;

import org.springframework.data.repository.CrudRepository;
import com.pacmanface.jpatacos.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
