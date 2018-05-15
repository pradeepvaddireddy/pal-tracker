package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    public TimeEntry create(TimeEntry timeEntry) {
        long id = timeEntries.size() + 1L;
        TimeEntry newTimeEntry =  new TimeEntry(id,timeEntry.getProjectId(), timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.put(id,newTimeEntry);
        System.out.println("id===="+id);
        return newTimeEntry;
    }


    @Override
    public TimeEntry find(long id) {
        return  timeEntries.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry toUpdateTimeEntry =  timeEntries.get(id);
        if(null !=toUpdateTimeEntry) {
            toUpdateTimeEntry.setDate(timeEntry.getDate());
            toUpdateTimeEntry.setHours(timeEntry.getHours());
            toUpdateTimeEntry.setProjectId(timeEntry.getProjectId());
            toUpdateTimeEntry.setUserId(timeEntry.getUserId());
        }

        return toUpdateTimeEntry;
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(timeEntries.values());
    }
}
