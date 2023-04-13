public class MoviePosterManager {
    private Movie[] titles = new Movie[0];
    private int limit;

    public MoviePosterManager(int limit) {
        this.limit = limit;
    }


    public void addMovie(Movie title) {
        Movie[] tmp = new Movie[titles.length + 1];
        for (int i = 0; i < titles.length; i++) {
            tmp[i] = titles[i];
        }
        tmp[tmp.length - 1] = title;
        titles = tmp;
    }

    public Movie[] findAll() {
        return titles;
    }

    public Movie[] findLast() {
        int resultLength;
        if (titles.length < limit) {
            resultLength = titles.length;
        } else {
            resultLength = limit;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = titles[titles.length - 1 - i];
        }
        return result;
    }
}
