package lld.design.splitwiseapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "splitwise_groups")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> users;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
