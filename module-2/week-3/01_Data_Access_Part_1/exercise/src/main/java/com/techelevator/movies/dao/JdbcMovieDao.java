package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        String sql = "SELECT * FROM movie";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return mapRowsToMovies(results);
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "SELECT * FROM movie WHERE movie_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return new Movie (mapRowToMovie(results).getId(), mapRowToMovie(results).getTitle(), mapRowToMovie(results).getOverview(),
                    mapRowToMovie(results).getTagline(), mapRowToMovie(results).getPosterPath(), mapRowToMovie(results).getHomePage(),
                    mapRowToMovie(results).getReleaseDate(), mapRowToMovie(results).getLengthMinutes(), mapRowToMovie(results).getDirectorId(),
                    mapRowToMovie(results).getCollectionId());
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        String sql = "SELECT * FROM movie WHERE title ILIKE ?;";

        if (useWildCard) {
            title = "%" + title + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
        return mapRowsToMovies(results);
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {
        LocalDate start = LocalDate.of(startYear, 1, 1);
        LocalDate end  = LocalDate.of(endYear, 12, 31);
        String sql = "SELECT * FROM movie m JOIN person p ON p.person_id = m.director_id " +
                "WHERE p.person_name ILIKE ? AND m.release_date BETWEEN ? AND ? ORDER BY m.title;";

        if (useWildCard) {
            directorName = "%" + directorName + "%";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, directorName, start, end);
        return mapRowsToMovies(results);
    }

    private Movie mapRowToMovie(SqlRowSet results) {
        Movie movie = new Movie();
        movie.setId(results.getInt("movie_id"));
        movie.setTitle(results.getString("title"));

        if (results.getString("overview") != null) {
            movie.setOverview(results.getString("overview"));

        }

        if (results.getString("tagline") != null) {
            movie.setTagline(results.getString("tagline"));

        }
        movie.setPosterPath(results.getString("poster_path"));

        if (results.getString("home_page") != null) {
            movie.setHomePage(results.getString("home_page"));
        }

        if (results.getDate("release_date") != null) {
            movie.setReleaseDate(results.getDate("release_date").toLocalDate());
        }

        movie.setLengthMinutes(results.getInt("length_minutes"));
        movie.setDirectorId(results.getInt("director_id"));
        movie.setCollectionId(results.getInt("collection_id"));

        return movie;
    }

    private List<Movie> mapRowsToMovies(SqlRowSet results) {
        List<Movie> m = new ArrayList<>();

        while (results.next()) {
            m.add(mapRowToMovie(results));
        }

        return m;
    }
}
