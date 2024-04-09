package org.example.assign1;

public class Customer {

    // 사용자 식별 id
    private Integer id;
    // 사용자 이름
    private String name;
    // 계좌
    private Account account;

    public Customer(Integer id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    // Getter
    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
    public Account getAccount() { return this.account; }
}

