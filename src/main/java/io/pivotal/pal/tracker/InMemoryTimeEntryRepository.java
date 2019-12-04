package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private long idCounter = 0;

    private Map<Long,TimeEntry> store = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(++idCounter);
        store.put(idCounter, timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return store.get(id);
    }

    public List<TimeEntry> list() {

        return  new ArrayList<TimeEntry>(store.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        if(store.get(id) == null) return null;
        timeEntry.setId(id);
        store.put(id, timeEntry);
        return timeEntry;


    }

    public void delete(long id) {
        store.remove(id);

    }

}
