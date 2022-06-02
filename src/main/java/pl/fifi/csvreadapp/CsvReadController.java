package pl.fifi.csvreadapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@RestController
@RequestMapping("/api")
public class CsvReadController {

    @Autowired
    CsvReadRepository csvReadRepository;

    @GetMapping("/cards")
    public ArrayList<Person>getCardsList(){
        return csvReadRepository.getCardsList();
    }
    @GetMapping("/cards/name")
    public ArrayList<String>getCardsListByName(){
        return csvReadRepository.getCardsListByName();
    }
    @GetMapping("/cards/surname")
    public ArrayList<String>getCardsListBySurname(){
        return csvReadRepository.getCardsListBySurname();
    }
    @GetMapping("/cards/phone")
    public ArrayList<Long>getCardsListByPhone(){
        return  csvReadRepository.getCardsListByPhone();
    }
    @GetMapping("/cards/{id}")
    public Person getById(@PathVariable ("id") int id){
        return csvReadRepository.getById(id);
    }

}
