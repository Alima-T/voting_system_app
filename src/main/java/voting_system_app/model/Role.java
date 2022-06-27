package voting_system_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.expression.Operation;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @Alima-T 6/26/2022
 */
//TODO
public class Role implements GrantedAuthority {
    String user;
    String admin;
    @Id
    private String id;
    @ManyToMany
    private final List<Operation> allowedOperations = new ArrayList<>();

    @Override
    public String getAuthority() {
        return id;
    }

    public List<Operation> getAllowedOperations() {
        return allowedOperations;
    }
}
