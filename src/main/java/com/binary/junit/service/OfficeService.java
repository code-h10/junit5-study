package com.binary.junit.service;


import com.binary.junit.model.Employee;
import com.binary.junit.model.Office;
import com.binary.junit.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateOfficeAddress(Employee employee) throws Exception{

        Office office = new Office();
        office.setOfficeCode(employee.getOfficeCode());
        office.setAddressLine1("TEST");
        office.setAddressLine2("TEST");
        officeRepository.updateAddress(office);
        throw new RuntimeException();
    }
}
