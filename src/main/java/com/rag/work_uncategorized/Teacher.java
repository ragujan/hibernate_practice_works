package com.rag.work_uncategorized;

import javax.persistence.*;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Teacher.getAll", query ="SELECT s FROM Teacher s"),
                @NamedQuery(name = "Teacher.getByName", query ="SELECT s FROM Teacher s WHERE s.name=:name")
        }
)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
}
