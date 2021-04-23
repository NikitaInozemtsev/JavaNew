import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.model.User;
import ru.repositories.UserRepository;
import ru.services.UserService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder encoder;
    @Captor
    ArgumentCaptor<User> captor;
    @Test
    void getUserByUsername() {
        User user = new User();
        user.setUsername("Okone");
        User user2 = new User();
        user2.setUsername("OkoneDocker");
        UserService userService = new UserService(userRepository, encoder);
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.of(user));
        Mockito.when(userRepository.findById(user2.getUsername())).thenReturn(java.util.Optional.of(user2));
        Assertions.assertEquals("Okone", userService.loadUserByUsername(user.getUsername()).getUsername());
        Assertions.assertEquals("OkoneDocker", userService.loadUserByUsername(user2.getUsername()).getUsername());
    }
    @Test
    void save() {
        User user = new User();
        user.setUsername("Vitya");
        UserService userService = new UserService(userRepository, encoder);
        userService.signUpUser(user);
        Mockito.verify(userRepository).save(captor.capture());
        User captured = captor.getValue();
        Assertions.assertEquals("Vitya", captured.getUsername());
    }
}
