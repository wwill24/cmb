package com.google.firebase.database.core;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;

public class ChildEventRegistration extends EventRegistration {
    private final ChildEventListener eventListener;
    private final Repo repo;
    private final QuerySpec spec;

    /* renamed from: com.google.firebase.database.core.ChildEventRegistration$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$core$view$Event$EventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.firebase.database.core.view.Event$EventType[] r0 = com.google.firebase.database.core.view.Event.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$database$core$view$Event$EventType = r0
                com.google.firebase.database.core.view.Event$EventType r1 = com.google.firebase.database.core.view.Event.EventType.CHILD_ADDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$database$core$view$Event$EventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.database.core.view.Event$EventType r1 = com.google.firebase.database.core.view.Event.EventType.CHILD_CHANGED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$database$core$view$Event$EventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.database.core.view.Event$EventType r1 = com.google.firebase.database.core.view.Event.EventType.CHILD_MOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$firebase$database$core$view$Event$EventType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.firebase.database.core.view.Event$EventType r1 = com.google.firebase.database.core.view.Event.EventType.CHILD_REMOVED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.ChildEventRegistration.AnonymousClass1.<clinit>():void");
        }
    }

    public ChildEventRegistration(@NotNull Repo repo2, @NotNull ChildEventListener childEventListener, @NotNull QuerySpec querySpec) {
        this.repo = repo2;
        this.eventListener = childEventListener;
        this.spec = querySpec;
    }

    public EventRegistration clone(QuerySpec querySpec) {
        return new ChildEventRegistration(this.repo, this.eventListener, querySpec);
    }

    public DataEvent createEvent(Change change, QuerySpec querySpec) {
        String str;
        DataSnapshot createDataSnapshot = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this.repo, querySpec.getPath().child(change.getChildKey())), change.getIndexedNode());
        if (change.getPrevName() != null) {
            str = change.getPrevName().asString();
        } else {
            str = null;
        }
        return new DataEvent(change.getEventType(), this, createDataSnapshot, str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChildEventRegistration) {
            ChildEventRegistration childEventRegistration = (ChildEventRegistration) obj;
            if (!childEventRegistration.eventListener.equals(this.eventListener) || !childEventRegistration.repo.equals(this.repo) || !childEventRegistration.spec.equals(this.spec)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void fireCancelEvent(DatabaseError databaseError) {
        this.eventListener.onCancelled(databaseError);
    }

    public void fireEvent(DataEvent dataEvent) {
        if (!isZombied()) {
            int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$database$core$view$Event$EventType[dataEvent.getEventType().ordinal()];
            if (i10 == 1) {
                this.eventListener.onChildAdded(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            } else if (i10 == 2) {
                this.eventListener.onChildChanged(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            } else if (i10 == 3) {
                this.eventListener.onChildMoved(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            } else if (i10 == 4) {
                this.eventListener.onChildRemoved(dataEvent.getSnapshot());
            }
        }
    }

    @NotNull
    public QuerySpec getQuerySpec() {
        return this.spec;
    }

    /* access modifiers changed from: package-private */
    public Repo getRepo() {
        return this.repo;
    }

    public int hashCode() {
        return (((this.eventListener.hashCode() * 31) + this.repo.hashCode()) * 31) + this.spec.hashCode();
    }

    public boolean isSameListener(EventRegistration eventRegistration) {
        if (!(eventRegistration instanceof ChildEventRegistration) || !((ChildEventRegistration) eventRegistration).eventListener.equals(this.eventListener)) {
            return false;
        }
        return true;
    }

    public boolean respondsTo(Event.EventType eventType) {
        return eventType != Event.EventType.VALUE;
    }

    public String toString() {
        return "ChildEventRegistration";
    }
}
