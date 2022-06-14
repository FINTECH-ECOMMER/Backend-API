package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
@SQLDelete(sql = "UPDATE categories SET deleted=1 WHERE category_id=?")
@Where(clause = "deleted=0")
public class Category implements Serializable{

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger categoryId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String categoryName;

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
}
