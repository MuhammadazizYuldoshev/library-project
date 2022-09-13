package uz.pdp.libraryproject.language;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageDao languageDao;

    @GetMapping()
    public String showLanguages(Model model){

        List<Language> allLanguages = languageDao.getAllLanguages();
        model.addAttribute("languageList",allLanguages);
        return "view-language-form";
    }

    @GetMapping("/add-language-form")
    public String addLanguageForm(){

        return "add-language-form";
    }

    @PostMapping
    public String saveLanguage(Language language){
        languageDao.saveLanguage(language);
        return "redirect:/language";
    }

    @GetMapping("/edit/{id}")
    public String updateLanguageForm(@PathVariable("id") int id,Model model){
        Language language = languageDao.getLanguage(id);
        model.addAttribute("language",language);
        return "update-language-form";
    }

    @PostMapping("/update-language")
    public String update(Language language){

        languageDao.updateLanguage(language);
        return "redirect:/language";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        languageDao.delete(id);
        return "redirect:/language";
    }


}
