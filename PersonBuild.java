public class PersonBuild {
    public Person personBuild(String name,int age,double salary,Department department){
        Person person = new Person(name,age,salary,department);
        return person;
    }
}
