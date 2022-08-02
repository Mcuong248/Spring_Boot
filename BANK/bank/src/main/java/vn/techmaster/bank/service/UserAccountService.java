package vn.techmaster.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.bank.model.Account;
import vn.techmaster.bank.model.User;

import javax.transaction.Transactional;

public class UserAccountService {
    @Autowired private UserAccountService userAccountService;

    @Transactional
    public void generateUserAccountService() {
        Account account = new Account("123456", "Nguyễn Mạnh Cường", "mk123");
        account.addA
    }
}
