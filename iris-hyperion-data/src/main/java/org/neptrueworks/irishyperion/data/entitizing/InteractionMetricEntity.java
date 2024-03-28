package org.neptrueworks.irishyperion.data.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("interaction_metric")
public class InteractionMetricEntity {
    @Id
    private long id;
    private long target;
    private long userId;
    private Boolean vote;
}
