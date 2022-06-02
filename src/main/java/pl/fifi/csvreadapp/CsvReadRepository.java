package pl.fifi.csvreadapp;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class CsvReadRepository {

    String filePathCSV = "src/cards.csv";
    CSVToPersonList csvToPersonList = new CSVToPersonList();
    ArrayList<Person>cardsList = csvToPersonList.parseCSVToObjectList(filePathCSV);

    public ArrayList<Person> getCardsList(){
        return cardsList;
    }

    public ArrayList<String>getCardsListByName(){
        ArrayList<String>listOfNames = new ArrayList<>();
        for (Person person:cardsList
        ) {
            listOfNames.add(person.getName());
            System.out.println(person.getId());
        }
        return listOfNames;
    }

    public ArrayList<String>getCardsListBySurname(){
        ArrayList<String>listOfSurnames = new ArrayList<>();
        for (Person person:cardsList
        ) {
            listOfSurnames.add(person.getSurname());
        }
        return listOfSurnames;
    }

    public ArrayList<Long>getCardsListByPhone(){
        ArrayList<Long>listOfPhoneNumbers = new ArrayList<>();
        for (Person person:cardsList
        ) {
            listOfPhoneNumbers.add(person.getPhone());
        }
        return listOfPhoneNumbers;
    }

    public Person getById(int id){
        Optional<Person> foundFirst = cardsList.stream().filter(person -> person.getId() == id).findFirst();
        return foundFirst.get();
    }

}

