package com.priyanshusharan.service;

import com.priyanshusharan.model.Event;
import com.priyanshusharan.model.User;

public interface ICalenderAppService {
    void addUser(User user);
    void addEvent(Event event);
    void getSchedule(Integer userId,String date);
}
