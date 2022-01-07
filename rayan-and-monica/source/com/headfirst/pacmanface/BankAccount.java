package RayanAndMonica;

public class BankAccount {
    int balance = 100;

    int getBalance(){
        return balance;
    }

    void withdraw(int amount){
        balance -= amount;
    }
}
