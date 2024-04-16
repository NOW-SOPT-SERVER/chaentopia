package org.example.assign1;

public class Account {

    public Integer accountNumber;
    public Integer password;
    public Integer property;

    public Account(Integer accountNumber, Integer password, Integer property) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.property = property;
    }

    // 계좌 이체 및 출금
    public void withdraw(Integer money) {
        property -= money;
    }

    // 입금
    public void deposit(Integer money) {
        property += money;
    }

    // Getter
    public Integer getAccountNumber() { return this.accountNumber; }
    public Integer getPassword() { return this.password; }
    public Integer getProperty() { return this.property; }
}
