package designpatterns.creational.factory.payment_processor;

import designpatterns.creational.factory.payment_processor.*;

// abstract Creator
abstract class PaymentCreator {

    // factory method
    public abstract PaymentMethod createPayment();

    // shared checkout logic
    public void checkout(int amount){
        PaymentMethod method = this.createPayment();
        method.validatePayment();
        method.processPayment(amount);
        method.getReceipt();
    }
}

// concrete creators
class CreditCardPaymentCreator extends  PaymentCreator{

    @Override
    public PaymentMethod createPayment() {
        return new PaymentMethod.CreditCardPaymentMethod();
    }
}

class PaytmPaymentCreator extends PaymentCreator{

    @Override
    public PaymentMethod createPayment() {
        return new PaymentMethod.PaytmPaymentMethod();
    }
}