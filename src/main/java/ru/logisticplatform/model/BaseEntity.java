package ru.logisticplatform.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ru.logisticplatform.model.user.UserStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Base SuperClass with common fields
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    @UpdateTimestamp
    private Date updated;
}