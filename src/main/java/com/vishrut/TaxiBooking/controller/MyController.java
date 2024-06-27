package com.vishrut.TaxiBooking.controller;

import com.vishrut.TaxiBooking.model.BookingForm;
import com.vishrut.TaxiBooking.model.ContactForm;
import com.vishrut.TaxiBooking.service.BookingFormService;
import com.vishrut.TaxiBooking.service.ContactFormService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MyController {

    private final ContactFormService contactFormService;
    private final BookingFormService bookingFormService;

    //API to show Home Page
    @GetMapping(path = {"/","home","welcome","index"})
    public String welcomeView(HttpServletRequest httpServletRequest, Model model){
        String requestURI = httpServletRequest.getRequestURI();
        model.addAttribute("mycurrentPage",requestURI);
        model.addAttribute("bookingForm",new BookingForm());
        return "index";
    }

    //API to show About Page it will call about.html file
    @GetMapping("about")
    public String aboutView(HttpServletRequest httpServletRequest, Model model){
        String requestURI = httpServletRequest.getRequestURI();
        model.addAttribute("mycurrentPage",requestURI);
        return "about";
    }

    //API to show Cars Page
    @GetMapping("cars")
    public String carsView(HttpServletRequest httpServletRequest, Model model){
        String requestURI = httpServletRequest.getRequestURI();
        model.addAttribute("mycurrentPage",requestURI);
        return "cars";
    }

    //API to show Service Page
    @GetMapping("services")
    public String ServicesView(HttpServletRequest httpServletRequest, Model model){
        String requestURI = httpServletRequest.getRequestURI();
        model.addAttribute("mycurrentPage",requestURI);
        return "services";
    }

    //API to show Contacts Page
    @GetMapping("contacts")
    public String contactsView(HttpServletRequest httpServletRequest, Model model){
        String requestURI = httpServletRequest.getRequestURI();
        model.addAttribute("mycurrentPage",requestURI);
        model.addAttribute("contactForm",new ContactForm());//passing object when we run contacts.html we fill data
        return "contacts";
    }

    //API for contact form
    @PostMapping("contactform")
    public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m,
                              RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            //printing error to view on html
            m.addAttribute("bindingResult",bindingResult);
            return "contacts";//retur to contacts.html to show message error
        }
        ContactForm savedContact = contactFormService.addContactForm(contactForm);
        if(savedContact!=null){
            redirectAttributes.addFlashAttribute("message","Message Sent successfully!");
        }else{
            redirectAttributes.addFlashAttribute("message","Something went wrong");
        }
        return "redirect:/contacts";//if there is no error we don't want to resubmit the form again
    }
    //BindingResult store the validating results form model class

    //API for Booking
    @PostMapping("bookingform")
    public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm, BindingResult bindingResult, Model m,
                              RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            //printing error to view on html
            m.addAttribute("bindingResult",bindingResult);
            return "index";
        } else if (bookingForm.getAdult()+bookingForm.getChildren()>4) {
            m.addAttribute("message","Total number of Adult and Children cannot exceed 4");
            return "index";
        }
        BookingForm savedBooking = bookingFormService.addBooking(bookingForm);
        if(savedBooking!=null){
            redirectAttributes.addFlashAttribute("message","Booking Done successfully!");
        }else{
            redirectAttributes.addFlashAttribute("message","Booking not done!");
        }
        return "redirect:/index";
    }

}
