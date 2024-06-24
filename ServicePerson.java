import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServicePerson {
    private List<Person> persons;
    private PersonBuild personBuild;

    public ServicePerson() {
        persons = new ArrayList<>();
        personBuild = new PersonBuild();
    }

    public void addPerson(String name, int age, double salary, Department department) {
        Person person = personBuild.personBuild(name, age, salary, department);
        persons.add(person);
    }

    /**
     * Найти самого молодого сотрудника
     */
    public Optional<Person> findMostYoungestPerson() {
// FIXME: ваша реализация здесь
        return persons.stream()
                .min((o1, o2) -> o1.getAge() - o2.getAge());
    }

    /*
    Найти департамент, в котором работает сотрудник с самой большой зарплатой
     */
    public Optional<Department> findMostExpensiveDepartment() {
// FIXME: ваша реализация здесь
        Optional<Person> personMaxSalary = persons.stream()
                .max((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        return Optional.ofNullable(personMaxSalary.get().getDepart());

    }

    /**
     * Сгруппировать сотрудников по департаментам
     */
    public Map<Department, List<Person>> groupByDepartment() {
// FIXME: ваша реализация здесь
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepart));
    }

    /**
     * Сгруппировать сотрудников по названиям департаментов
     */
    public Map<String, List<Person>> groupByDepartmentName() {
// FIXME: ваша реализация здесь
        return persons.stream()
                .collect(Collectors.groupingBy(it -> it.getDepart().getName()));
    }

    /**
     * В каждом департаменте найти самого старшего сотрудника
     */
    public Map<String, Person> getDepartmentOldestPerson() {
// FIXME: ваша реализация здесь
        return persons.stream()
                .collect(Collectors.toMap(
                        b -> b.getDepart().getName(),
                        b -> b,
                        (a, b) -> {
                            if (a.getAge() > b.getAge()) return a;
                            else return b;
                        }
                ));
    }

    /**
     * *Найти сотрудников с минимальными зарплатами в своем отделе
     * (прим. можно реализовать в два запроса)
     */
    public List<Person> cheapPersonsInDepartment() {
// FIXME: ваша реализация здесь

        Map<String, Person> personMap = persons.stream()
                .collect(Collectors.toMap(
                        b -> b.getDepart().getName(),
                        b -> b,
                        (a, b) -> {
                            if (a.getSalary() < b.getSalary()) return a;
                            else return b;

                        }

                ));
        List<Person> sortedPeople = personMap.values().stream()
                .collect(Collectors.toList());
        return sortedPeople;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Person p : persons) {
            str.append("имя: ").append(p.getName())
                    .append("\n")
                    .append("возраст: ")
                    .append(p.getAge()).append("\n")
                    .append("зарплата: ")
                    .append(p.getSalary()).append("\n")
                    .append("Название департамента: ")
                    .append(p.getDepart().getName()).append("\n")
                    .append("++++++++++++++++++").append("\n");


        }
        return str.toString();
    }
}
