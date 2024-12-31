package com.chan.mybatis_hrd.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;



public class Author {
    private int author_id;
    private String name;
    private String gender;

    public Author(int author_id, String name, String gender) {
        this.author_id = author_id;
        this.name = name;
        this.gender = gender;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
