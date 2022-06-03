package pl.fifi.csvreadapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class CsvReadRepositoryTest {

    @Autowired
    CsvReadRepository readRepository;

    @Test
    public void shouldGetAllCardsEvenIfItIsOne(){
        ArrayList<Person> list = readRepository.getCardsList();
        Assertions.assertTrue(list.size()>0);
    }

    @Test
    public void shouldGetAllCards(){
        ArrayList<Person> list = readRepository.getCardsList();
        Assertions.assertTrue(list.size()>4);
    }

    @Test
    public void shouldNotGetAllCards(){
        ArrayList<Person> list = readRepository.getCardsList();
        Assertions.assertFalse(list.size()>5);
    }
    @Test
    public void shouldNotGetAllCardsBecauseThereIsNoAtAll(){
        ArrayList<Person> list = readRepository.getCardsList();
        Assertions.assertNotEquals(0,list);
    }


    @Test
    public void shouldGetCardsByNameEvenIfItIsOne(){
        ArrayList<String>list = readRepository.getCardsListByName();
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    public void shouldGetAllCardsByName(){
        ArrayList<String> list = readRepository.getCardsListByName();
        Assertions.assertTrue(list.size()>4);
    }

    @Test
    public void shouldNotGetAllCardsByName(){
        ArrayList<String> list = readRepository.getCardsListByName();
        Assertions.assertFalse(list.size()>5);
    }
    @Test
    public void shouldNotGetAllCardsByNameBecauseThereIsNoAtAll(){
        ArrayList<String> list = readRepository.getCardsListByName();
        Assertions.assertNotEquals(0,list);
    }

    @Test
    public void shouldGetCardsBySurnameEvenIfItIsOne(){
        ArrayList<String>list = readRepository.getCardsListBySurname();
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    public void shouldGetAllCardsBySurname(){
        ArrayList<String> list = readRepository.getCardsListBySurname();
        Assertions.assertTrue(list.size()>4);
    }

    @Test
    public void shouldNotGetAllCardsBySurname(){
        ArrayList<String> list = readRepository.getCardsListBySurname();
        Assertions.assertFalse(list.size()>5);
    }
    @Test
    public void shouldNotGetAllCardsBySurnameBecauseThereIsNoAtAll(){
        ArrayList<String> list = readRepository.getCardsListBySurname();
        Assertions.assertNotEquals(0,list);
    }

    @Test
    public void shouldGetCardsByPhoneEvenIfItIsOne(){
        ArrayList<Long>list = readRepository.getCardsListByPhone();
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    public void shouldGetAllCardsByPhone(){
        ArrayList<Long> list = readRepository.getCardsListByPhone();
        Assertions.assertTrue(list.size()>4);
    }

    @Test
    public void shouldNotGetAllCardsByPhone(){
        ArrayList<Long> list = readRepository.getCardsListByPhone();
        Assertions.assertFalse(list.size()>5);
    }
    @Test
    public void shouldNotGetAllCardsByPhoneBecauseThereIsNoAtAll(){
        ArrayList<Long> list = readRepository.getCardsListByPhone();
        Assertions.assertNotEquals(0,list);
    }

    @Test
    public void shouldGetCardById(){
        Person p = readRepository.getById(2);
        Assertions.assertEquals("Gordon",p.getName());
    }
    @Test
    public void shouldNotGetCardById(){
        Person p = readRepository.getById(3);
        Assertions.assertNotEquals("Gordon",p.getName());
    }
}
