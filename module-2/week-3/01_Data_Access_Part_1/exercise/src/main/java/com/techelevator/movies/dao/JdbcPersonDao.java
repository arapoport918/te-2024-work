package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        String sql = "SELECT * FROM person;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return mapRowstoPeople(results);
    }

    @Override
    public Person getPersonById(int id) {
        String sql = "SELECT * FROM person WHERE person_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return new Person(mapRowToPerson(results).getId(), mapRowToPerson(results).getName(),
                    mapRowToPerson(results).getBirthday(), mapRowToPerson(results).getDeathDate(),
                    mapRowToPerson(results).getBiography(), mapRowToPerson(results).getProfilePath(),
                    mapRowToPerson(results).getHomePage());
        }
        return null;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        String sql = "SELECT * FROM person WHERE person_name ILIKE ?;";

        if (useWildCard) {
            name = "%" + name + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        return mapRowstoPeople(results);
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        String sql = "SELECT DISTINCT p.* FROM person p JOIN  movie_actor ma ON ma.actor_id = p.person_id JOIN movie m ON m.movie_id = ma.movie_id " +
                "JOIN collection c ON c.collection_id = m.collection_id WHERE c.collection_name ILIKE ? ORDER BY p.person_name ASC;";

        if (useWildCard) {
            collectionName = "%" + collectionName + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);
        return mapRowstoPeople(results);
    }

    private Person mapRowToPerson(SqlRowSet results) {
        Person person = new Person();

        person.setId(results.getInt("person_id"));
        person.setName(results.getString("person_name"));

        if (results.getDate("birthday") != null) {
            person.setBirthday(results.getDate("birthday").toLocalDate()); //does not allow nulls
        }

        if (results.getDate("deathday") != null) {
            person.setDeathDate(results.getDate("deathday").toLocalDate());
        }

        if (results.getString("biography") != null) {
            person.setBiography(results.getString("biography"));
        }

        if (results.getString("profile_path") != null) {
            person.setProfilePath(results.getString("profile_path"));
        }

        if (results.getString("home_page") != null) {
            person.setHomePage(results.getString("home_page"));
        }

        return person;
    }

    private List<Person> mapRowstoPeople(SqlRowSet results) {
        List<Person> p = new ArrayList<>();

        while (results.next()) {
            p.add(mapRowToPerson(results));
        }

        return p;
    }
}
