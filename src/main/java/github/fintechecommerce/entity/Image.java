package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "images")
@SQLDelete(sql = "UPDATE images SET deleted=1 WHERE image_id=?")
@Where(clause = "deleted=0")
public class Image implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger imageId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String image_name;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String image_desc;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String image_url;

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

    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="product_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;
}