package ra.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "zipcode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}