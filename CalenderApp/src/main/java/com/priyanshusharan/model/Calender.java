package com.priyanshusharan.model;

import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Calender {
    Integer userId;
    Map<String, List<Event>> schedule;
}
