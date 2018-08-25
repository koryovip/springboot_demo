package com.example.demo.b0000;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ninja.cero.sqltemplate.core.SqlTemplate;

@Service
@Transactional(readOnly = true)
public class B0000Service {

    @Autowired
    private SqlTemplate sqlTemplate;

    public void select() {
        List<Map<String, Object>> list = sqlTemplate.forList("sql/b0000/select.sql");
        list.forEach(e -> {
            e.forEach((k, v) -> {
                System.out.printf("%s:%s%n", k, v);
            });
        });
    }

    @Transactional
    public void update() {
        update1();
        update2();
    }

    private void update1() {

    }

    private void update2() {

    }
}
