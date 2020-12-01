package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ParameterNotSpecifiedException;
import com.exampl.demo.exceptions.ResourceNotFoundException;
import com.exampl.demo.models.Schedule;
import com.exampl.demo.models.Test;
import com.exampl.demo.models.TestList;
import com.exampl.demo.models.User;
import com.exampl.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("schedules")
public class ScheduleController {
    @Autowired
    TestListRepository testListRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping
    public Page<Schedule> getAllSchedules(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    @GetMapping("{scheduleId}")
    public Schedule getScheduleById(@PathVariable Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("Schedule " + scheduleId + " not found"));
    }

    @PostMapping
    public Schedule createSchedule(@Valid @RequestBody Schedule schedule) {

        if (schedule.getGroup_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the group_id");
        else
            schedule.setGroup(groupRepository.findById(schedule.getGroup_id()).orElseThrow());
        if (schedule.getTest_id() == null)
            throw new ParameterNotSpecifiedException("You should specify the test_id");
        else
            schedule.setTestList(testListRepository.findById(schedule.getTest_id()).orElseThrow());
        return scheduleRepository.save(schedule);
    }

    @PutMapping("{scheduleId}")
    public Schedule updateSchedule(@PathVariable Long scheduleId, @Valid @RequestBody Schedule scheduleRequest) {
        return scheduleRepository.findById(scheduleId).map(schedule -> {
            schedule.setActive(scheduleRequest.getActive());
            schedule.setStart_dt(scheduleRequest.getStart_dt());
            schedule.setStart_time(scheduleRequest.getStart_time());
            schedule.setDuration(scheduleRequest.getDuration());
            schedule.setEnd_dt(scheduleRequest.getEnd_dt());
            schedule.setEnd_time(scheduleRequest.getEnd_time());

            if (scheduleRequest.getGroup_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the group_id");
            else
                schedule.setGroup(groupRepository.findById(scheduleRequest.getGroup_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Group " + scheduleRequest.getGroup_id() + " not found!"
                        )), scheduleRequest.getGroup_id());

            if (scheduleRequest.getTest_id() == null)
                throw new ParameterNotSpecifiedException("You should specify the test_id");
            else
                schedule.setTestList(testListRepository.findById(scheduleRequest.getTest_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "TestList " + scheduleRequest.getTest_id() + " not found!"
                        )), scheduleRequest.getTest_id());
            return scheduleRepository.save(schedule);

        }).orElseThrow(() -> new ResourceNotFoundException("Schedule " + scheduleId + " not found!"));
    }

    @DeleteMapping("{scheduleId}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long scheduleId) {
        return scheduleRepository.findById(scheduleId).map(schedule -> {
            scheduleRepository.delete(schedule);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Schedule " + scheduleId + " not found!"));
    }


}
