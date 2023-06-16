package com.priyanshusharan.Entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Log {
    LocalDateTime dateTime;
    Event event;
    Integer taskId;
}
