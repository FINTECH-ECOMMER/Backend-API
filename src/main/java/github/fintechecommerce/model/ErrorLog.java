package github.fintechecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorLog {
    String message;
    String systemMessage;
    String url;
}
