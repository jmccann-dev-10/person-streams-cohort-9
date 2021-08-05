package learn.streams;

import learn.streams.data.Repository;
import learn.streams.models.Person;
import learn.streams.models.StateProvince;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        List<Person> people = repository.getPeople();

//        for (Person person : people) {
//            System.out.println(person);
//        }

//        people.forEach(person -> System.out.println(person));
//        people.forEach(System.out::println);


//         * [ ] Filter
//         * Who has a last name that starts with the letter "a"?
        // get the stream...
//        Stream<Person> personStream = people.stream();
        // filter the stream...
//        personStream = personStream.filter(x -> x.getLastName().charAt(0) == 'A');
        // collect the results of the stream into a list...
//        List<Person> personList = personStream.collect(Collectors.toList());
        // print out the new collection
//        personList.forEach(System.out::println);
//        personStream = personStream.filter(x -> x.getLastName().charAt(0) == 'A');

//         * Who was born after the year 1990?
//        people.stream()
//                .filter(p -> p.getBirthDate().getYear() == 1990)
//                .forEach(System.out::println);

//         * Who has lived in the state of California?
//        StateProvince province = new StateProvince("California", "CA");
//        people.stream()
//                .filter(p -> p.getStatesProvinces().stream()
//                        .anyMatch(state -> state.getAbbreviation().equals("CA")))
//                .forEach(System.out::println);

//         * [ ] Sort
//         * Order by last name, then first name
//        people.stream()
//                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
//                .forEach(System.out::println);
//        people.stream()
//                .sorted(Comparator.comparing(Person::getFirstName))
//                .sorted(Comparator.comparing(Person::getLastName))
//                .forEach(System.out::println);

//         * Order by age
//        people.stream()
//                .sorted(Comparator.comparing(Person::getBirthDate))
//                .forEach(System.out::println);

//         * Order by the number of states that each person has lived in
        // stream
        // sorted based off of size
        // print
//        people.stream()
//                .sorted(Comparator.comparingInt(person -> person.getStatesProvinces().size()))
//                .forEach(System.out::println);

//         * [ ] Transform
//         * Create a list of full names
//        people.stream()
//                .map(person -> person.getLastName() + ", " + person.getFirstName())
//                .sorted(Comparator.comparing(name -> name))
//                .forEach(System.out::println);


//         * Create a list of the unique birth years
//        people.stream()
//                .map(person -> person.getBirthDate().getYear())
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

//         * Create a list of the unique states
//        people.stream()
//                .flatMap(person -> person.getStatesProvinces().stream())
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

//         * [ ] Aggregate
//         * How many people have lived in the state of New York?
        // stream
        // map (count)
//        List<StateProvince> provinceList =people.stream()
//                .flatMap(person -> person.getStatesProvinces().stream())
//                .filter(provence -> provence.getAbbreviation().equals("NY"))
//                .collect(Collectors.toList());
//        System.out.println(provinceList.size());

//         * How many people have lived in each state?
//        people.stream()
//                .flatMap(person -> person.getStatesProvinces().stream())
//                .collect(Collectors.groupingBy(StateProvince::getAbbreviation, Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


//         * What are the top 10 birth years?
        people.stream()
                .collect(Collectors.groupingBy(person -> person.getBirthDate().getYear(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.printf("Birth year: %d, with count of %d%n", entry.getKey(), entry.getValue()));

    }

}