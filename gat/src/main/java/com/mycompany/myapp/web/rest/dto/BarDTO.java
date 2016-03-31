package com.mycompany.myapp.web.rest.dto;

import java.io.Serializable;
import java.util.Objects;


/**
 * A DTO for the Bar entity.
 */
public class BarDTO implements Serializable {

    private Long id;

    private String name;


    private Integer age;


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
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BarDTO barDTO = (BarDTO) o;

        if ( ! Objects.equals(id, barDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "BarDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", age='" + age + "'" +
            '}';
    }
}
