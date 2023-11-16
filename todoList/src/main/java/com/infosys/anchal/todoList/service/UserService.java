package com.infosys.anchal.todoList.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.anchal.todoList.entity.User;
import com.infosys.anchal.todoList.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isUsernameUnique(String username) {
        User existingUser = userRepository.findByUsername(username);
        return existingUser == null;
    }

    public void registerUser(User user) {
        if (!isEmailValid(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!isUsernameUnique(user.getUsername())) {
            throw new IllegalArgumentException("Username is already taken");
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
    
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordMatches(user, password)) {
            return user;
        }
        return null;
    }
    
    private boolean passwordMatches(User user, String providedPassword) {
        return passwordEncoder.matches(providedPassword, user.getPassword());
    }
    
}
