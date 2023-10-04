package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
//@ConditionalOnExpression(value = "'${witron-config[\'lanchaster.enable\']:false}'.equalsIgnoreCase('true')")
public class Scheduler {

    public static final Set<String> eventNames = new HashSet<>(); // list of event name that you want to execute

    static {
        eventNames.addAll(Stream.of("CONTAINER_PAIR_RESPONSE","MOVE_MESSAGE_UPDATE","LOADING_LOAD_UPDATE_MESSAGE","GLS_CREATED","GLS_ORDER_FILLER_ASSIGNED","GLS_ORDER_FILLER_UNASSIGNED",
                "GLS_COMPLETED","GLS_PAUSED","GLS_STANDARDS_UPDATED","GLS_MANUALLY_UNASSIGNED","GLS_CANCELLED","GLS_SHIFT_UPDATED","GLS_ASSIGNED",
                "GLS_RESUMED","GLS_ON_HOLD","GLS_OFF_HOLD","ATLAS_TRIP_STANDARDS",
                "GLS_MANUALLY_ASSIGNED","CONTAINER_UPDATED","VOICE_PICK_EVENT").collect(Collectors.toList()));
    }


}
