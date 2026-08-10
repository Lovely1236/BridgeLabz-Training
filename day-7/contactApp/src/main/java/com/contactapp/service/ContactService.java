package com.contactapp.service;

import com.contactapp.dto.ContactRequest;
import com.contactapp.dto.ContactResponse;
import com.contactapp.model.Contact;
import com.contactapp.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public List<ContactResponse> findAllContacts() {
        return findAll().stream().map(this::toResponse).toList();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
    }

    public ContactResponse findContactById(Long id) {
        return toResponse(findById(id));
    }

    public ContactResponse create(ContactRequest request) {
        Contact contact = toEntity(request);
        contact.setId(null);
        return toResponse(contactRepository.save(contact));
    }

    public ContactResponse update(Long id, ContactRequest request) {
        Contact existingContact = findById(id);
        existingContact.setName(request.name());
        existingContact.setEmail(request.email());
        existingContact.setPhone(request.phone());
        return toResponse(contactRepository.save(existingContact));
    }

    public void delete(Long id) {
        Contact existingContact = findById(id);
        contactRepository.delete(existingContact);
    }

    private Contact toEntity(ContactRequest request) {
        Contact contact = new Contact();
        contact.setName(request.name());
        contact.setEmail(request.email());
        contact.setPhone(request.phone());
        return contact;
    }

    private ContactResponse toResponse(Contact contact) {
        return new ContactResponse(contact.getId(), contact.getName(), contact.getEmail(), contact.getPhone());
    }
}