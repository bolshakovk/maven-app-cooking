package com.github.bolshakovk.tables;

public class Ingridients {
    private String name;

    public Ingridients(String name, int cal) {
        this.name = name;
        this.cal = cal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    private int cal;
    public Ingridients() {
    }
}
