package am.basic.web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user", schema = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;
    @NotBlank
    private String name;
    private String surname;
    private String username;
    @Size(min = 3, message = "nope")
    private String password;
    @Transient
    private int age;
    private int code;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card card;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Action> action;

}
