package vn.techmaster.demosession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import vn.techmaster.demosession.exception.UserException;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.service.UserService;

@SpringBootTest
public class TestUserService {
    @Autowired private UserService userService;

    @Test
    public void addUser() {
        User user = userService.addUser("Nguyễn Mạnh Cường", "ngmanhcuong2001@gmail.com", "1234");
        assertThat(user).isNotNull();
    }

    @Test
    public void login_when_account_is_pending() {
    userService.addUser("Nguyễn Mạnh Cường", "ngmanhcuong2001@gmail.com", "1234");
    assertThatThrownBy(() -> {
      userService.login("ngmanhcuong2001@gmail.com", "1234");
    }).isInstanceOf(UserException.class)
    .hasMessageContaining("User is not activated");
    }

    @Test
    public void login_when_account_is_not_found() {
    assertThatThrownBy(() -> {
      userService.login("manhcuong@gmail.com", "1234-");
    }).isInstanceOf(UserException.class)
    .hasMessageContaining("User is not found");
  }

  @Test
  public void login_when_password_is_incorrect() {
    userService.addUserThenAutoActivate("Nguyễn Mạnh Cường", "ngmanhcuong2001@gmail.com", "1234-");
    assertThatThrownBy(() -> {
      userService.login("ngmanhcuong2001@gmail.com", "1234+");
    }).isInstanceOf(UserException.class)
    .hasMessageContaining("Password is incorrect");
  }

  @Test
  public void login_successful() {
    userService.addUserThenAutoActivate("Nguyễn Mạnh Cường", "ngmanhcuong2001@gmail.com", "1234-");
    User user = userService.login("ngmanhcuong2001@gmail.com", "1234-");
    assertThat(user).isNotNull();
  }
}
