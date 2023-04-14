import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterTest {
    MoviePosterManager poster = new MoviePosterManager(5);

    Movie title1 = new Movie(1, "Бладшот", "Боевик");
    Movie title2 = new Movie(2, "Вперед", "Мультфильм");
    Movie title3 = new Movie(3, "Отель 'Белград'", "Комедия");
    Movie title4 = new Movie(4, "Джентльмены", "Боевик");
    Movie title5 = new Movie(5, "Человек-Невидимка", "Ужасы");
    Movie title6 = new Movie(6, "Тролли. Мировой тур", "Мультфильм");
    Movie title7 = new Movie(7, "Номер один", "Комедия");

    @BeforeEach
    public void setup() {

        poster.addMovie(title1);
        poster.addMovie(title2);
        poster.addMovie(title3);
        poster.addMovie(title4);
        poster.addMovie(title5);
        poster.addMovie(title6);
        poster.addMovie(title7);

    }

    @Test
    public void shouldLimitFilms() {
        MoviePosterManager poster = new MoviePosterManager(7);

        poster.addMovie(title1);
        poster.addMovie(title2);
        poster.addMovie(title3);
        poster.addMovie(title4);
        poster.addMovie(title5);
        poster.addMovie(title6);
        poster.addMovie(title7);

        Movie[] expected = {title7, title6, title5, title4, title3, title2, title1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAll() {
        poster.findAll();

        Movie[] expected = {title1, title2, title3, title4, title5, title6, title7};
        Movie[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilms() {
        MoviePosterManager poster = new MoviePosterManager(5);

        Movie[] expected = {title7, title6, title5, title4, title3};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMinLimitMovies() {
        MoviePosterManager poster = new MoviePosterManager(5);

        poster.addMovie(title4);
        poster.addMovie(title5);
        poster.addMovie(title6);
        poster.addMovie(title7);

        Movie[] expected = {title7, title6, title5, title4};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAboveLimitMovies() {
        MoviePosterManager poster = new MoviePosterManager(5);

        poster.addMovie(title1);
        poster.addMovie(title2);
        poster.addMovie(title3);
        poster.addMovie(title4);
        poster.addMovie(title5);
        poster.addMovie(title6);
        poster.addMovie(title7);

        Movie[] expected = {title7, title6, title5, title4, title3};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
