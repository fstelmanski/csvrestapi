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
        Assertions.assertTrue(list.size()>6);
    }

    @Test
    public void shouldNotGetAllCards(){
        ArrayList<Person> list = readRepository.getCardsList();
        Assertions.assertFalse(list.size()>7);
    }
    @Test
    public void shouldNotGetAllCardsBecauseThereIsNoAtAll(){
        ArrayList<Person> list = readRepository.getCardsList();
        Assertions.assertNotEquals(0,list);
    }


    @Test
    public void shouldGetNamesEvenIfItIsOne(){
        ArrayList<String>list = readRepository.getNamesFromCardList();
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    public void shouldGetNames(){
        ArrayList<String> list = readRepository.getNamesFromCardList();
        Assertions.assertTrue(list.size()>6);
    }

    @Test
    public void shouldNotGetNamesBecauseThereIsMoreThanExist(){
        ArrayList<String> list = readRepository.getNamesFromCardList();
        Assertions.assertFalse(list.size()>7);
    }
    @Test
    public void shouldNotGetNamesBecauseThereIsNotAny(){
        ArrayList<String> list = readRepository.getNamesFromCardList();
        Assertions.assertNotEquals(0,list);
    }

    @Test
    public void shouldGetSurnamesEvenIfItIsOne(){
        ArrayList<String>list = readRepository.getSurnamesFromCardList();
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    public void shouldGetSurnames(){
        ArrayList<String> list = readRepository.getSurnamesFromCardList();
        Assertions.assertTrue(list.size()>6);
    }

    @Test
    public void shouldNotGetSurnamesBecauseThereIsMoreThanExist(){
        ArrayList<String> list = readRepository.getSurnamesFromCardList();
        Assertions.assertFalse(list.size()>7);
    }
    @Test
    public void shouldNotGetSurnamesBecauseThereIsNotAny(){
        ArrayList<String> list = readRepository.getSurnamesFromCardList();
        Assertions.assertNotEquals(0,list);
    }

    @Test
    public void shouldGetPhoneNumbersEvenIfItIsOne(){
        ArrayList<Long>list = readRepository.getPhoneNumbersFromCardList();
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    public void shouldGetAllPhoneNumbers(){
        ArrayList<Long> list = readRepository.getPhoneNumbersFromCardList();
        Assertions.assertTrue(list.size()>6);
    }

    @Test
    public void shouldNotGetAllPhoneNumbersBecauseThereIsMoreThanExist(){
        ArrayList<Long> list = readRepository.getPhoneNumbersFromCardList();
        Assertions.assertFalse(list.size()>7);
    }
    @Test
    public void shouldNotGetPhoneNumbersBecauseThereIsNotAny(){
        ArrayList<Long> list = readRepository.getPhoneNumbersFromCardList();
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

    @Test
    public void shouldGetCardsByNameIfThereIsMoreThanOne(){
        ArrayList<Person>list = readRepository.getCardsHavingName("Lonnie");
        Assertions.assertEquals(2,list.size());
    }
    @Test
    public void shouldGetCardsByNameIfThereIsOnlyOne(){
        ArrayList<Person>list = readRepository.getCardsHavingName("Filip");
        Assertions.assertEquals(1,list.size());
    }
    @Test
    public void shouldNotGetCardsByName(){
        ArrayList<Person>list = readRepository.getCardsHavingName("Filipp");
        Assertions.assertNotEquals(1,list.size());
    }
    @Test
    public void shouldNotGetCardsByNameFullList(){
        ArrayList<Person>list = readRepository.getCardsHavingName("Lonnie");
        Assertions.assertNotEquals(1,list.size());
    }


    @Test
    public void shouldGetCardsBySurnameIfThereIsMoreThanOne(){
        ArrayList<Person>list = readRepository.getCardsHavingSurname("James");
        Assertions.assertEquals(2,list.size());
    }
    @Test
    public void shouldGetCardsBySurnameIfThereIsOnlyOne(){
        ArrayList<Person>list = readRepository.getCardsHavingSurname("Stelmański");
        Assertions.assertEquals(1,list.size());
    }
    @Test
    public void shouldNotGetCardsBySurname(){
        ArrayList<Person>list = readRepository.getCardsHavingSurname("Jamess");
        Assertions.assertNotEquals(1,list.size());
    }
    @Test
    public void shouldNotGetCardsBySurnameFullList(){
        ArrayList<Person>list = readRepository.getCardsHavingSurname("James");
        Assertions.assertNotEquals(1,list.size());
    }

    @Test
    public void shouldGetCardByPhone(){
        Person p = readRepository.getCardHavingPhoneNumber(48667058713L);
        Assertions.assertEquals(48667058713L,p.getPhone());
    }
    @Test
    public void shouldNotGetCardByPhone(){
        Person p = readRepository.getCardHavingPhoneNumber(48667058713L);
        Assertions.assertNotEquals(48667059713L,p.getPhone());
    }

}
