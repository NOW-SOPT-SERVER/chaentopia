package org.example;

import org.example.assign1.Account;
import org.example.assign1.Customer;

import java.util.Scanner;

public class BankMain {
    static final Scanner scanner = new Scanner(System.in);
    // 고객 생성
    static Account account = new Account(110110, 1234, 50000);
    static Customer customer = new Customer(1, "정채은", account);
    public static void main(String[] args) {
        BankMain bankMain = new BankMain();
        System.out.println("어서오세요 솝트뱅크입니다.");
        bankMain.startBank();
    }

    // 은행 시스템 시작
    public void startBank() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("┌───원하시는 서비스를 선택해 주세요.───┐");
            System.out.println("|           1. 계좌 이체         |");
            System.out.println("|           2. 입금             |");
            System.out.println("|           3. 출금             |");
            System.out.println("|           0. 종료             |");
            System.out.println("└──────────────────────────────┘");

            int bankService = scanner.nextInt();

            switch (bankService) {
                case 1:
                    transfer();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 0:
                    System.out.println("서비스를 종료합니다.");
                    end();
                    isRunning = false;
                    break;
                default:
                    System.out.println("없는 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        scanner.close();
    }

    // 계좌 이체
    public void transfer() {
        boolean isComplete = false;
        while (!isComplete) {
            System.out.println("송금할 계좌 번호를 입력해 주세요");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("얼마를 송금하시겠나요?");
            int money = scanner.nextInt();
            scanner.nextLine();

            int property = account.getProperty();
            if (property - money < 0) {
                System.out.println("잔액이 부족합니다. 다시 시작해 주세요.");
                startBank();
                break;
            }

            System.out.println("송금 정보를 확인해 주세요.");
            System.out.println("┌──────────────────────────────┐");
            System.out.println("송금 계좌 번호: " + accountNumber +
                    "\n송금할 금액: " + money +
                    "\n잔액: " + (property - money));
            System.out.println("└──────────────────────────────┘");

            System.out.println("송금 정보가 맞나요?");
            isComplete = checkInfo("송금", money, isComplete);
        }
    }

    // 입금
    public void deposit() {
        System.out.println("입금할 금액을 입력해 주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        account.deposit(money);
        System.out.println("입금이 완료되었습니다. " + "\n잔액: " + account.getProperty());
    }

    // 출금
    public void withdraw() {
        boolean isComplete = false;
        while (!isComplete) {
            System.out.println("출금할 금액을 입력해 주세요.");
            int money = scanner.nextInt();
            scanner.nextLine();

            int property = account.getProperty();
            if (property - money < 0) {
                System.out.println("잔액이 부족합니다. 다시 시작해 주세요.");
                startBank();
                break;
            }

            System.out.println("출금할 금액을 확인해 주세요.");
            System.out.println("┌──────────────────────────────┐");
            System.out.println("출금할 금액: " + money +
                    "\n잔액: " + (property - money));
            System.out.println("└──────────────────────────────┘");

            System.out.println("출금 정보가 맞나요?");
            isComplete = checkInfo("출금", money, isComplete);
        }
    }

    // 비밀번호 확인
    public boolean checkPassword(Integer password) {
        return account.getPassword().equals(password);
    }

    // 정보 확인
    public boolean checkInfo(String info, Integer money, boolean isComplete) {
        System.out.println("1. 네");
        System.out.println("2. 아니요");

        int confirm = scanner.nextInt();
        scanner.nextLine();

        switch (confirm) {
            case 1:
                System.out.println("비밀번호를 입력해 주세요");

                boolean passwordCorrect = false;
                while (!passwordCorrect) {
                    int password = scanner.nextInt();
                    scanner.nextLine();
                    if (checkPassword(password)) {
                        account.withdraw(money);
                        System.out.println(info + "이 완료되었습니다. " + "\n잔액: " + account.getProperty());
                        passwordCorrect = true;
                        isComplete = true;
                        break;
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 다시 입력해 주세요.");
                    }
                }
                break;
            case 2:
                System.out.println("정보를 다시 입력해 주세요.");
                break;
            default:
                System.out.println("없는 선택지입니다. 다시 시도해 주세요.");
        }
        return isComplete;
    }


    // 은행 종료
    public void end() {
        System.out.println("솝트뱅크를 이용해주셔서 감사합니다.");
        System.exit(0); // 프로그램 종료
    }
}