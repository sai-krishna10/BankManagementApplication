package com.saikrishna.BankingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saikrishna.BankingApplication.entity.Account;
import com.saikrishna.BankingApplication.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account createAccount(Account account) {
		Account savedAccount=accountRepo.save(account);
		return savedAccount;
	}

	@Override
	public Account getAccountByAccountNumber(Long accountNumber) {
		Optional<Account> getAccount=accountRepo.findById(accountNumber);
		if(getAccount.isEmpty()) {
			throw new RuntimeException("Account Not Found");
		}
		Account account=getAccount.get();
		return account;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> getAccount =accountRepo.findById(accountNumber);
		if(getAccount.isEmpty()) {
			throw new RuntimeException("Account Not Found");
		}
		Account account=getAccount.get();
		Double accBalance=account.getBalance();
		account.setBalance(accBalance+amount);
		accountRepo.save(account);
		return account;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> getAccount =accountRepo.findById(accountNumber);
		if(getAccount.isEmpty()) {
			throw new RuntimeException("Account Not Found");
		}
		Account account=getAccount.get();
		Double accBalance=account.getBalance();
		account.setBalance(accBalance-amount);
		accountRepo.save(account);
		return account;
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepo.deleteById(accountNumber);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> allAccounts=accountRepo.findAll();
		return allAccounts;
	}
	
	
}
