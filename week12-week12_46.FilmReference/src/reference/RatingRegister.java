/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author User
 */
public class RatingRegister {

    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> reviewerRatings;

    public RatingRegister() {
        this.filmRatings = new HashMap<Film, List<Rating>>();
        this.reviewerRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!filmRatings.containsKey(film)) {
            filmRatings.put(film, new ArrayList<Rating>());
        }
        filmRatings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!reviewerRatings.containsKey(person)) {
            reviewerRatings.put(person, new HashMap<Film, Rating>());
        }
        reviewerRatings.get(person).put(film, rating);
        addRating(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        if (!reviewerRatings.containsKey(person)) { //Person nicht vorhanden
            return Rating.NOT_WATCHED;
        }

        if (reviewerRatings.get(person).get(film) != null) { //Bwertung vorhanden
            return reviewerRatings.get(person).get(film); // Bewertung ausgeben
        } else {
            return Rating.NOT_WATCHED; //keine Bewertung vorhanden
        }

    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (reviewerRatings.containsKey(person)) {
            return reviewerRatings.get(person);
        } else {
            return new HashMap<Film, Rating>();
        }
    }

    public List<Person> reviewers() {
        List reviewers = new ArrayList();

        reviewers.addAll(reviewerRatings.keySet());

        return reviewers;
    }

}
