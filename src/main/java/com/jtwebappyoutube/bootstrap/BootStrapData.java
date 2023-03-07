package com.jtwebappyoutube.bootstrap;

import com.jtwebappyoutube.domain.Author;
import com.jtwebappyoutube.domain.Book;
import com.jtwebappyoutube.domain.Publisher;
import com.jtwebappyoutube.repositories.AuthorRepository;
import com.jtwebappyoutube.repositories.BookRepository;
import com.jtwebappyoutube.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // 2 publsiherow
        Publisher arnold = new Publisher("Arnold Boczek", "Cwiartki 3/4");
        Publisher marian = new Publisher("Marian Paxdzioch", "Cwiartki 3/4");

        // tworzymy autora i ksiazke
        Author piotrHic = new Author("Piotr Hic");
        Book pamietnik = new Book("Pamietnik", "123456789");

        // dodajemy do setow ich odpowiednio
        piotrHic.getBooks().add(pamietnik);
        pamietnik.getAuthors().add(piotrHic);

        // dodajemy publisherom ksiazki
        arnold.getBooks().add(pamietnik);

        // dodajemy do repo
        authorRepository.save(piotrHic);
        bookRepository.save(pamietnik);
        publisherRepository.save(arnold);

        // tworzymy autora i ksiazke
        Author margaritaKulibova = new Author("Margarita Kulibova");
        Book ksiazkaKucharska = new Book("Ksiazka Kucharska", "123456788");

        // dodajemy publisherom ksiazki
        marian.getBooks().add(ksiazkaKucharska);

        // dodajemy do setow ich odpowiednio
        margaritaKulibova.getBooks().add(ksiazkaKucharska);
        ksiazkaKucharska.getAuthors().add(margaritaKulibova);

        System.out.println("Run in Bootstrap!\n");


        System.out.println("Count of publishers in repo = " + publisherRepository.count());
        System.out.println("Count of books in repo = " + bookRepository.count());
        System.out.println("Count of authors in repo = " + authorRepository.count() + "\n");

        // dodajemy do repo
        authorRepository.save(margaritaKulibova);
        bookRepository.save(ksiazkaKucharska);
        publisherRepository.save(marian);

        System.out.println("Count of publishers in repo = " + publisherRepository.count());
        System.out.println("Count of books in repo = " + bookRepository.count());
        System.out.println("Count of the books for the publisher : " + arnold.getName() + " is: " + arnold.getBooks().size());
        System.out.println("Count of authors in repo = " + authorRepository.count() + "\n");

    }
}
