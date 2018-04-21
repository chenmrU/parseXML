package com.chenmr.parseXML.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Chenmr on 2018/4/21/021.
 */
@Getter
@Setter
public class Book {

    private String id;
    private String name;
    private String author;
    private String year;
    private String price;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
