package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@RestController //응답값이 json으로 내리겠다는 선언
@Controller //응답값 다양한 컨트롤러의 경우
@RequestMapping("/api/v1")
public class ResponseApiController {

//    @GetMapping("")
//    @RequestMapping(path = "", method = RequestMethod.GET)
/*    @ResponseBody
    public ResponseEntity user() {
        UserRequest user = new UserRequest();
        user.setUserName("민주킴");
        user.setUserAge(21);
        user.setEmail("test@test.com");

        log.info("user: {}", user);

        ResponseEntity response = ResponseEntity
                .status(HttpStatus.BAD_REQUEST) *//*상태코드 변경*//*
                .header("x-custom", "hi") *//* header 추가 *//*
                .body(user);

        return response;
    }*/
}
