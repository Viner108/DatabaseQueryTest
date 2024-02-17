package com.database.entity;

public class Row {
    private Long id;
    private String string;

    public Row(Long id, String string) {
        this.id = id;
        this.string = string;
    }

    public Row() {
    }

    @Override
    public String toString() {
        return "Row{" +
               "id=" + id +
               ", string='" + string + '\'' +
               '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
