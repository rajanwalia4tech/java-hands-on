package designpatterns.creational.factory.payment_processor;

// Product interface
public interface PaymentMethod {
    void processPayment(int amount);
    boolean validatePayment();
    String getReceipt();

    // concrete products
    class CreditCardPaymentMethod implements PaymentMethod{

        @Override
        public void processPayment(int amount) {
            double fee = 0.025 * amount;
            System.out.printf("Processing credit card payment: %d  (fee: %f)",amount,fee);
        }

        @Override
        public boolean validatePayment() {
            System.out.println("Validating credit card...");
            return true;
        }

        @Override
        public String getReceipt() {
            return new String("Card ending in ****1234");
        }
    }


    class PaytmPaymentMethod implements PaymentMethod{

        @Override
        public void processPayment(int amount) {
            double fee = 0.5 * amount;
            System.out.printf("Processing Paytm payment: %d  (fee: %f)",amount,fee);
        }

        @Override
        public boolean validatePayment() {
            System.out.println("Validating Paytm ...");
            return true;
        }

        @Override
        public String getReceipt() {
            return new String("Paytm ending in ****1234");
        }
    }
}
