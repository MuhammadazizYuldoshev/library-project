package uz.pdp.libraryproject.record;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.libraryproject.book.Book;
import uz.pdp.libraryproject.user.UserDao;
import uz.pdp.libraryproject.user.UserDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordController {

    private final RecordDao recordDao;
    private final UserDao userDao;

    @GetMapping
    public String viewRecords(Model model){
        List<RecordDto> allRecords = recordDao.getAllRecords();
        model.addAttribute("records",allRecords);
        return "view-record";
    }



    @GetMapping("/get-form")
    public String getForm(Model model){
        List<Book> books = recordDao.readBooks();
        List<UserDto> userDtoList = userDao.read();
        model.addAttribute("bookList",books);
        model.addAttribute("userDtoList",userDtoList);
        return "record-add-form";
    }



    @PostMapping
    public String create(RecordDto recordDto){
        recordDao.create(recordDto);
        return "redirect:/records";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        recordDao.delete(id);
        return "redirect:/records";
    }


    @GetMapping("/return/{id}")
    public String returned(@PathVariable("id") int id){
        recordDao.returned(id);
        return "redirect:/records";
    }

    @GetMapping("/not-return/{id}")
    public String notReturned(@PathVariable("id") int id){
        recordDao.notReturned(id);
        return "redirect:/records";
    }



    @GetMapping("/edit/{id}")
    public String getForm(@PathVariable(value = "id") Integer id, Model model){


            RecordDto recordDto = recordDao.readToEdit(id);
           for (Book book : recordDto.getBookList()) {
             System.out.println("book = " + book);
            }
            model.addAttribute("record",recordDto);
            List<Book> books = recordDao.readBooks();
            List<UserDto> userDtoList = userDao.read();
            model.addAttribute("bookList",books);
            model.addAttribute("userDtoList",userDtoList);
        return "update-record-form";
    }


    @PostMapping("/update")
    public String update(RecordDto recordDto){
        recordDao.update(recordDto);
        return "redirect:/records";
    }



}
