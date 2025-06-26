package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Users users = (Users) target;
        if (users.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "emptyError", "");
        } else if (users.getFirstName().length() < 5 || users.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "firstNameError", "");
        }
        if (users.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "emptyError", "lastName not empty");
        } else if (users.getLastName().length() < 5 || users.getLastName().length() > 45) {
            errors.rejectValue("lastName", "lastNameError", "");
        }
        if (users.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", "emptyError", "");
        } else if (!users.getPhoneNumber().matches("^0\\d{9}$")) {
            errors.rejectValue("phoneNumber", "phoneError", "");
        }

        if (users.getAge() == null) {
            errors.rejectValue("age", "emptyError", "");
        } else if (users.getAge() < 18) {
            errors.rejectValue("age", "ageError", "");
        }
        if (users.getEmail().isEmpty()) {
            errors.rejectValue("email", "emptyError", "");
        } else if (!users.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", "emailError", "");
        }
    }
}
