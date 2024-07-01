package Model.Payment;

public class PayPalPaymentProcessor implements PaymentProcessor
{
    public boolean processPayment(double amount)
    {
        System.out.println("Amount: "+amount+" process sussfully through paypal ");
        return true;
    }
}