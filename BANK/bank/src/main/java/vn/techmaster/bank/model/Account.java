package vn.techmaster.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "account")
@Table(name = "account")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String password;

    public Account(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
}
