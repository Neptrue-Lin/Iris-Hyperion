package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "vote")
public class VoteEdgeQueryModel {
    @Id
    private long id;
    private Boolean vote;
    private LocalDateTime votedAt;
}
