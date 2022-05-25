package github.fintechecommerce.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String productName;

    private String productDescription;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
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
