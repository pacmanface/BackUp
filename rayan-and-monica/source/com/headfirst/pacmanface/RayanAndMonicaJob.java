package com.headfirst.pacmanface;

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
            makeWithdraw(index, 10);
            /*
            if(account.getBalance()<0){
                System.out.println(index + "-" + Thread.currentThread().getName() + " Negative balance!");
            */
        }
    }

    synchronized void makeWithdraw(int transaction, int amount){
        if(account.getBalance()>=amount){
            try {
                System.out.println(transaction +"-"+ Thread.currentThread().getName() + " STARTED");
                System.out.println(transaction +"-"+Thread.currentThread().getName() + " PAUSED");
                Thread.sleep(500);
                System.out.println(transaction +"-"+Thread.currentThread().getName() + " CONTINUED");
                account.withdraw(amount);
                System.out.println(transaction +"-"+Thread.currentThread().getName()+" FINISHED, " + account.getBalance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(transaction +"-"+Thread.currentThread().getName()+ " OUTLIMITED!");
        }
    }
}
