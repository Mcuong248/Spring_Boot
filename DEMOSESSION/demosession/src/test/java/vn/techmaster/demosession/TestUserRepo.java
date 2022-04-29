package vn.techmaster.demosession;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import vn.techmaster.demosession.model.State;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.repository.UserRepo;

////@SpringBootTest
public class TestUserRepo {
    @Test
    public void addUser() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("John Levy", "levy@gmail.com", "111", State.PENDING);
        assertThat(user).isNotNull();
        System.out.println(user.getId());
        assertThat(user.getId()).isNotBlank();
    }

    @Test
    public void addUserWithPendingState() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("John Levy", "levy@gmail.com", "111");
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
        assertThat(user.getState()).isEqualTo(State.PENDING);
    }

    @Test
    public void isEmailExist() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("John Levy", "levy@gmail.com", "111");
        userRepo.addUser("Mạnh Cường", "cuong85@gmail.com", "222");
        userRepo.addUser("Minh Thái", "thainq@gmail.com", "333");

        assertThat(userRepo.isEmailExist("levy@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("thaiNQ@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("Cuong85@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("Cuong85@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("cuong86@gmail.com")).isFalse();

    }

    @Test
    public void findByEmail() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("John Levy", "levy@gmail.com", "111");
        userRepo.addUser("Mạnh Cường", "cuong85@gmail.com", "222");
        userRepo.addUser("Minh Thái", "thainq@gmail.com", "333"); 

        assertThat(userRepo.findByEmail("levy@Gmail.COM")).isPresent();
        assertThat(userRepo.findByEmail("thaiNQ@Gmail.COM")).isPresent();
        assertThat(userRepo.findByEmail("thaiNQ1@Gmail.COM")).isNotPresent();
    }
}
