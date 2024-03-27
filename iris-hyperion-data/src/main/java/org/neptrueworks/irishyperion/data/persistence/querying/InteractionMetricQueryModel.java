package org.neptrueworks.irishyperion.data.persistence.querying;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("interaction_metric")
public class InteractionMetricQueryModel {
    @Id
    private long id;
    private long target;
    private long userId;
    private Boolean vote;
}
