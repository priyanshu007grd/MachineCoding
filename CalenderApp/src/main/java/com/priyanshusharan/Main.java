package com.priyanshusharan;

import com.priyanshusharan.model.Event;
import com.priyanshusharan.model.User;
import com.priyanshusharan.service.CalenderAppService;
import com.priyanshusharan.service.ICalenderAppService;
import com.priyanshusharan.storage.Storage;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CalenderAppService calenderAppService = new CalenderAppService();

        User user = User.builder().id(1).name("ram").build();
        Event event =  Event.builder().eventName("e1")
                .userId(Collections.singleton(1))
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusDays(4))
                .build();

        calenderAppService.addUser(user);
        System.out.println("getUserS");
        System.out.println(calenderAppService.getUserS());

        calenderAppService.addEvent(event);
        System.out.println("getEventS");
        System.out.println(calenderAppService.getEventS());

        System.out.println("getCalenderS");
        System.out.println(calenderAppService.getCalenderS());


        LocalDateTime currentDateTime = LocalDateTime.now();
        String dateKey = "" + currentDateTime.getYear()+currentDateTime.getMonth()+currentDateTime.getDayOfMonth();
        calenderAppService.getSchedule(1,dateKey);

        System.out.println(calenderAppService.getCalenderS());


    }
}