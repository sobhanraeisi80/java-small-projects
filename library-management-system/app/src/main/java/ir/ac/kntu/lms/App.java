package ir.ac.kntu.lms;

import ir.ac.kntu.lms.items.Book;
import ir.ac.kntu.lms.items.DigitalBook;
import ir.ac.kntu.lms.items.Format;
import ir.ac.kntu.lms.items.Item;
import ir.ac.kntu.lms.items.Magazine;
import ir.ac.kntu.lms.items.publishType;
import ir.ac.kntu.lms.roles.Guest;
import ir.ac.kntu.lms.roles.Student;

public class App {
    
    public static void main(String[] args) {
        Student s = new Student("Ali", "Jamali", "09927824150", "sobhanraeisi@kntu.ac.ir", "SobhanR1234#");
        Guest g = new Guest("Sobhan", "Raeisi", "09998", "sobhan@11", "12345");
        Item [] arr = new Item [3];
        arr [0] = new Book("A", "B", "D", "C", 2020, 2000);
        arr [1] = new Magazine("AA", "DD", "CC", 3030, publishType.QUARTERLY);
        arr [2] = new DigitalBook("po", null, 1890, Format.EPUB, 3.9, "https://hi", 90);
        arr [0].setInventory(9);
        for (Item arr1 : arr) {
            System.out.println(arr1);
            System.out.println();
        }
        
    }
}

