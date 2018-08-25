package com.example.demo.b0000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo._config.db.SqlTemplate_FreeMarker;
import com.example.demo._config.db.SqlTemplate_PlainText;

import ninja.cero.sqltemplate.core.SqlTemplate;

@Service
@Transactional(readOnly = true)
public class B0000Service {

    @Autowired
    private SqlTemplate sqlTemplate1;

    @Autowired
    @SqlTemplate_FreeMarker
    private SqlTemplate sqlTemplate2;

    @Autowired
    @SqlTemplate_PlainText
    private SqlTemplate sqlTemplate3;

    public void select() {
        List<Map<String, Object>> list = sqlTemplate1.forList("sql/b0000/select.sql");
        list.forEach(e -> {
            e.forEach((k, v) -> {
                System.out.printf("%s:%s%n", k, v);
            });
        });
    }

    public void select2() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userid", "user-001");
        params.put("mailaddr", "ii@ii.com");
        params.put("delflg", "0");
        List<Map<String, Object>> list = sqlTemplate2.forList("sql/b0000/select2.sql", params);
        list.forEach(e -> {
            e.forEach((k, v) -> {
                System.out.printf("%s:%s%n", k, v);
            });
        });
    }

    public void select3() {
        List<Map<String, Object>> list = sqlTemplate3.forList("select user_id from t_userr");
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
