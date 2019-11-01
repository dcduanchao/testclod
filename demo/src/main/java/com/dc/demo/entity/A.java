package com.dc.demo.entity;

import lombok.Data;

/**
 * @author duanchao
 * @CreateDate: 2019/10/10 0010 16:12
 */
@Data
public class A implements B {

    String cA;

    @Override
    public String m() {
        return "123";
    }

    public A(String cA) {
        this.cA = cA;
    }

    public A() {
    }
}
