package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted=true WHERE product_id=?")
@RedisHash("Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger productId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String productName;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String productDetails;

    @Column(nullable = false, columnDefinition = "NUMERIC(38,2) DEFAULT 0", precision = 38, scale = 2)
    private BigDecimal product_price;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String productDescription;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Boolean product_isFragile = Boolean.FALSE;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "product_specification", joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}, inverseJoinColumns = {@JoinColumn(name = "specification_id", referencedColumnName = "specification_id")})
    private Specification specification;

    @OneToOne(cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "product_video", joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}, inverseJoinColumns = {@JoinColumn(name = "video_id", referencedColumnName = "video_id")})
    private Video video;
}
