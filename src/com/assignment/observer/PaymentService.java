package com.assignment.observer;

/**
 * @author Swarn Singh.
 */
public class PaymentService {
    public void makePayment(Transaction t) {
        //updatePaymentToGatewayDB(t);
        ICICIBankServiceUtil.postTransaction(t);
    }
}
