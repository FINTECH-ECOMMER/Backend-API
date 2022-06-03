package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "errorsLog")
public class ErrorLog {
    @Id
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    String message;
    String systemMessage;
    String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ErrorLog error = (ErrorLog) o;
        return id != null && Objects.equals(id, error.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
