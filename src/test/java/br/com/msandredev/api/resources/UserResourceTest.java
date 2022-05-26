package br.com.msandredev.api.resources;

import br.com.msandredev.api.domain.User;
import br.com.msandredev.api.domain.dto.UserDTO;
import br.com.msandredev.api.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserResourceTest {

    public static final Integer ID = 1;
    public static final String FULL_NAME = "Andre";
    public static final String EMAIL = "andre@mail.com";
    public static final String PASSWORD = "123";
    public static final int INDEX = 0;
    public static final String EMAIL_JA_UTILIZADO = "E-mail já utilizado por outro usuário. Favor utilizar outro e-mail!";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado!";

    private User user;
    private UserDTO userDTO;

    @InjectMocks
    private UserResource resource;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = new User(ID, FULL_NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, FULL_NAME, EMAIL, PASSWORD);
    }
}