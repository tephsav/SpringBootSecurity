package app.config;

import app.model.Role;
import app.model.User;
import app.service.UserService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class DbInit {

    private final UserService userService;

    public DbInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void createUsers() {
        Set<Role> roleAdmin = new HashSet<>();
        roleAdmin.add(new Role("ROLE_ADMIN"));
        userService.createUser(new User("ADMIN", 30, "ADMIN", roleAdmin));

        Set<Role> roleUser = new HashSet<>();
        roleUser.add(new Role("ROLE_USER"));
        userService.createUser(new User("USER", 20, "USER", roleUser));

        Set<Role> roleAdminUser = new HashSet<>();
        roleAdminUser.add(new Role("ROLE_ADMIN"));
        roleAdminUser.add(new Role("ROLE_USER"));
        userService.createUser(new User("ADMINUSER", 45, "ADMINUSER", roleAdminUser));
    }
}