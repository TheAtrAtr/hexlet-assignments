package exercise.controller;

import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

// Зависимости для самостоятельной работы
// import org.springframework.data.querydsl.binding.QuerydslPredicate;
// import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
    @GetMapping(path = "")
    public Iterable<User> getUserByFirstNameAndLastName(@RequestParam(value = "firstName", defaultValue = "") String fName, @RequestParam(value = "lastName", defaultValue = "") String lName) {
        return userRepository.findAll(QUser.user.firstName.containsIgnoreCase(fName).andAnyOf(QUser.user.lastName.containsIgnoreCase(lName)));
    }
    // END
}

