package voting_system_app.model;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.*;

/**
 * @Alima-T 6/26/2022
 */
//@Entity
//@Table(name = "users")
@Data
@Entity
@Table(name = "user")
public class User {
//    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    //    @Column(name = "email", nullable = false, unique = true)
//    @Email
//    @NotEmpty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    //    @Column(name = "password", nullable = false)
//    @NotEmpty
//    @Length(min = 5)
    @Column(name = "password")
    private String password;

    //    @Column(name = "enabled", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
//    private boolean enabled = true;

    //    @Column(name = "registered", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date registered = new Date();

    @ManyToMany
    private final List<Role> roles = new ArrayList<>();

    public Collection<Role> getRoles() {
        return roles;
    }

    //    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "role")
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Role> roles;
}
