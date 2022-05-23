package br.com.msandredev.api.services;

import br.com.msandredev.api.domain.User;
import br.com.msandredev.api.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
}
