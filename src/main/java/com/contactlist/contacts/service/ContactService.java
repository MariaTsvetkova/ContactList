package com.contactlist.contacts.service;

import com.contactlist.contacts.model.Contact;
import com.contactlist.contacts.paging.Paged;


public interface ContactService {
    Paged<Contact> searchContacts(int pageNumber, int pageSize, String keyword);
    Paged<Contact> findPaginated(int pageNumber, int pageSize);
}
