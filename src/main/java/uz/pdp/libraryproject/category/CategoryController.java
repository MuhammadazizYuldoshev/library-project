package uz.pdp.libraryproject.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDao categoryDao;

    @GetMapping
    public String showCategory(Model model){
        List<Category> allCategories = categoryDao.getAllCategories();
        model.addAttribute("categoryList",allCategories);
        return "view-category-form";

    }


    @GetMapping("/add-category-form")
    public String addAuthorForm(){

        return "add-category-form";
    }



    @PostMapping
    public String saveCategory(Category category){
        System.out.println(category);
        categoryDao.saveCategory(category);


        return "redirect:/category";

    }

    @GetMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") int id,Model model){
        Category category = categoryDao.getCategory(id);
        model.addAttribute("category",category);
        return "update-category-form";

    }

    @PostMapping("/update-category")
    public String update(Category category){
        categoryDao.updateCategory(category);
        return "redirect:/category";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        categoryDao.delete(id);
        return "redirect:/category";

    }

    @GetMapping("{id}")
    public String categoryDescription(@PathVariable int id,Model model){
        Category category = categoryDao.getCategory(id);
        model.addAttribute("category",category);
        return "category-description";

    }



}
