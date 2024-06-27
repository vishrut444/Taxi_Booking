package com.vishrut.TaxiBooking.repository;

import com.vishrut.TaxiBooking.model.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFormRepository extends JpaRepository<BookingForm,Integer> {
}
