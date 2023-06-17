package com.priyanshusharan.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Event {
    Integer id;
    String eventName;
    LocalDateTime start;
    LocalDateTime end;
    Set<Integer> userId;
}
