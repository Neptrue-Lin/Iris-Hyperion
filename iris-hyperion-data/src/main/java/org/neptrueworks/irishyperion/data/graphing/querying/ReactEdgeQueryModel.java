package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "react")
public class ReactEdgeQueryModel {
    @Id
    private long id;
    private long reaction;
    private LocalDateTime reactedAt;
}
