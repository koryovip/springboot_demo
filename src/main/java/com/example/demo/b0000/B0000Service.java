package com.example.demo.b0000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo._config.db.SqlTemplate_FreeMarker;
import com.example.demo._config.db.SqlTemplate_PlainText;
import com.example.demo._db.D_B;

import ninja.cero.sqltemplate.core.PlainTextSqlTemplate;
import ninja.cero.sqltemplate.core.SqlTemplate;
import pa.db.aaa.col.T_USERR_COL;
import pa.db.aaa.dto.T_USERR_DTO;
import pa.db.aaa.tbl.T_USERR;

@Service
@Transactional(readOnly = true)
public class B0000Service {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private SqlTemplate sqlTemplate1;

    @Autowired
    @SqlTemplate_FreeMarker
    private SqlTemplate sqlTemplate2;

    @Autowired
    @SqlTemplate_PlainText
    private PlainTextSqlTemplate sqlTemplate3;

    @Autowired
    private D_B db;

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

    @Transactional(readOnly = false, rollbackFor = { Throwable.class })
    public void insert0() throws /*SQLException*/ Exception {
        {
            T_USERR tbl = T_USERR.$("zzzz");
            T_USERR_COL.user_id.set("0", tbl);
            T_USERR_COL.password.set("0", tbl);
            T_USERR_COL.mail_addr.set("0", tbl);
            T_USERR_COL.del_flg.set("0", tbl);
            // sqlTemplate3.update(tbl.insert(), tbl.getParams1());
            db.insert(tbl);

            int ii = 0;
            if (ii == 0) {
                throw new Exception("aaaaaaaaaaaa");
            }
            T_USERR_COL.user_id.set("1", tbl);
            T_USERR_COL.mail_addr.set("1", tbl);
            T_USERR_COL.del_flg.set("1", tbl);
            db.insert(tbl);
        }
        {
            T_USERR tbl = T_USERR.$();
            T_USERR_COL.user_id.where(tbl, "user-001");
            T_USERR_DTO row = db.selectOne(T_USERR_DTO.class, tbl.selectColumnAll(), tbl);
            if (row != null) {
                logger.debug(row.dump());
            }
        }
        {
            T_USERR tbl = T_USERR.$();
            List<T_USERR_DTO> list = db.select(T_USERR_DTO.class, tbl.selectColumnAll(), tbl);
            list.forEach(row -> {
                logger.debug(row.dump());
            });
        }
    }

    @Transactional(readOnly = false, rollbackFor = { Throwable.class })
    public void insert0(int count) throws /*SQLException*/ Exception {
        T_USERR tbl = T_USERR.$("init");
        T_USERR_COL.del_flg.set("0", tbl);
        for (int ii = 0; ii < count; ii++) {
            T_USERR_COL.user_id.set(String.format("user-%04d", ii), tbl);
            T_USERR_COL.password.set(String.format("pass-%04d", ii), tbl);
            T_USERR_COL.mail_addr.set(String.format("mail-%04d", ii), tbl);
            db.insert(tbl);
        }
    }

    @Transactional(readOnly = false, rollbackFor = { Throwable.class })
    public void update() throws Exception {
        update1();
        int ii = 0;
        if (ii == 0) {
            throw new Exception("aaaaaaaaaaaa");
        }
        update2();
    }

    private void update1() {
        sqlTemplate3.update("insert into t_t (user_id) values (?)", "11");
    }

    private void update2() {
        sqlTemplate3.update("insert into t_t (user_id) values (?)", "12345");
    }
}
