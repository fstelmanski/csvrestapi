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

    public ArrayList<String>getNamesFromCardList(){
        ArrayList<String>listOfNames = new ArrayList<>();
        for (Person person:cardsList
        ) {
            listOfNames.add(person.getName());
        }
        return listOfNames;
    }

    public ArrayList<String>getSurnamesFromCardList(){
        ArrayList<String>listOfSurnames = new ArrayList<>();
        for (Person person:cardsList
        ) {
            listOfSurnames.add(person.getSurname());
        }
        return listOfSurnames;
    }

    public ArrayList<Long>getPhoneNumbersFromCardList(){
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
    public ArrayList<Person>getCardsHavingName(String name){
        ArrayList<Person>listOfPersonByNames = new ArrayList<>();
        for (Person person:cardsList
        ) {
            if(person.getName().equals(name)) {
                listOfPersonByNames.add(person);
            }
        }
        return listOfPersonByNames;
    }
    public ArrayList<Person>getCardsHavingSurname(String surname){
        ArrayList<Person>listOfPersonBySurnames = new ArrayList<>();
        for (Person person:cardsList
        ) {
            if(person.getSurname().equals(surname)) {
                listOfPersonBySurnames.add(person);
            }
        }
        return listOfPersonBySurnames;
    }
    public Person getCardHavingPhoneNumber(Long phone){
        Optional<Person> foundFirst = cardsList.stream().filter(person -> person.getPhone() == phone).findFirst();
        return foundFirst.get();
    }


}

