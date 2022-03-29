package javatechonline.crudmvcrestexample.exeption;

public class InvoiceNotFoundException extends RuntimeException{

    private static final long  SERIAL_VERSION_UID = 1L;

    public InvoiceNotFoundException(){
        super();
    }

    public InvoiceNotFoundException(String customMessage){
        super(customMessage);
    }
}
