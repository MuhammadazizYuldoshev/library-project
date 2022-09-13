package uz.pdp.libraryproject.book;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.libraryproject.author.AuthorDao;
import uz.pdp.libraryproject.category.CategoryDao;
import uz.pdp.libraryproject.language.LanguageDao;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    // FIELD INJECTION
    // SETTER INJECTION
    // CONSTRUCTOR INJECTION


    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final LanguageDao languageDao;


    //    @GetMapping
//    public String getAllBooks(HttpServletRequest request, HttpServletResponse response) {
//        List<BookDto> allBooksFromDb = bookDao.getAllBooksFromDb();
//        request.setAttribute("kitoblar", allBooksFromDb);
//
//        return "view-books";
//    }


    @GetMapping
    public String getAllBooks(Model model) {
        List<BookDto> allBooksFromDb = bookDao.getAllBooksFromDb();
        model.addAttribute("books", allBooksFromDb);
        return "view-books";
    }

    @GetMapping("/get-form")
    public String getForm(Model model) {

        model.addAttribute("authorList", authorDao.getAllAuthorsForSelect());
        model.addAttribute("languageList", languageDao.getAllLanguagesForSelect());
        model.addAttribute("categoryList", categoryDao.getAllCategoriesForSelect());
        // TODO: 08/09/22 categoryni ham tepadagi authorList ga o'xshab berib yuboring, iltimos....
        return "add-book-form";
    }



    @PostMapping
    public String saveBook(BookDto BookDto) {
        bookDao.addBook(BookDto);
        System.out.println(BookDto);
        return "redirect:/books";

    }

    @GetMapping("{id}")
    public String bookByIdForm(@PathVariable() int id,Model model){
        Book book = bookDao.getBook(id);
        model.addAttribute("book",book);
        return "book-description";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        bookDao.delete(id);
        return "redirect:/books";
    }


    @GetMapping("/edit/{id}")
    public String bookById(@PathVariable int id,Model model){
        BookDto bookById = bookDao.getBookById(id);
        model.addAttribute("book",bookById);
        model.addAttribute("authorList", authorDao.getAllAuthorsForSelect());
        model.addAttribute("languageList", languageDao.getAllLanguagesForSelect());
        model.addAttribute("categoryList", categoryDao.getAllCategoriesForSelect());
        return "update-book-form";
    }

    @PostMapping("/update-book")
    public String update(BookDto bookDto){
        bookDao.update(bookDto);
        return "redirect:/books";
    }


}
