package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //REST API 처리하는 컨트롤러
@RequestMapping("/api") // "/api"로 시작하는 주소는 이쪽으로 요청을 받겠다
public class RestApiController {

    @GetMapping(path = "/hello") // "/api/hello" 로 요청이 들어오면 여기로 맵핑
    public String hello() {
        String html = "<html> <body> <h1> wow wow </h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}")
    public String echo(
            @PathVariable String message
    ) {
        System.out.println("message = " + message); //soutv

        //다른 변수타입 받아보기
        return message;
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ) {
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issuedDay = " + issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ) {
        System.out.println("bookQueryParam = " + bookQueryParam);
    }

    @GetMapping("/plus")
    public String AplusB(
            @RequestParam int a,
            @RequestParam int b
    ) {
        return String.valueOf(a + b);
    }

    @GetMapping("/times")
    public String AtimesB(
            @RequestParam int a,
            @RequestParam int b
    ) {
        return String.valueOf(a * b);
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete", "/user/{userName}/del"
        }
    ) //path = ~ 으로 지정 시, 여러 주소를 설정할 수도 있다
    public void delete(
            @PathVariable String userName
    ) {
        log.info("user-name : {}", userName);
    }
}
