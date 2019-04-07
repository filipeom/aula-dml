package pt.ulisboa.tecnico.softeng.bank.domain;

public class Account extends Account_Base {

  public Account(Bank bank, String number) {
    setBank(bank);
    setNumber(number);
    setBalance(100);
  }

  public void delete() {
    setBank(null);
    
    deleteDomainObject();
  }
}
