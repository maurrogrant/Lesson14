import org.example.Person;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleHamcrestTest {

    @Test
    @DisplayName("List with Hamcrest")
    public void testListWithHamcrest() {
        List<String> fruits = Arrays.asList("яблоко", "банан", "вишня");

        assertThat(fruits, Matchers.hasSize(3));
        assertThat(fruits, Matchers.contains("яблоко", "банан", "вишня"));
        assertThat(fruits, Matchers.hasItem("банан"));
    }

    @Test
    @DisplayName("Set with Hamcrest")
    public void testSetWithHamcrest() {
        Set<String> colors = new HashSet<>(Arrays.asList("красный", "зеленый", "синий"));

        assertThat(colors, Matchers.hasSize(3));
        assertThat(colors, Matchers.hasItems("красный", "синий"));
    }

    @Test
    @DisplayName("Map with Hamcrest")
    public void testMapWithHamcrest() {
        Map<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("яблоко", 50);
        fruitPrices.put("банан", 30);
        fruitPrices.put("вишня", 100);

        assertThat(fruitPrices, Matchers.hasEntry("яблоко", 50));
        assertThat(fruitPrices, Matchers.hasKey("банан"));
        assertThat(fruitPrices, Matchers.hasValue(100));
        assertThat(fruitPrices, Matchers.aMapWithSize(3));
    }


    @Test
    @DisplayName("String with Hamcrest")
    public void testStringWithHamcrest() {
        String text = "Привет, мир!";

        assertThat(text, Matchers.startsWith("Привет"));
        assertThat(text, Matchers.endsWith("мир!"));
        assertThat(text, Matchers.containsString("мир"));
    }

    @Test
    @DisplayName("Object with Hamcrest")
    public void testObjectWithHamcrest() {
        Person person = new Person("Иван", 25);

        assertThat(person.name(), Matchers.equalTo("Иван"));
        assertThat(person.age(), Matchers.greaterThan(20));
    }
}
