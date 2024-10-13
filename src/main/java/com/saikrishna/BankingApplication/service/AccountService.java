package com.saikrishna.BankingApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saikrishna.BankingApplication.entity.Account;

@Service
public interface AccountService {
	public Account createAccount(Account account);
	public Account getAccountByAccountNumber(Long accountNumber);
	public Account depositAmount(Long accountNumber, Double amount);
	public Account withdrawAmount(Long accountNumber, Double amount);
	public void deleteAccount(Long accountNumber);
	public List<Account> getAllAccounts();
}
