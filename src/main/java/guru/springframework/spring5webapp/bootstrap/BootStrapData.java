package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher("Longman", "New York Street");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        System.out.println("Number of Publishers " + publisherRepository.count() );

        Author rod = new Author("Rod", "johnson");
        Book noJEB = new Book("J2EE Development without EJB", "3243254325");
        rod.getBooks().add(noJEB);
        noJEB.getAuthors().add(rod);
        publisher.getBooks().add(noJEB);
        noJEB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noJEB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books " + bookRepository.count() );
        System.out.println("Number of Publishers " + publisherRepository.count() );

    }
}
