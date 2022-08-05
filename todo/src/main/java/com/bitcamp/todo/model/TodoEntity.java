package com.bitcamp.todo.model;

//Entity = table

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // 자바 클래스를 엔티티로 지정
@Table(name="Todo") // 대소문자 구분 x Mysql 테이블 , 테이블 이름을 지정

public class TodoEntity {
    // 오브젝트 아이디 @Id는 기본 키가 될 필드에 지정한다.
    @Id
    @GeneratedValue(generator ="uuid2") // ID 자동생성
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
