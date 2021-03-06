package github.fincommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted=1 WHERE product_id=?")
@Where(clause = "deleted=0")
public class Product implements Serializable {

    @Id
    @JsonIgnore
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
    @JsonIgnore
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAtDateTime;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updatedAtDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "product_specification",
            joinColumns =
                    {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "specification_id", referencedColumnName = "specification_id")})
    private Specification specification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "product_video",
            joinColumns =
                    {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "video_id", referencedColumnName = "video_id")})
    private Video video;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products", targetEntity = Image.class)
//    @JoinColumn(name = "product_id")
    private List<Image> productImages;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "product_quantity",
            joinColumns =
                    {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "quantity_id", referencedColumnName = "quantity_id")})
    private Quantity quantity;
}
