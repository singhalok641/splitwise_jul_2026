package com.example.splitwise_jul_2026.commands;

import com.example.splitwise_jul_2026.controllers.UserController;
import com.example.splitwise_jul_2026.models.User;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{
    private  final UserController userController;

    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    // Register <username> <phone> <password>
    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        return words.length == 4 && words[0].equals(CommandKeywords.REGISTER);
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        String name = words[1];
        String phone = words[2];
        String password = words[3];

        User user = userController.registerUser(name, phone, password);
    }
}
