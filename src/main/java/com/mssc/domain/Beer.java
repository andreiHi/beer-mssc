package com.mssc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    private String beerName;
    private String beerStyle;

    @Column(unique = true)
    private Long upc;
    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Objects.equals(version, beer.version)
                && Objects.equals(createdDate, beer.createdDate)
                && Objects.equals(lastModifiedDate, beer.lastModifiedDate)
                && Objects.equals(beerName, beer.beerName)
                && Objects.equals(beerStyle, beer.beerStyle)
                && Objects.equals(upc, beer.upc)
                && Objects.equals(price, beer.price)
                && Objects.equals(minOnHand, beer.minOnHand)
                && Objects.equals(quantityToBrew, beer.quantityToBrew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, createdDate,
                lastModifiedDate, beerName,
                beerStyle, upc, price,
                minOnHand, quantityToBrew);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Beer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("version=" + version)
                .add("createdDate=" + createdDate)
                .add("lastModifiedDate=" + lastModifiedDate)
                .add("beerName='" + beerName + "'")
                .add("beerStyle='" + beerStyle + "'")
                .add("upc=" + upc)
                .add("price=" + price)
                .add("minOnHand=" + minOnHand)
                .add("quantityOnHand=" + quantityToBrew)
                .toString();
    }
}
