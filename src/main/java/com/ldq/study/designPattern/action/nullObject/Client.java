package com.ldq.study.designPattern.action.nullObject;

/**
 * 空对象模式，避免了所有判断null的行为
 *
 */
public class Client {

    public static void main(String[] args) {
        String[] names = {"lily-1","lucy","jack","leo","wang"};
        for (String name : names) {
            Customer customer = CustomerFactory.getCustomer(name);
            System.out.println(customer.getName());
        }
    }
}
