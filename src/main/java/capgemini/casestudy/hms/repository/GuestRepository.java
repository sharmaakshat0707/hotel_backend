package capgemini.casestudy.hms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import capgemini.casestudy.hms.model.Booking;
import capgemini.casestudy.hms.model.Guest;
//import capgemini.casestudy.hms.model.Room;

public interface GuestRepository extends CrudRepository<Guest , Long>{
	
	List<Guest> findAllByBooking(Booking booking);

}
