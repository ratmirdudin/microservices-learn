package com.ratmirdudin.userservice.controller;

import com.ratmirdudin.userservice.VO.ResponseTemplateVO;
import com.ratmirdudin.userservice.entity.User;
import com.ratmirdudin.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method id UserController");
        return userService.getUserWithDepartment(userId);
    }
}
