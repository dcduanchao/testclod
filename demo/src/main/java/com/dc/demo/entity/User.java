package com.dc.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author duanchao
 * @CreateDate: 2019/10/11 0011 14:06
 */

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
public class User {

    String name ;

    Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(name, user.name) &&
//                Objects.equals(age, user.age);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
