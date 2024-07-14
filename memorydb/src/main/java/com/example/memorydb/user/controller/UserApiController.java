package com.example.memorydb.user.controller;


import com.example.memorydb.entity.Entity;
import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //HTTP 요청이 들어오는 내용 처리, 응답 처리하는 영역
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자 메소드로 채워달라!
public class UserApiController {

    private final UserService userService;

    //Create, Update
    @PutMapping(" ")
    public UserEntity create(
        @RequestBody UserEntity userEntity
    ) {
        return userService.save(userEntity);
    }

    //Read
    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }


    @GetMapping("/userId/{id}") //findById -> path variable
    public UserEntity findById(@PathVariable Long id) {
        Optional<UserEntity> response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> moreThanSeventy(
            @RequestParam int score
    ) {
        return userService.filterScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(
            @RequestParam int min,
            @RequestParam int max
    ) {
        return userService.filterScore(min, max);
    }

    //Delete
    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
            ) {
//        userService.delete(id);
    }



}
