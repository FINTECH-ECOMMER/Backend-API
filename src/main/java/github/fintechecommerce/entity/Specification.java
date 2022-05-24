package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "specifications")
@SQLDelete(sql = "UPDATE specification SET deleted=true WHERE specification_id=?")
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
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
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT GETDATE()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime updatedDateTime;


    @OneToOne(mappedBy = "specification")
    @Cascade(CascadeType.ALL)
    private Product product;

    //    Todo : Add Soft Delete
//    Todo: Create Response Trait For All
}
