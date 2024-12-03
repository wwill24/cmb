package org.jivesoftware.smack;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.util.Async;

public class ScheduledAction implements Delayed {
    private final Runnable action;
    final Kind kind;
    final Date releaseTime;
    final SmackReactor smackReactor;

    /* renamed from: org.jivesoftware.smack.ScheduledAction$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.ScheduledAction$Kind[] r0 = org.jivesoftware.smack.ScheduledAction.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind = r0
                org.jivesoftware.smack.ScheduledAction$Kind r1 = org.jivesoftware.smack.ScheduledAction.Kind.NonBlocking     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.ScheduledAction$Kind r1 = org.jivesoftware.smack.ScheduledAction.Kind.Blocking     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.ScheduledAction.AnonymousClass1.<clinit>():void");
        }
    }

    enum Kind {
        NonBlocking,
        Blocking
    }

    ScheduledAction(Runnable runnable, Date date, SmackReactor smackReactor2, Kind kind2) {
        this.action = runnable;
        this.releaseTime = date;
        this.smackReactor = smackReactor2;
        this.kind = kind2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$run$0() {
        this.action.run();
    }

    public boolean cancel() {
        return this.smackReactor.cancel(this);
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(getTimeToDueMillis(), TimeUnit.MILLISECONDS);
    }

    public long getTimeToDueMillis() {
        return this.releaseTime.getTime() - System.currentTimeMillis();
    }

    public boolean isDue() {
        return new Date().after(this.releaseTime);
    }

    /* access modifiers changed from: package-private */
    public void run() {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind[this.kind.ordinal()];
        if (i10 == 1) {
            this.action.run();
        } else if (i10 == 2) {
            Async.go(new l(this));
        }
    }

    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
    }
}
