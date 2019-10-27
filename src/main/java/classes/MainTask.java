package classes;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class MainTask {
    private static String creditCardCriteriaMax = "4566 4545 6445 4574";

    public static void main(String[] args) {

        Customer [] list = new Customer[5];
        list[0] = new Customer("Fedorov", "Ivan", "Alexandrovich", "Kutozov street, 23-14");
        list[0].setCreditCard("4566 4585 6745 5784");
        list[0].setBankAccount("40817 840 601500067890");
        list[1] = new Customer("Belkevich", "Catherine", "Viktorovna", "Mira street, 12");
        list[1].setCreditCard("4566 4545 6445 4574");
        list[1].setBankAccount("54544 158 785888852541");
        list[2] = new Customer("Baranenko", "Helen", "Petrovna","Pushkin street, 56-152");
        list[2].setCreditCard("8754 1855 0005 7644");
        list[2].setBankAccount("40817 755 727224451750");
        list[3] = new Customer("Petrov", "Peter","Ivanovich", "Napoleon street, 89");
        list[3].setCreditCard("8866 0005 6405 5700");
        list[3].setBankAccount("75577 415 475752400044");
        list[4] = new Customer("Ivanov", "Ivan", "Ivanovich", "Napoleon street, 5");
        list[4].setCreditCard("3386 4587 7522 1987");
        list[4].setBankAccount("85855 052 175550505455");

        System.out.println("List of Customers:");
        printList(list);

        Arrays.sort(list, new Customer.SurnameComparator());

        System.out.println("Sorted by surname:");
        printList(list);

        System.out.println("Criteria: Credit Card <= " + creditCardCriteriaMax + ":");
        Stream<Customer> stream = Stream.of(list);
        stream.filter(c -> c.getCreditCard()
                .compareTo(new BigInteger(creditCardCriteriaMax.replaceAll(" ", ""))) <= 0)
                .forEach(c -> System.out.println(c.getSurname() + " " + c.getName() + " " + c.getPatronymic()
                        + ": CreditCard " + c.getCreditCard().toString()
                        .replaceAll("(\\d{4})", "$1 ").trim()));
    }

    private static void printList(Customer[] list) {
        for (Customer customer : list){
            System.out.println(customer.toString());
        }
        System.out.println();
    }
}



class Customer{
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private BigInteger creditCard;
    private BigInteger bankAccount;

    public Customer(String surname, String name, String patronymic, String address, BigInteger creditCard, BigInteger bankAccount) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCard = creditCard;
        this.bankAccount = bankAccount;
    }

    public Customer() {
    }

    public Customer(String surname, String name, String patronymic, String address) {
        id = generateId();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
    }

    private int generateId() {
        Random random = new Random();
        int id = 1000 + random.nextInt(9000);
        return id;
    }


    public void setCreditCard(String card) {
        creditCard = new BigInteger(card.replaceAll(" ", ""));
    }

    public void setBankAccount(String account) {
        bankAccount = new BigInteger(account.replaceAll(" ", ""));
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public BigInteger getCreditCard() {
        return creditCard;
    }

    public BigInteger getBankAccount() {
        return bankAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCard=" + creditCardToSring() +
                ", bankAccount=" + bankAccountToSring() +
                '}';
    }

    private String creditCardToSring() {
        return creditCard.toString().replaceAll("(\\d{4})", "$1 ").trim();
    }

    private String bankAccountToSring() {
        return bankAccount.toString().replaceFirst("(.{5})", "$1 ").replaceFirst("(.{9})", "$1 ");
    }

    public static class SurnameComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }

}
