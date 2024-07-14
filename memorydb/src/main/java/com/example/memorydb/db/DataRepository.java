package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {

    //C(Create), U(Update)
    T save(T data);

    //R(read)
    Optional<T> findById(ID id); //데이터의 아이디를 통해 데이터 리턴, Optional -> 데이터 있을수도 없을수도 있으니까

    List<T> findAll();

    //D(Delete)
    void delete(ID id);

}
