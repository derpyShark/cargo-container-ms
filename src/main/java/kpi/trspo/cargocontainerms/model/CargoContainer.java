package kpi.trspo.cargocontainerms.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "cargo_containers")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoContainer {

    @Id
    @GeneratedValue
    private UUID containerId;
    @NotNull
    @Column(name = "cargo_weight")
    private float cargoWeight;
    @NotNull
    @JoinColumn(name = "cargo_type_id")
    private UUID cargoType;
    @NotNull
    @JoinColumn(name = "machinery_id")
    private UUID machineryWithContainer;

}
