package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

public class CancelEvent implements Event {
    private final DatabaseError error;
    private final EventRegistration eventRegistration;
    private final Path path;

    public CancelEvent(EventRegistration eventRegistration2, DatabaseError databaseError, Path path2) {
        this.eventRegistration = eventRegistration2;
        this.path = path2;
        this.error = databaseError;
    }

    public void fire() {
        this.eventRegistration.fireCancelEvent(this.error);
    }

    public Path getPath() {
        return this.path;
    }

    public String toString() {
        return getPath() + ":CANCEL";
    }
}
