package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildChangeAccumulator {
    private final Map<ChildKey, Change> changeMap = new HashMap();

    public List<Change> getChanges() {
        return new ArrayList(this.changeMap.values());
    }

    public void trackChildChange(Change change) {
        boolean z10;
        Event.EventType eventType = change.getEventType();
        ChildKey childKey = change.getChildKey();
        Event.EventType eventType2 = Event.EventType.CHILD_ADDED;
        if (eventType == eventType2 || eventType == Event.EventType.CHILD_CHANGED || eventType == Event.EventType.CHILD_REMOVED) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utilities.hardAssert(z10, "Only child changes supported for tracking");
        Utilities.hardAssert(true ^ change.getChildKey().isPriorityChildName());
        if (this.changeMap.containsKey(childKey)) {
            Change change2 = this.changeMap.get(childKey);
            Event.EventType eventType3 = change2.getEventType();
            if (eventType == eventType2 && eventType3 == Event.EventType.CHILD_REMOVED) {
                this.changeMap.put(change.getChildKey(), Change.childChangedChange(childKey, change.getIndexedNode(), change2.getIndexedNode()));
                return;
            }
            Event.EventType eventType4 = Event.EventType.CHILD_REMOVED;
            if (eventType == eventType4 && eventType3 == eventType2) {
                this.changeMap.remove(childKey);
            } else if (eventType == eventType4 && eventType3 == Event.EventType.CHILD_CHANGED) {
                this.changeMap.put(childKey, Change.childRemovedChange(childKey, change2.getOldIndexedNode()));
            } else {
                Event.EventType eventType5 = Event.EventType.CHILD_CHANGED;
                if (eventType == eventType5 && eventType3 == eventType2) {
                    this.changeMap.put(childKey, Change.childAddedChange(childKey, change.getIndexedNode()));
                } else if (eventType == eventType5 && eventType3 == eventType5) {
                    this.changeMap.put(childKey, Change.childChangedChange(childKey, change.getIndexedNode(), change2.getOldIndexedNode()));
                } else {
                    throw new IllegalStateException("Illegal combination of changes: " + change + " occurred after " + change2);
                }
            }
        } else {
            this.changeMap.put(change.getChildKey(), change);
        }
    }
}
