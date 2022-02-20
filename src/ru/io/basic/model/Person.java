package ru.io.basic.model;

public class Person {

    private String fio;
    private Integer age;
    private Integer children;
    private Integer workAge;

    public Person(){

    }

    public Person(String fio, int age, int children, int workAge) {
        this.fio = fio;
        this.age = age;
        this.children = children;
        this.workAge = workAge;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", children=" + children +
                ", workAge=" + workAge +
                '}';
    }
}
