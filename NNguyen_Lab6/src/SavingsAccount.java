public class SavingsAccount extends BankAccount {
	private double rate = 0.025; //2.5% annual interest rate
	private int savingsNumber = 0;
	private String accountNumber;

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	//copy constructor
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		this.savingsNumber = oldAccount.savingsNumber + 1;
		this.accountNumber = (super.getAccountNumber() + "-" + this.savingsNumber);
	}

	public void postInterest() {
		double value = (getBalance() * rate)/12;
		super.deposit(value);
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}


}
