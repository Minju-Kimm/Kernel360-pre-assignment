package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //select * from user where score >= ??
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    //select * from user where score >= ?? AND score <= ??
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    @Query(
            value = "select * from user as u where u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> findScore(
            @Param(value = "min") int min,
            @Param(value = "max") int max);
}
