package com.priyanshusharan.service;

import com.priyanshusharan.model.Calender;
import com.priyanshusharan.model.Event;
import com.priyanshusharan.model.User;
import com.priyanshusharan.storage.CalenderStorage;
import com.priyanshusharan.storage.EventStorage;
import com.priyanshusharan.storage.UserStorage;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Getter
public class CalenderAppService implements ICalenderAppService{
    UserStorage<Integer,User> userS;
    EventStorage<Integer,Event> eventS;
    CalenderStorage<Integer, Calender> calenderS;

    public CalenderAppService(UserStorage<Integer, User> userS, EventStorage<Integer, Event> eventS, CalenderStorage<Integer, Calender> calenderS) {
        this.userS = userS;
        this.eventS = eventS;
        this.calenderS = calenderS;
    }

    public CalenderAppService() {
        this.userS = new UserStorage<>(0);
        this.eventS = new EventStorage<>(0);
        this.calenderS = new CalenderStorage<>(0);
    }

    @Override
    public void addUser(User user) {
        Integer userId = userS.getKey()+1;
        user.setId(userId);
        userS.add(userId,user);
    }

    @Override
    public void addEvent(Event event) {
        Integer eventId = eventS.getKey()+1;
        event.setId(eventId);
        eventS.add(eventId,event);

        event.getUserId().forEach(userId->{
            Calender calender;
            try {
                calender = calenderS.get(userId);
            } catch (RuntimeException e) {
                calender = new Calender();
                calender.setUserId(userId);
                calender.setSchedule(new HashMap<>());
            }

            LocalDateTime currentDateTime = event.getStart();
            while (!currentDateTime.isAfter(event.getEnd())) {
                LocalDateTime nextDateTime = currentDateTime.plusDays(1).truncatedTo(ChronoUnit.DAYS);
                LocalDateTime endOfDayDateTime = nextDateTime.minusNanos(1);
                LocalDateTime actualEndDateTime = event.getEnd().isBefore(endOfDayDateTime) ? event.getEnd() : endOfDayDateTime;

                Event event1 = Event.builder()
                        .eventName(event.getEventName())
                        .start(currentDateTime)
                        .end(actualEndDateTime)
                        .build();

                String dateKey = "" + currentDateTime.getYear()+currentDateTime.getMonth()+currentDateTime.getDayOfMonth();
                calender.getSchedule().putIfAbsent(dateKey,new ArrayList<>());
                calender.getSchedule().get(dateKey).add(event1);

                currentDateTime = nextDateTime;
            }

            calenderS.upsert(calender.getUserId(),calender);
        });

    }

    @Override
    public void getSchedule(Integer userId,String date) {
        System.out.println(calenderS.get(userId).getSchedule().get(date));
    }
}
