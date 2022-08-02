package vn.techmaster.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class User {
    @Id
    @Column
    private String id;
    private String name;
    private String address;

    public User(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Account> accounts = new ArrayList<>();
    public void addAddress(Account account) {
        accounts.setUser(this);
        addresses.add(address);
    }
}
