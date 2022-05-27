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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(FULL_NAME, response.getBody().getFullName());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

    @Test
    void whenFindAllThenReturnAListOfUserDTO() {
        when(service.findAll()).thenReturn(List.of(user));
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<List<UserDTO>> response = resource.findAll();

        assertNotNull(response); // response would not be null
        assertNotNull(response.getBody()); // body of response would not be null
        assertEquals(HttpStatus.OK, response.getStatusCode()); // the status code must be 200 (OK)
        assertEquals(ResponseEntity.class, response.getClass()); // the class of response must be a ResponseEntity
        assertEquals(ArrayList.class, response.getBody().getClass()); // the class of body on the response must be an ArrayList
        assertEquals(UserDTO.class, response.getBody().get(INDEX).getClass()); // the class of body on the position 0 (zero) must be a UserDTO

        assertEquals(ID, response.getBody().get(INDEX).getId()); // the ID of the first element on the response must be the same here
        assertEquals(FULL_NAME, response.getBody().get(INDEX).getFullName()); // the NAME of the first element on the response must be the same here
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail()); // the EMAIL of the first element on the response must be the same here
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword()); // the PASSWORD of the first element on the response must be the same here
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(user);

        ResponseEntity<UserDTO> response = resource.create(userDTO);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
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