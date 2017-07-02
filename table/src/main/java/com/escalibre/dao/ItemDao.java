package com.escalibre.dao;

import com.escalibre.model.Item;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface ItemDao {

    void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate);
    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();

    List<Item> findTblaAll();
    List<Item> findTblbAll();
    void putTbla(Item item);
    void putTblb(Item item);
}
