package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "categorize")
public class CategorizeEdgeQueryModel {
    @Id
    private long id;
    private LocalDateTime categorizedAt;
}
