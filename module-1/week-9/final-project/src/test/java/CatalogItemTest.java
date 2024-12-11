import com.lendingcatalog.model.Book;
import com.lendingcatalog.model.CatalogItem;
import com.lendingcatalog.model.Movie;
import com.lendingcatalog.model.Tool;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CatalogItemTest {

    //matchesName() tests for Book, Movie, Tool
    @Test
    public void name_case_sensitive_matches_as_expected_book() {
        String input = "Club";
        LocalDate inputDate = LocalDate.of(2018, 12, 04);
        Book sut = new Book("The Club", "Joshua Robinson & Jonathan Clegg", inputDate);

        boolean output = sut.matchesName(input);

    }

    @Test
    public void name_case_sensitive_matches_as_expected_movie() {

    }

    @Test
    public void name_case_sensitive_matches_as_expected_tool() {

    }

    //matchesCreator() tests for Book, Movie, Tool
    @Test
    public void creator_case_sensitive_matches_as_expected_book() {

    }

    @Test
    public void creator_case_sensitive_matches_as_expected_movie() {

    }

    @Test
    public void creator_case_sensitive_matches_as_expected_tool() {

    }

    //matchesYear() tests for Book, Movie, Tool
    @Test
    public void year_case_sensitive_matches_as_expected_book() {

    }

    @Test
    public void year_case_sensitive_matches_as_expected_movie() {

    }

    @Test
    public void year_case_sensitive_matches_as_expected_tool() {

    }


}
