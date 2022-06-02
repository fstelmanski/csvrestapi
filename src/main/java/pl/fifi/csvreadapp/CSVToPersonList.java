package pl.fifi.csvreadapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CSVToPersonList {
    static ArrayList<Person> cardsList;
    public ArrayList<Person> parseCSVToObjectList(String filePath){
        BufferedReader reader = null;
        String line = "";
        cardsList = new ArrayList<Person>();


        try{
            reader = new BufferedReader(new FileReader(filePath));
            String columns = reader.readLine();
            int id = 0;

            String[]splitColumns = columns.split(",");
            String nameColumn = splitColumns[0];
            String surnameColumn = splitColumns[1];
            String phoneColumn = splitColumns[2];
            while((line = reader.readLine()) != null){
                int temporarySize = cardsList.size();
                String[]lineSplit = line.split(",",3);
                if(Objects.equals(lineSplit[0], "")){
                    throw new NullPointerException("Found NULL value in " + nameColumn + " column " + ++temporarySize + " row! Fix this!");
                }
                String name = lineSplit[0];
                if(Objects.equals(lineSplit[1], "")){
                    throw new NullPointerException("Found NULL value in " + surnameColumn + " column " + ++temporarySize  + " row! Fix this!");
                }
                String surname = lineSplit[1];
                if(Objects.equals(lineSplit[2], "")){
                    throw new NullPointerException("Found NULL value in " + phoneColumn + " column " + ++temporarySize  + " row! Fix this!");
                }
                long phone = Long.parseLong(lineSplit[2]);
                addPerson(++id,name,surname,phone);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                assert reader != null;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return cardsList;

    }

    public void addPerson(int id,String name, String surname, Long phone) {
        Person person = new Person(id, name, surname, phone);
        validatePerson(person);
        checkIfPersonExist(person);
        cardsList.add(person);
    }
    public ArrayList<Person>getAllPeople() {
        return cardsList;
    }
    private void validatePerson(Person person) {
        person.validateName();
        person.validateSurname();
        person.validatePhoneNumber();
    }
    private void checkIfPersonExist(Person person) {
        if (cardsList.contains(person))
            throw new RuntimeException("Person Already Exists");
    }
}
