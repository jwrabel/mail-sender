package pl.sda.exercises;

import org.junit.Before;
import org.junit.Test;
import pl.jwrabel.trainings.javasemiadvanced.exercises.Customer;
import pl.jwrabel.trainings.javasemiadvanced.exercises.Movie;
import pl.jwrabel.trainings.javasemiadvanced.exercises.MovieRental;
import pl.jwrabel.trainings.javasemiadvanced.exercises.exceptions.CustomerAlreadyExistsException;
import pl.jwrabel.trainings.javasemiadvanced.exercises.exceptions.MovieAlreadyExistsException;
import pl.jwrabel.trainings.javasemiadvanced.exercises.exceptions.RentalException;

import static org.junit.Assert.assertTrue;

/**
 * Created by jakubwrabel on 21.01.2017.
 */
public class MovieRentalTest {
	MovieRental movieRental;
	Customer customer;
	Movie movie;

	@Before
	public void setup() throws CustomerAlreadyExistsException, MovieAlreadyExistsException {
		movieRental = new MovieRental();

		customer =
				new Customer("Adam", "Kowalski", 1970, "ABC");
		movieRental.addCustomer(customer);

		movie = new Movie("Terminator", "action", 1992, 120, "B");
		movieRental.addMovie(movie);

	}

	@Test
	public void rent_correctCase() throws RentalException {
		movieRental.rent("ABC", "B");
	}

	@Test
	public void rent_shouldProperlyAddRental() throws RentalException {
		movieRental.rent("ABC", "B");
//
//		List<Rental> rentals = movieRental.getRentals();
//
//		for (Rental rental : rentals) {
//			if (rental.getCustomer() == customer
//					&& rental.getMovie() == movie) {
//				return;
//			}
//		}
//
//		assertTrue(false);

		boolean rentalExists = movieRental.getRentals().stream()
				.anyMatch(rent -> rent.getMovie().equals(movie) && rent.getCustomer().equals(customer));
		assertTrue(rentalExists);
	}

	@Test
	public void rent_shouldDeleteMovie() throws RentalException {
		movieRental.rent("ABC", "B");

		for (Movie movie : movieRental.getMovies()) {
			if(movie.getId().equals(this.movie.getId())){
				assertTrue(false);
			}
		}
//
//		boolean movieDeleted = movieRental.getMovies().stream().noneMatch(m -> m.getId().equals(movie.getId()));
//		assertTrue(movieDeleted);
	}
}