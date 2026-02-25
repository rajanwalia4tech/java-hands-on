package designpatterns.creational.factory.payment_processor;

/*
Problem: Build a payment processing system where each payment method has processPayment(amount),
validatePayment(), and getReceipt() methods.

Requirements:
- Product interface: PaymentMethod with three methods
    - CreditCard: validates card number format, processes with 2.5% fee, receipt shows "Card ending in ****"
    - PayPal: validates email format, processes with 1.5% fee, receipt shows "PayPal: user@email.com"
    - Crypto: validates wallet address, processes with 0.5% fee, receipt shows "Wallet: 0x..."
Creator's shared logic: checkout(amount) validates, processes, then prints receipt
 */
public class PaymentProcessorDemo {

    public static void main(String[] args) {
        PaymentCreator paymentProcessor = new CreditCardPaymentCreator();
        paymentProcessor.checkout(1000);

        paymentProcessor = new PaytmPaymentCreator();
        paymentProcessor.checkout(20000);
    }
}
