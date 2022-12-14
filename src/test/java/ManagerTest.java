import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ManagerTest {

    @Test
    public void testAddIdBook() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга2", 50, "Автор2");
        Book book3 = new Book(3, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тест на метод поиска, если находится несколько товаров
    public void testSearchByFewBooks() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга1", 50, "Автор1");
        Book book3 = new Book(3, "Книга2", 10, "Автор3");
        Book book4 = new Book(4, "Книга3", 10, "Автор3");
        Book book5 = new Book(5, "Книга5", 10, "Автор3");
        Book book6 = new Book(6, "Книга3", 10, "Автор3");
        Book book7 = new Book(7, "Книга1", 10, "Автор3");
        Book book8 = new Book(8, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        Product[] expected = {book1, book2, book7};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тест на метод поиска, если находится ровно один товар
    public void testSearchByOneBook() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга1", 50, "Автор1");
        Book book3 = new Book(3, "Книга2", 10, "Автор3");
        Book book4 = new Book(4, "Книга3", 10, "Автор3");
        Book book5 = new Book(5, "Книга5", 10, "Автор3");
        Book book6 = new Book(6, "Книга3", 10, "Автор3");
        Book book7 = new Book(7, "Книга1", 10, "Автор3");
        Book book8 = new Book(8, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        Product[] expected = {book5};
        Product[] actual = manager.searchBy("Книга5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тест на метод поиска, если находится 0 товаров, т.е. ни один товар не подходит
    public void testSearchByNoNameBook() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга1", 50, "Автор1");
        Book book3 = new Book(3, "Книга2", 10, "Автор3");
        Book book4 = new Book(4, "Книга3", 10, "Автор3");
        Book book5 = new Book(5, "Книга5", 10, "Автор3");
        Book book6 = new Book(6, "Книга3", 10, "Автор3");
        Book book7 = new Book(7, "Книга1", 10, "Автор3");
        Book book8 = new Book(8, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
        manager.add(book8);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга8");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddIdSmartphone() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "Смартфон1", 100, "Производитель1");
        Smartphone smartphone2 = new Smartphone(1, "Смартфон2", 50, "Производитель2");
        Smartphone smartphone3 = new Smartphone(1, "Смартфон3", 10, "Производитель1");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
