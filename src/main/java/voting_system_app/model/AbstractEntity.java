package voting_system_app.model;

import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Optional;

/**
 * @Alima-T 27.06.2022
 */

@MappedSuperclass
public abstract class AbstractEntity<Id extends Serializable> extends AbstractPersistable<Id> {

    @Version
    private Long version;

    public @NotNull Optional<Long> getVersion() {
        return Optional.ofNullable(version);
    }

    protected void setVersion(@Nullable Long version) { // <4>
        this.version = version;
    }
}

