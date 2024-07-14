package com.example.jpa.user.db;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user") //해당 오브젝트를 데이터베이스의 user 테이블과 맵핑
public class UserEntity {

    @Id //pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //하나씩 증가하는 값
    private Long id;

    private String name;

    private Integer age;

    private String email;

}
