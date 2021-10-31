package is.hi.hbv501g2021supportsession.Services.Implementation;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Book;
import is.hi.hbv501g2021supportsession.Persistence.Repositories.BookRepository;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private BookRepository bookRepository;

    @Autowired
    public UserServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Todo: substitute bookRepository for userRepository when it is ready
    @Override
    public Book saveUser(Book user) {
        return bookRepository.save(user);
    }

    @Override
    public void deleteUser(Book user) {
        bookRepository.delete(user);
    }

    @Override
    public List<Book> findUserByName(String name) {
        return bookRepository.findByTitle(name);
    } // Todo: substitute with findByName when it exists

    @Override
    public Book loginUser(Book user) {
        return bookRepository.save(user);
    } // substitute save with login

    @Override
    public Book logoutUser(Book user) {
        return bookRepository.save(user);
    } // substitute save with logout

}
