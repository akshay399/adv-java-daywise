package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// = new HttpTransport();// creating dependency n linking it with the dep. obj
	private long cash;

	// ctor based D.I -- to inject cash
	public ATMImpl(long cash1234) {
		cash = cash1234;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport + " " + cash);// not null
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// using dependency layer

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);// using dependency layer
	}

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null!
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null!
	}

	//setter based D.I -- transport layer
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter " + this.myTransport);
	}
	
	

}
