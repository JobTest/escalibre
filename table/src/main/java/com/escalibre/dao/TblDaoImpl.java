package com.escalibre.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.escalibre.model.Tbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class TblDaoImpl implements TblDao {

    private static final String FIND_TBLA_ALL_QUERY = "SELECT * FROM tbla",
            FIND_TBLB_ALL_QUERY = "SELECT * FROM tblb",
            INSERT_TBLA_QUERY = "INSERT INTO tbla (word,id) VALUES (:word,:id)",
            INSERT_TBLB_QUERY = "INSERT INTO tblb (word,id) VALUES (:word,:id)";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    @Override public void addTbla(Tbl tbl) {
        Map params = new HashMap();
        params.put("word", tbl.getWord());
        params.put("id", tbl.getId());
        namedParameterJdbcTemplate.update(INSERT_TBLA_QUERY, params);
    }

    @Override public void addTblb(Tbl tbl) {
        Map params = new HashMap();
        params.put("word", tbl.getWord());
        params.put("id", tbl.getId());
        namedParameterJdbcTemplate.update(INSERT_TBLB_QUERY, params);
    }

    @Override public List<Tbl> findTblaAll() {
        Map<String, Object> params = new HashMap<>();
        List<Tbl> tbls = namedParameterJdbcTemplate.query(FIND_TBLA_ALL_QUERY, params, new ItemMapper());
        return tbls;
    }

    @Override public List<Tbl> findTblbAll() {
        Map<String, Object> params = new HashMap<>();
        List<Tbl> tbls = namedParameterJdbcTemplate.query(FIND_TBLB_ALL_QUERY, params, new ItemMapper());
        return tbls;
    }

    private static final class ItemMapper implements RowMapper<Tbl> {
        public Tbl mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tbl user = new Tbl();
            user.setWord(rs.getString("word"));
            user.setId(rs.getString("id"));
            return user;
        }
    }
}
