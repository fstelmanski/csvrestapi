package pl.fifi.csvreadapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
    public ArrayList<String>getNamesFromCardsList(){
        return csvReadRepository.getNamesFromCardList();
    }
    @GetMapping("/cards/surname")
    public ArrayList<String>getSurnamesFromCardList(){
        return csvReadRepository.getSurnamesFromCardList();
    }
    @GetMapping("/cards/phone")
    public ArrayList<Long>getPhoneNumbersFromCardList(){
        return  csvReadRepository.getPhoneNumbersFromCardList();
    }
    @GetMapping("/cards/{id}")
    public Person getById(@PathVariable ("id") int id){
        return csvReadRepository.getById(id);
    }

    @GetMapping("/cards/name/{name}")
    public ArrayList<Person> getCardsByName(@PathVariable ("name")String name){
        return csvReadRepository.getCardsHavingName(name);
    }
    @GetMapping("/cards/surname/{surname}")
    public ArrayList<Person> getCardsBySurname(@PathVariable ("surname")String surname){
        return csvReadRepository.getCardsHavingSurname(surname);
    }
    @GetMapping("/cards/phone/{phone}")
    public Person getCardsHavingPhoneNumber(@PathVariable ("phone")Long phone){
        return csvReadRepository.getCardHavingPhoneNumber(phone);
    }

}
