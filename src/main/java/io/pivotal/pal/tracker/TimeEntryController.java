package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository = null;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(timeEntry, CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(null != timeEntry) {
            return new ResponseEntity<>(timeEntry, OK);
        }
        return new ResponseEntity<>(NOT_FOUND);

    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

            return new ResponseEntity<>(timeEntryRepository.list(),OK);

    }
    @PutMapping("{l}")
    public ResponseEntity update(@PathVariable long l, @RequestBody TimeEntry expected) {

        TimeEntry timeEntry = timeEntryRepository.update(l,expected);
        if (null == timeEntry) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(timeEntry,OK);

    }
    @DeleteMapping("{l}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long l) {
        timeEntryRepository.delete(l);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
