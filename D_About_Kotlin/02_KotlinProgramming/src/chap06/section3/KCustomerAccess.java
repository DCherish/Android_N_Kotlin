package chap06.section3;

public class KCustomerAccess {
    public static void main(String[] args) {
        System.out.println(KCustomer.LEVEL);
        KCustomer.login(); // @JvmStatic 애노테이션을 사용할 때 접근 방법
        KCustomer.Companion.login(); // 위와 동일한 결과, 애노테이션을 사용하지 않을 때

        KJob kjob = KCustomer.JOB;
        System.out.println(kjob.getTitle());
        // KJob에 대한 객체 생성 후 접근

        KCustomer.JOB.setTitle("Accountant");
        System.out.println(kjob.getTitle());
        // KCustomer를 통한 접근
    }
}
