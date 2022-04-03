package com.example.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    ReadingListRepository repository;

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBook(@PathVariable String reader, Model model) {
        List<Book> readingList = repository.findByReader(reader);
        if(readingList != null) {
            model.addAttribute("books",readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable String reader, Book book) {
        book.setReader(reader);
        repository.save(book);
        return "redirect:/{reader}";
    }
}
