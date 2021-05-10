package com.contactlist.contacts.service;

import com.contactlist.contacts.model.Contact;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Collections;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {

    private static final String CSV_FILE = "src/main/resources/people.csv";

    @Override
    public List<Contact> readCsvFile() {

        try  {
            Reader reader = new BufferedReader(new FileReader(CSV_FILE));
            // create csv bean reader
            CsvToBean<Contact> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Contact.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Contact> users = csvToBean.parse();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
