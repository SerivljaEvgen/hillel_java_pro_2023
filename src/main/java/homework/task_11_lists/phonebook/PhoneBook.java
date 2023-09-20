package homework.task_11_lists.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private final List<Entries> entriesList = new ArrayList<>();

    //1
    public void add(String name, List<String> number) {
        entriesList.add(new Entries(name, number));
    }

    //2
    public Entries find(String name) {
        for (Entries entry : entriesList) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    //3
    public List<Entries> findAll(String name) {
        List<Entries> foundEntries = new ArrayList<>();
        for (Entries entry : entriesList) {
            if (entry.getName().equals(name)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries.isEmpty() ? null : foundEntries;
    }


    public static void main(String[] args) {

        String name1 = "Bob";
        List<String> number1 = new ArrayList<>();
        number1.add("+380937252329");
        number1.add("+380987245598");

        String name2 = "John";
        List<String> number2 = new ArrayList<>();
        number2.add("+380502356987");
        number2.add("+380978563321");

        String name3 = "Bob";
        List<String> number3 = new ArrayList<>();
        number3.add("911");


        //add
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        phoneBook.add(name3, number3);

        for (Entries entry : phoneBook.entriesList) {
            System.out.println("name: " + entry.getName());
            System.out.println("numbers: " + entry.getPhoneNumber());
        }

        //Find first
        System.out.println("\nFind a first entry by name \"Bob\"");
        Entries foundEntry = phoneBook.find("Bob");
        System.out.println(foundEntry);

        //Find all
        System.out.println("\nFind all entries by name \"Bob\"");
        List<Entries> foundEntries = phoneBook.findAll("Bob");
        System.out.println(foundEntries);
    }
}
