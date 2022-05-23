package br.com.msandredev.api.services.impl;

import br.com.msandredev.api.domain.User;
import br.com.msandredev.api.domain.dto.UserDTO;
import br.com.msandredev.api.repositories.UserRepository;
import br.com.msandredev.api.services.UserService;
import br.com.msandredev.api.services.exceptions.DataIntegratyViolationException;
import br.com.msandredev.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()) {
            throw new DataIntegratyViolationException("E-mail já utilizado por outro usuário. Favor utilizar outro e-mail!");
        }
    }
}
