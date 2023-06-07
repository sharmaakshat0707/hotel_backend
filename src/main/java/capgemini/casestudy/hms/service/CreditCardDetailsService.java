package capgemini.casestudy.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.casestudy.hms.model.CreditCardDetails;
import capgemini.casestudy.hms.repository.CreditCardDetailsRepository;

@Service
public class CreditCardDetailsService {

    private final CreditCardDetailsRepository creditCardDetailsRepository;

    @Autowired
    public CreditCardDetailsService(CreditCardDetailsRepository creditCardDetailsRepository) {
        this.creditCardDetailsRepository = creditCardDetailsRepository;
    }

    public CreditCardDetails addCreditCardDetails(CreditCardDetails creditCardDetails) {
        return creditCardDetailsRepository.save(creditCardDetails);
    }

    public CreditCardDetails getCreditCardDetailsById(Long id) {
        return creditCardDetailsRepository.findById(id).orElse(null);
    }

    public CreditCardDetails updateCreditCardDetails(Long id, CreditCardDetails updatedCreditCardDetails) {
        CreditCardDetails existingCreditCardDetails = creditCardDetailsRepository.findById(id).orElse(null);
        if (existingCreditCardDetails != null) {
            existingCreditCardDetails.setCardNumber(updatedCreditCardDetails.getCardNumber());
            existingCreditCardDetails.setCardHolderName(updatedCreditCardDetails.getCardHolderName());
            existingCreditCardDetails.setExpirationMonth(updatedCreditCardDetails.getExpirationMonth());
            existingCreditCardDetails.setExpirationMonth(updatedCreditCardDetails.getExpirationYear());
            existingCreditCardDetails.setCvv(updatedCreditCardDetails.getCvv());
            return creditCardDetailsRepository.save(existingCreditCardDetails);
        } else {
            return null;
        }
    }

    public boolean deleteCreditCardDetails(Long id) {
        if (creditCardDetailsRepository.existsById(id)) {
            creditCardDetailsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

	public List<CreditCardDetails> fetchAllCreditCardDetails(){
		return (List<CreditCardDetails>) creditCardDetailsRepository.findAll();
	}
}
