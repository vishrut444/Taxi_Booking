package com.vishrut.TaxiBooking.service;

import com.vishrut.TaxiBooking.model.ContactForm;
import com.vishrut.TaxiBooking.repository.ContactFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactFormService {

    private final ContactFormRepository contactFormRepository;

    public ContactForm addContactForm(ContactForm contactForm) {
        return contactFormRepository.save(contactForm);
    }
}
