package javatechonline.crudmvcrestexample.repo;

import javatechonline.crudmvcrestexample.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
