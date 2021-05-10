package com.contactlist.contacts.controller;

import com.contactlist.contacts.model.Contact;

import com.contactlist.contacts.paging.Paged;
import com.contactlist.contacts.service.ContactService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    ContactService contactService;

    private static final int PAGE_SIZE = 5;


    @RequestMapping("/")
    public String view3(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
                        Model m, Error error) {


        Paged<Contact> paged;
        if (StringUtils.isBlank(keyword)) {
            paged = contactService.findPaginated(pageNo, PAGE_SIZE);
        } else {
            paged = contactService.searchContacts(pageNo, PAGE_SIZE, keyword);
        }
        m.addAttribute("errorMsg", error.getMessage());
        m.addAttribute("keyword", keyword);
        if (!paged.getPage().getContent().isEmpty()) {
            m.addAttribute("currentPage", 0);
            m.addAttribute("data", paged);
        } else {
            m.addAttribute("errorMsg", "Sorry record not found!");
        }
        return "index";

    }

}
