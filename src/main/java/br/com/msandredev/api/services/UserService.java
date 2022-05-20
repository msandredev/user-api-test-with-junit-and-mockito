package br.com.msandredev.api.services;

import br.com.msandredev.api.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User findById(Integer id);
}
