package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository repository;



    public TimeEntryController(TimeEntryRepository repository) {

        this.repository = repository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        return new ResponseEntity( repository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {


        TimeEntry timeEntry = repository.find(timeEntryId);
        if(timeEntry == null) {
            return new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.NOT_FOUND);
        }

        ResponseEntity<TimeEntry> rep = new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK);
        return rep;
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(repository.list(), HttpStatus.OK);
    }


    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {

        if( repository.update(timeEntryId, expected) != null) {
            return new ResponseEntity(expected, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/time-entries/{timeEntryId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long timeEntryId) {

        repository.delete(timeEntryId);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);


    }
}
