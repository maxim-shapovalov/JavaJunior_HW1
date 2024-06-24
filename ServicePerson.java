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
     * ����� ������ �������� ����������
     */
    public Optional<Person> findMostYoungestPerson() {
// FIXME: ���� ���������� �����
        return persons.stream()
                .min((o1, o2) -> o1.getAge() - o2.getAge());
    }

    /*
    ����� �����������, � ������� �������� ��������� � ����� ������� ���������
     */
    public Optional<Department> findMostExpensiveDepartment() {
// FIXME: ���� ���������� �����
        Optional<Person> personMaxSalary = persons.stream()
                .max((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        return Optional.ofNullable(personMaxSalary.get().getDepart());

    }

    /**
     * ������������� ����������� �� �������������
     */
    public Map<Department, List<Person>> groupByDepartment() {
// FIXME: ���� ���������� �����
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepart));
    }

    /**
     * ������������� ����������� �� ��������� �������������
     */
    public Map<String, List<Person>> groupByDepartmentName() {
// FIXME: ���� ���������� �����
        return persons.stream()
                .collect(Collectors.groupingBy(it -> it.getDepart().getName()));
    }

    /**
     * � ������ ������������ ����� ������ �������� ����������
     */
    public Map<String, Person> getDepartmentOldestPerson() {
// FIXME: ���� ���������� �����
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
     * *����� ����������� � ������������ ���������� � ����� ������
     * (����. ����� ����������� � ��� �������)
     */
    public List<Person> cheapPersonsInDepartment() {
// FIXME: ���� ���������� �����

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
            str.append("���: ").append(p.getName())
                    .append("\n")
                    .append("�������: ")
                    .append(p.getAge()).append("\n")
                    .append("��������: ")
                    .append(p.getSalary()).append("\n")
                    .append("�������� ������������: ")
                    .append(p.getDepart().getName()).append("\n")
                    .append("++++++++++++++++++").append("\n");


        }
        return str.toString();
    }
}
