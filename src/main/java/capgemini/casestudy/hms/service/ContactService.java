package capgemini.casestudy.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.casestudy.hms.model.Contact;
import capgemini.casestudy.hms.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactMessageRepository) {
        this.contactRepository = contactMessageRepository;
    }

    public Contact createContactMessage(Contact contactMessage) {
        return contactRepository.save(contactMessage);
    }

	
}
