package com.mbdev.bill.service;

import com.mbdev.bill.entity.Bill;
import com.mbdev.bill.exception.BillNotFoundException;
import com.mbdev.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;


    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElseThrow(() ->
                new BillNotFoundException("Unable to find bill with id: " + billId));
    }

    public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, OffsetDateTime creationDate, Boolean overdraftEnable) {
        Bill bill = new Bill(accountId, amount, isDefault, overdraftEnable);
        return billRepository.save(bill).getBillId();
    }


    public Bill updateBill(Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnable) {
        Bill bill = new Bill(accountId, amount, isDefault, overdraftEnable);
        bill.setBillId(billId);
        Bill save = billRepository.save(bill);
        return save;
    }

    public Bill deleteBill(Long billId){
        Bill deletedBill = getBillById(billId);
        billRepository.deleteById(billId);
        return deletedBill;
    }

    public List<Bill> getBillsByAccountId(Long accountId){
         return billRepository.getBillsByAccountId(accountId);
    }
}
