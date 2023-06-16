package com.priyanshusharan.Entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Task {
    Integer id;
    LocalDateTime deadline;
    List<String> tags;
    String heading;
    String note;
    Boolean isCompleted;
}
