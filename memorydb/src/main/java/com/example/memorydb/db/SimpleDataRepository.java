package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    //create, update
    @Override
    public T save(T data) {

        if (Objects.isNull(data)) { //데이터가 Null이면
            throw new RuntimeException("Data is null");
        }

        //db에 데이터가 이미 있나?
        Optional<T> prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if (prevData.isPresent()) {
            //기존 데이터 있는 경우 -> 기존 데이터 지우고 -> 업데이트
            dataList.remove(prevData.get());
            dataList.add(data);
        } else {
            //기존 데이터 없는 경우 -> 인덱스 ++, 데이터 저장
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }


    //read
    //id로 하나 찾기
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList
                .stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    //delete
    @Override
    public void delete(ID id) {
        Optional<T> deleteEntity = dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id) );
                })
                .findFirst();


        //데이터가 있는 경우
        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }



}
