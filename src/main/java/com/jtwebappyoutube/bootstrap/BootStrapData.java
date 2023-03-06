package com.jtwebappyoutube.bootstrap;

import com.jtwebappyoutube.domain.Author;
import com.jtwebappyoutube.domain.Book;
import com.jtwebappyoutube.repositories.AuthorRepository;
import com.jtwebappyoutube.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // tworzymy autora i ksiazke
        Author piotrHic = new Author("Piotr Hic");
        Book pamietnik = new Book("Pamietnik", "123456789");

        // dodajemy do setow ich odpowiednio
        piotrHic.getBooks().add(pamietnik);
        pamietnik.getAuthors().add(piotrHic);

        // dodajemy do repo
        authorRepository.save(piotrHic);
        bookRepository.save(pamietnik);

        // tworzymy autora i ksiazke
        Author margaritaKulibova = new Author("Margarita Kulibova");
        Book ksiazkaKucharska = new Book("Ksiazka Kucharska", "123456788");

        // dodajemy do setow ich odpowiednio
        margaritaKulibova.getBooks().add(ksiazkaKucharska);
        ksiazkaKucharska.getAuthors().add(margaritaKulibova);

        System.out.println("Run in Bootstrap!\n");

        System.out.println("Count of books in repo = " + bookRepository.count());
        System.out.println("Count of authors in repo = " + authorRepository.count() + "\n");

        // dodajemy do repo
        authorRepository.save(margaritaKulibova);
        bookRepository.save(ksiazkaKucharska);

        System.out.println("Count of books in repo = " + bookRepository.count());
        System.out.println("Count of authors in repo = " + authorRepository.count() + "\n");

    }
}
