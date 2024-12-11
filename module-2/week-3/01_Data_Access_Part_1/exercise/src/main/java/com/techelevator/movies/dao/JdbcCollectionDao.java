package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        String sql = "SELECT * FROM collection";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return mapRowsToCollections(results);
    }

    @Override
    public Collection getCollectionById(int id) {
        String sql = "SELECT * FROM collection WHERE collection_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapCollectionToRow(results);
        }
        return null;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        String sql = "SELECT * FROM collection WHERE collection_name ILIKE ?;";

        if (useWildCard) {
            name = "%" + name + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        return mapRowsToCollections(results);
    }

    private Collection mapCollectionToRow(SqlRowSet results) {
        Collection collection = new Collection();
        collection.setId(results.getInt("collection_id"));
        collection.setName(results.getString("collection_name"));
        return collection;
    }

    private List<Collection> mapRowsToCollections(SqlRowSet results) {
        List<Collection> c = new ArrayList<>();

        while (results.next()) {
            c.add(mapCollectionToRow(results));
        }

        return c;
    }
}
