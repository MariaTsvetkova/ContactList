package com.contactlist.contacts.service;

import com.contactlist.contacts.model.Contact;
import com.contactlist.contacts.paging.Paged;
import com.contactlist.contacts.paging.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private CsvServiceImpl csvService;


    @Override
    public Paged<Contact> searchContacts(int pageNumber, int pageSize, String keyword) {
        List<Contact> content = Optional.ofNullable(csvService.readCsvFile())
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(i-> StringUtils.contains(i.getName().toLowerCase(), keyword.toLowerCase()) )
                .collect(Collectors.toList());

        return getPagedContactList(content, pageNumber, pageSize);
    }

    @Override
    public Paged<Contact> findPaginated(int pageNumber, int pageSize) {
        List<Contact> content = Optional.ofNullable(csvService.readCsvFile())
                .orElseGet(Collections::emptyList);

        return getPagedContactList(content, pageNumber, pageSize);
    }

    public Paged<Contact> getPagedContactList(List<Contact> content, int pageNumber, int pageSize) {
        Pageable pageable =  PageRequest.of(pageNumber - 1, pageSize);
        int start = (int) pageable.getOffset();
        int end = (int)(start + pageable.getPageSize()) > content.size() ? content.size() : (start + pageable.getPageSize());
        long total = content.size();
        Page pager= new PageImpl(content.subList(start, end), pageable, total);

        return new Paged<>(pager, Paging.of(pager.getTotalPages(),pageNumber, pageSize));
    }
}
