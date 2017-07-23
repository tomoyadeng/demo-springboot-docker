package demo;

import demo.domain.User;
import demo.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@RestController
public class Application {
    final private UserMapper userMapper;

    public Application(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/")
    public String home() {
        return "Get started";
    }

    @RequestMapping(value = "/user", method = GET)
    public String getUserByName(@RequestParam("name") String name) {
        User user = this.userMapper.findByName(name);
        return user == null ? "No such user!" : user.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
