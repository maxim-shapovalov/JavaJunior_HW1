public class Main {
    public static void main(String[] args) {
        Department department1 = new Department("����� ������������");
        Department department2 = new Department("����� ������");
        Department department3 = new Department("������������ �����");
        Department department4 = new Department("���������� �����");
        ServicePerson servicePerson = new ServicePerson();
        servicePerson.addPerson("�������",25,1000.0,department1);
        servicePerson.addPerson("����",35,1500,department2);
        servicePerson.addPerson("�������",28,100.0,department3);
        servicePerson.addPerson("���������",38,1500.0,department1);
        servicePerson.addPerson("����",21,3000,department4);
        servicePerson.addPerson("�����",33,2400.0,department4);
        servicePerson.addPerson("����",45,2300,department2);
        servicePerson.addPerson("���������",27,2000.0,department1);
        System.out.println(servicePerson.toString());
        System.out.println("����� ������� ���������");
        System.out.println(servicePerson.findMostYoungestPerson().toString());
        System.out.println("�����������, � ������� �������� ��������� � ����� ������� ���������");
        System.out.println(servicePerson.findMostExpensiveDepartment().toString());
        System.out.println("������������� ����������� �� �������������");
        System.out.println(servicePerson.groupByDepartment());
        System.out.println("������������� ����������� �� ��������� �������������");
        System.out.println(servicePerson.groupByDepartmentName());
        System.out.println("� ������ ������������ ����� ������ �������� ����������");
        System.out.println(servicePerson.getDepartmentOldestPerson());
        System.out.println("����� ����������� � ������������ ���������� � ����� ������");
        System.out.println(servicePerson.cheapPersonsInDepartment());
    }
}
