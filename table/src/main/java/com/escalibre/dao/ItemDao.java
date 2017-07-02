package com.escalibre.dao;

import com.escalibre.model.Item;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface ItemDao {

    void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate);

    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();

    void addTbla(Item item);

    void addTblb(Item item);

    List<Item> findTblaAll();

    List<Item> findTblbAll();
}
