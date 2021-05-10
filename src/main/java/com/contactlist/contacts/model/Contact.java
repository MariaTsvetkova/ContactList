package com.contactlist.contacts.model;


import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class Contact {

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String url;

    public Contact(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(url, contact.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("name=").append(name);
        sb.append(", url='").append(url);
        sb.append('}');
        return sb.toString();
    }
}
