import org.example.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleAssertJTest {
    @Test
    @DisplayName("List with AssertJ")
    public void testListWithAssertJ() {
        List<String> fruits = Arrays.asList("яблоко", "банан", "вишня");

        assertThat(fruits).hasSize(3)
                .containsExactly("яблоко", "банан", "вишня")
                .contains("банан");
    }


    @Test
    @DisplayName("Set with AssertJ")
    public void testSetWithAssertJ() {
        Set<String> colors = new HashSet<>(Arrays.asList("красный", "зеленый", "синий"));

        assertThat(colors).hasSize(3)
                .contains("красный", "синий")
                .doesNotContain("желтый");
    }

    @Test
    @DisplayName("Map with AssertJ")
    public void testMapWithAssertJ() {
        Map<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("яблоко", 50);
        fruitPrices.put("банан", 30);
        fruitPrices.put("вишня", 100);

        assertThat(fruitPrices).hasSize(3)
                .containsEntry("яблоко", 50)
                .containsKey("банан")
                .containsValue(100)
                .doesNotContainKey("дыня");
    }

    @Test
    @DisplayName("String with AssertJ")
    public void testStringWithAssertJ() {
        String text = "Привет, мир!";

        assertThat(text).startsWith("Привет")
                .endsWith("мир!")
                .contains("мир")
                .hasSize(12);
    }

    @Test
    @DisplayName("Object with AssertJ")
    public void testObjectWithAssertJ() {
        Person person = new Person("Иван", 25);

        assertThat(person.name()).isEqualTo("Иван");
        assertThat(person.age()).isGreaterThan(20);
    }

    @Test
    @DisplayName("Collection filtering with AssertJ")
    public void testCollectionFilteringWithAssertJ() {
        List<Person> people = Arrays.asList(
                new Person("Иван", 25),
                new Person("Мария", 30),
                new Person("Петр", 20)
        );

        assertThat(people).filteredOn(person -> person.age() > 20)
                .hasSize(2)
                .extracting(Person::name)
                .containsExactly("Иван", "Мария");
    }
}
