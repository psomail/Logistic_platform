package ru.logisticplatform.model.transportation;


import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.logisticplatform.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "transportations")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transportation extends BaseEntity {

    @Column(name = "name")
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    TransportationStatus transportationStatus = TransportationStatus.CREATED;
}
