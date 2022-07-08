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
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "errors")
@SQLDelete(sql = "UPDATE errors SET deleted=1 WHERE category_id=?")
@Where(clause = "deleted=0")
public class Error {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "error_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger errorId;
    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String errorName;

//    private String message;
//    private String stackTrace;
//    private String timestamp;
//    private String serviceName;
//    private String serviceEndpoint;
//    private String ipAddress;
//    private String endPoint;
//    private String endPointMethod;
//    private String requestParams;
//    private String errorDate;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    @JsonIgnore
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAtDateTime;

}
