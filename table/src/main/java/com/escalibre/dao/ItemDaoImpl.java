package com.escalibre.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.escalibre.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ItemDaoImpl implements ItemDao {

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

    @Override public List<Item> findTblaAll() {
        Map<String, Object> params = new HashMap<>();
        List<Item> items = namedParameterJdbcTemplate.query(FIND_TBLA_ALL_QUERY, params, new ItemMapper());
        return items;
    }

    @Override public List<Item> findTblbAll() {
        Map<String, Object> params = new HashMap<>();
        List<Item> items = namedParameterJdbcTemplate.query(FIND_TBLB_ALL_QUERY, params, new ItemMapper());
        return items;
    }

    @Override public void putTbla(Item item) {
        Map params = new HashMap();
        params.put("word", item.getWord());
        params.put("id", item.getId());
        namedParameterJdbcTemplate.update(INSERT_TBLA_QUERY, params);
    }

    @Override public void putTblb(Item item) {
        Map params = new HashMap();
        params.put("word", item.getWord());
        params.put("id", item.getId());
        namedParameterJdbcTemplate.update(INSERT_TBLB_QUERY, params);
    }

    private static final class ItemMapper implements RowMapper<Item> {
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item user = new Item();
            user.setWord(rs.getString("word"));
            user.setId(rs.getString("id"));
            return user;
        }
    }
}
