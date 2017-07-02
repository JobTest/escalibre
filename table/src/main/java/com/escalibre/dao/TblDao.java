package com.escalibre.dao;

import com.escalibre.model.Tbl;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface TblDao {

    void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate);

    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();

    void addTbla(Tbl tbl);

    void addTblb(Tbl tbl);

    List<Tbl> findTblaAll();

    List<Tbl> findTblbAll();
}
