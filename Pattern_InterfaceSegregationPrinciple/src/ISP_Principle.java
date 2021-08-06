interface Payment{
	void initiateLoanSettlement();
	void initiateRePayment();
}

class LoanPayment implements Payment {

    @Override
    public void initiatePayments() {
        throw new UnsupportedOperationException("This is not a bank payment");
    }

    @Override
    public Object status() {
        // ...
    }

    @Override
    public List<Object> getPayments() {
        // ...
    }

    @Override
    public void intiateLoanSettlement() {
        // ...
    }

    @Override
    public void initiateRePayment() {
        // ...
    }
	
}


public class ISP_Principle {
	public static void main(String[] args) {
		System.out.println("hey");
	}
}
