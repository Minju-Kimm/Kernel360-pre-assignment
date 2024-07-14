package com.example.memorydb.user.model;


import com.example.memorydb.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {

    private String name; //사용자 이름

    private int score; //사용자 점수
}
