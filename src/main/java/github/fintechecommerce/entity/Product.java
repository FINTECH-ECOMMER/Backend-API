package github.fintechecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted=true WHERE product_id=?")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private Long productId;

    @Column(nullable = false, columnDefinition = "varchar(150) DEFAULT ''")
    private String productName;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String productDetails;

    @Column(nullable = false, columnDefinition = "NUMERIC(38,2) DEFAULT 0", precision = 38, scale = 2)
    private BigDecimal product_price;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String productDescription;

    @Column(nullable = false ,columnDefinition = "BIT DEFAULT 0")
    private Boolean product_isFragile = Boolean.FALSE;

    @Column(nullable = false,columnDefinition = "BIT DEFAULT 0")
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT GETDATE()")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;


//    Todo : Add Soft Delete
//    Todo: Create Response Trait For All
}
