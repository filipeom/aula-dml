package pt.ulisboa.tecnico.softeng.bank.domain;

import java.util.*;

import pt.ist.fenixframework.FenixFramework;

public class Bank extends Bank_Base {

	public Bank(String name, String code) {
		setName(name);
		setCode(code);

		FenixFramework.getDomainRoot().addBank(this);
	}

	public void delete() {
		setRoot(null);

    for (Account account : getAccountSet())
      account.delete();

		deleteDomainObject();
	}

  public int totalBalance() {
    return getAccountSet().stream().mapToInt(acc -> acc.getBalance()).sum();
  }

	public static Bank getBankByCode(String code) {
		for (Bank bank : FenixFramework.getDomainRoot().getBankSet()) {
			if (bank.getCode().equals(code)) {
				return bank;
			}
		}
		return null;
	}

}
