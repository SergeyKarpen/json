package main.java.com.sergeykarpen.crudconsole.model;

import java.io.Serializable;


public class Skill implements Serializable {

    private static final String pathToSkillFile = ("C:\\Users\\Admin\\IdeaProjects\\SpringSecurityApp\\CRUDConsole\\src\\main\\java\\com\\sergeykarpen\\crudconsole\\resources\\skills.txt");

    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return id + "," + name + "\n";
    }
}

