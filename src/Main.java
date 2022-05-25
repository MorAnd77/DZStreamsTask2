import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

         for (Person c : persons) {
           System.out.println(c);
        }

        long adult = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних " + adult);

        List<String> conscript = persons.stream()
                .filter(person -> person.getAge() > 17)
                .filter(person -> person.getAge() < 28)
                .filter(person -> person.getSex() == Sex.MAN)
                .map(person -> person.getFamily().toString())
                .collect(Collectors.toList());
        System.out.println("Список призывников " + conscript);

        List<String> workable = persons.stream()
                .filter(person -> person.getAge() > 17)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() < 66 || person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() < 61 || person.getSex() == Sex.WOMAN)
                .map(person -> person.getFamily().toString())
                .sorted(Comparator.comparing(person -> person.toString()))
                .collect(Collectors.toList());
        System.out.println("Список работоспособных " + workable);





    }
}
