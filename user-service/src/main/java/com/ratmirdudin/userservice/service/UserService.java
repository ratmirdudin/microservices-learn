package com.ratmirdudin.userservice.service;

import com.ratmirdudin.userservice.VO.Department;
import com.ratmirdudin.userservice.VO.ResponseTemplateVO;
import com.ratmirdudin.userservice.entity.User;
import com.ratmirdudin.userservice.exception.ResourceNotFoundException;
import com.ratmirdudin.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Resource with id: " + userId + " not found"));
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);
        return new ResponseTemplateVO(user, department);
    }
}
