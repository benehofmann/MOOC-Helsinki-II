/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author User
 */
public class Reference {
    private RatingRegister ratingRegister;
    
    public Reference(RatingRegister register) {
        this.ratingRegister = register;
    }
    
    public Film recommendFilm(Person person) {
     //getting the rating of a Person
     Map<Film, Rating> personalRating = ratingRegister.getPersonalRatings(person);
     
     //film Comparator
        FilmComparator filmComparator = new FilmComparator(ratingRegister.filmRatings());
        
     //getting all Films
     List<Film> films = new ArrayList<Film>();
     films.addAll(ratingRegister.filmRatings().keySet());
     
     //null if person has watched every film
     if(personalRating.size() == films.size()) {
         return null;
     }
     
     films.removeAll(personalRating.keySet());
     
     Collections.sort(films, filmComparator);
     
     return films.get(0);
    }
    
}
