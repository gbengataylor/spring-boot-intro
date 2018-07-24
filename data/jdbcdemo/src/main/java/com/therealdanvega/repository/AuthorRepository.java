package com.therealdanvega.repository;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public AuthorRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Author> getAuthors() {
        String sql = "select * from author";
        return jdbc.query(sql, (rs,i) -> new Author(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"))
        );

    }
}
