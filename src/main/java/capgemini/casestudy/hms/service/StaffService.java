package capgemini.casestudy.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import capgemini.casestudy.hms.model.Staff;
import capgemini.casestudy.hms.repository.StaffRepository;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff createStaffMember(Staff staff) {
        return staffRepository.save(staff);
    }

    
    public List<Staff> getAllStaffMembers() {
        return (List<Staff>) staffRepository.findAll();
    }

    public Optional<Staff> getStaffMemberById(Long id) {
        return staffRepository.findById(id);
    }

    public Staff updateStaffMember(Staff staff) {
        return staffRepository.save(staff);
    }

    public void deleteStaffMember(Long id) {
        staffRepository.deleteById(id);
    }
}
