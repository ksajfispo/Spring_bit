package com.bitcamp.todo.Persistence;

import com.bitcamp.todo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    List<TodoEntity> findByUserId(String userId);
    //UserId뒤에 And 연산자도 사용 가능 fidBy뒤에 TodoEntity에 만들었던 것도 가져와 쓸 수 있음

    
    /*// ?1 은 메서드의 매개변수의 순서 위치
    @Query("SELECT t FROM TodoEntity t WHERE t.userId =?1 ")
    TodoEntity findByUserIdQuery(String userId);*/
}
