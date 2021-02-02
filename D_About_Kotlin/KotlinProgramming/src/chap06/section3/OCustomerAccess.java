package chap06.section3;

public class OCustomerAccess {
    public static void main(String[] args) {
        String name = OCustomer.INSTANCE.getName();
        System.out.println(name);
    }
}
