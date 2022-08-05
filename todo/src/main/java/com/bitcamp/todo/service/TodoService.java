package com.bitcamp.todo.service;

import com.bitcamp.todo.Persistence.TodoRepository;
import com.bitcamp.todo.model.TodoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<TodoEntity> create(final TodoEntity entity) {
        // 1.저장 할 엔티티가 유효한지 확인
        validate(entity);
        repository.save(entity);

        log.info("entity Id : {} is saved",entity.getId());
        return repository.findByUserId(entity.getUserId());
    }

    private void validate(final TodoEntity entity) {
        // 유효성 검사
        if (entity == null) {
            log.warn("Null!!!!!!!");
            throw new RuntimeException("Entity cannot be null");
        }
        if (entity.getUserId() == null) {
            log.warn("UnKnown user");
            throw new RuntimeException("UnKnown user!");
        }
    }

}

    /*public String testSe(){
        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first").build();
        // TodoEntity 저장
        repository.save(entity);
        return "";
    }*/

