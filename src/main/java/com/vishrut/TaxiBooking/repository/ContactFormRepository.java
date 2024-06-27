package com.vishrut.TaxiBooking.repository;

import com.vishrut.TaxiBooking.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm,Integer> {


}
