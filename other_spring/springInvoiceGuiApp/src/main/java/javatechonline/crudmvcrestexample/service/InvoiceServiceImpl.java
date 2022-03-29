package javatechonline.crudmvcrestexample.service;

import javatechonline.crudmvcrestexample.exeption.InvoiceNotFoundException;
import javatechonline.crudmvcrestexample.model.Invoice;
import javatechonline.crudmvcrestexample.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository repo;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return repo.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repo.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> opt = repo.findById(id);
        if (opt.isPresent()){
            return opt.get();
        } else {
            throw new InvoiceNotFoundException("wrong id "+id);
        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        repo.save(invoice);
    }
}
