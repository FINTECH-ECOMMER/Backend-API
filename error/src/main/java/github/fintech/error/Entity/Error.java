package github.fintech.error.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "errors")
@SQLDelete(sql = "UPDATE errors SET deleted=1 WHERE category_id=?")
@Where(clause = "deleted=0")
public class Error implements Serializable {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "error_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger errorId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String errorName;

    @Column(nullable = false, columnDefinition = "VARCHAR DEFAULT ''")
    private String message;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String stackTrace;

    @CreationTimestamp
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "DATE DEFAULT NOW()")
    private LocalDateTime timestamp;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String serviceName;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String serviceEndpoint;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String ipAddress;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String endPoint;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String endPointMethod;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String requestParams;

    @CreationTimestamp
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "DATE DEFAULT NOW()")
    private LocalDateTime errorDate;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    @JsonIgnore
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "DATE DEFAULT NOW()")
    private LocalDateTime createdAtDateTime;
}
