package com.contactlist.contacts.service;

import com.contactlist.contacts.model.Contact;

import java.util.List;

public interface CsvService {
    public List<Contact> readCsvFile();

}
