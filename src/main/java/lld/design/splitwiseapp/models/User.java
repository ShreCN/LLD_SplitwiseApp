package lld.design.splitwiseapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel{
    private String name;
    private String phoneNo;
    private String password;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
