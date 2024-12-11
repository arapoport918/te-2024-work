package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        String sql = "SELECT * FROM genre";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return mapGenresToRows(results);
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "SELECT * FROM genre WHERE genre_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return new Genre(mapGenreToRow(results).getId(), mapGenreToRow(results).getName());
        }
        return null;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        String sql = "SELECT * FROM genre WHERE genre_name ILIKE ?;";

        if (useWildCard) {
            name = "%" + name + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        return mapGenresToRows(results);
    }

    private Genre mapGenreToRow(SqlRowSet results) {
        Genre genre = new Genre();
        genre.setId(results.getInt("genre_id"));
        genre.setName(results.getString("genre_name"));
        return genre;
    }

    private List<Genre> mapGenresToRows(SqlRowSet results) {
        List<Genre> g = new ArrayList<>();
        while (results.next()) {
            g.add(mapGenreToRow(results));
        }

        return g;
    }
}
