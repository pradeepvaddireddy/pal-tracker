package io.pivotal.pal.tracker;

import java.util.List;
public interface TimeEntryRepository {
    public TimeEntry find(long id);

    public TimeEntry update(long id, TimeEntry timeEntry);

    void delete(long id);

    List<TimeEntry> list();

    TimeEntry create(TimeEntry any);
}

