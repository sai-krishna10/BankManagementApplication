package com.saikrishna.BankingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saikrishna.BankingApplication.entity.Account;
import com.saikrishna.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/create")
	public String createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
		return "Account Created";
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountById(@PathVariable Long accountNumber) {
		Account account=accountService.getAccountByAccountNumber(accountNumber);
		return account;
	}
	
	@GetMapping("/getall")
	public List<Account> getAllAccounts(){
		List<Account> allAccounts=accountService.getAllAccounts();
		return allAccounts;
	}
	
	@PutMapping("/deposit/{accountNumber}/{balance}")
	public Account depositAmount(@PathVariable Long accountNumber, @PathVariable Double balance) {
		Account account=accountService.depositAmount(accountNumber,balance);
		return account;
	}
	
	@PutMapping("/withdraw/{accountNumber}/{balance}")
	public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double balance) {
		Account account=accountService.withdrawAmount(accountNumber,balance);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public String deleteAccountById(@PathVariable Long accountNumber) {
		accountService.deleteAccount(accountNumber);
		return "Account Deleted";
	}

}
