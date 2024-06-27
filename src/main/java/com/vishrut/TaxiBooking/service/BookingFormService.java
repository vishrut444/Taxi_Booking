package com.vishrut.TaxiBooking.service;

import com.vishrut.TaxiBooking.model.BookingForm;
import com.vishrut.TaxiBooking.repository.BookingFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingFormService {
    private final BookingFormRepository bookingFormRepository;

    public BookingForm addBooking(BookingForm bookingForm) {
        return bookingFormRepository.save(bookingForm);
    }
}
