package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "specifications")
@SQLDelete(sql = "UPDATE specification SET deleted=true WHERE specification_id=?")
public class Specification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    @JsonIgnore
    private BigInteger specificationId;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int productWeight;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private String productLength;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private BigDecimal productWidth;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String product_color;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    @JsonIgnore
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAtDateTime;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updatedAtDateTime;

    @OneToOne(mappedBy = "specification", fetch = FetchType.LAZY)
    @JsonIgnore
    private Product product;
}
