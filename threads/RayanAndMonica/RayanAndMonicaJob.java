package RayanAndMonica;

public class RayanAndMonicaJob implements Runnable {

    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RayanAndMonicaJob job = new RayanAndMonicaJob();
        Thread rayan = new Thread(job);
        Thread monica = new Thread(job);
        rayan.setName("Rayan");
        monica.setName("Monica");
        rayan.start();
        monica.start();
    }

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            makeWithdraw(10);
            if(account.getBalance()<0){
                System.out.println("OUTLIMITED!");
            }
        }
    }

    void makeWithdraw(int amount){
        if(account.getBalance()>=amount){
            System.out.println(Thread.currentThread().getName() + " STARTED");
            try {
                System.out.println(Thread.currentThread().getName() + " PAUSED");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " CONTINUED");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName()+" FINISHED, " + account.getBalance());
        }else{
    
            System.out.println(Thread.currentThread().getName()+" BROKEN (negative balance)");
        }
    }
}
