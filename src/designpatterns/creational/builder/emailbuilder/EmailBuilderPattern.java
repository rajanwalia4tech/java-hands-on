package designpatterns.creational.builder.emailbuilder;

public class EmailBuilderPattern {
    public static void main(String[] args) {
        Email e1 = new Email.Builder("test@gmail.com","Regarding Referral")
                .build();
        System.out.println(e1);


        Email e2 = new Email.Builder("test@gmail.com","Regarding Referral")
                .cc("test1@gmail.com")
                .cc("test2@gmail.com")
                .build();
        System.out.println(e2);
    }
}
