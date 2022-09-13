package uz.pdp.libraryproject.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorDao authorDao;


    @GetMapping
    public String showAuthors(Model model){

        List<Author> allAuthors = authorDao.getAllAuthors();
        model.addAttribute("authors",allAuthors);
        return "view-authors-form";

    }

    @GetMapping("edit/{id}")
    public String updateAuthors(@PathVariable("id") int id,Model model){

        Author author = authorDao.getAuthor(id);
        model.addAttribute("author",author);
        return "update-authors-form";

    }


    @RequestMapping(value = "/update-author",method = RequestMethod.POST)
    public String update(Author author){
        authorDao.updateAuthor(author);
        return "redirect:/author";

    }




    @GetMapping("/add-author-form")
    public String addAuthorForm(){

        return "add-author-form";
    }

    @PostMapping
    public String saveAuthor(Author author){
        System.out.println(author);
        authorDao.saveAuthor(author);


        return "redirect:/author";

    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") int id){
        authorDao.delete(id);
        return "redirect:/author";
    }

    @GetMapping("/biography/{id}")
    public String getBiographyById(@PathVariable Integer id, Model model) {

        Author biographyById = authorDao.getAuthor(id);
        model.addAttribute("author", biographyById);

        return "author-biography";

    }


}
