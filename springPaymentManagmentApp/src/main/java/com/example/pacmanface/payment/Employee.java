package com.example.pacmanface.payment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Employee {
    private @Id @GeneratedValue int id;
    private String name;
    private String lastName;

    protected Employee() {
    }

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("employee attributes: %d, %s, %s",id,name,lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof Employee))return false;
        Employee employee = (Employee) obj;
        return Objects.equals(this.id,employee.id)&&
            Objects.equals(this.name,employee.name)&&
            Objects.equals(this.lastName,employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,lastName);
    }
}
