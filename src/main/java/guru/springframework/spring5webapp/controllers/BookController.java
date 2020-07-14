package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Spring MVC Controller
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    // Populate Spring Model with "books" from bookRepository
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        // The return is the View Name
        return "books/list";
    }
}
