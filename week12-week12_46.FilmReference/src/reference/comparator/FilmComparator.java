/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author User
 */
public class FilmComparator implements Comparator<Film> {

    Map<Film, List<Rating>> films;

    public FilmComparator(Map<Film, List<Rating>> films) {

        this.films = films;
    }

    public double getAverageRating(Film film) {
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        
        ratings.addAll(films.get(film));
        
        double score = 0;
        
        for(Rating r : ratings) {
            score += r.getValue();
        }
        
        return score / ratings.size();
    }

    @Override
    public int compare(Film f1, Film f2) {
        return (int) getAverageRating(f2) - (int) getAverageRating(f1);
    }

}
