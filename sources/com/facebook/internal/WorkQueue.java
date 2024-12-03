package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\bR\u00020\u0000H\u0002J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/internal/WorkQueue;", "", "maxConcurrent", "", "executor", "Ljava/util/concurrent/Executor;", "(ILjava/util/concurrent/Executor;)V", "pendingJobs", "Lcom/facebook/internal/WorkQueue$WorkNode;", "runningCount", "runningJobs", "workLock", "Ljava/util/concurrent/locks/ReentrantLock;", "addActiveWorkItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "addToFront", "", "execute", "", "node", "finishItemAndStartNew", "finished", "startItem", "validate", "Companion", "WorkItem", "WorkNode", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WorkQueue {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    /* access modifiers changed from: private */
    public WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    /* access modifiers changed from: private */
    public final ReentrantLock workLock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/WorkQueue$Companion;", "", "()V", "DEFAULT_MAX_CONCURRENT", "", "assert", "", "condition", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: assert  reason: not valid java name */
        public final void m134assert(boolean z10) {
            if (!z10) {
                throw new FacebookException("Validation failed");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkItem;", "", "isRunning", "", "()Z", "cancel", "moveToFront", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00060\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\f\u001a\b\u0018\u00010\u0000R\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0000R\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkNode;", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "(Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "getCallback", "()Ljava/lang/Runnable;", "isRunning", "", "()Z", "setRunning", "(Z)V", "<set-?>", "Lcom/facebook/internal/WorkQueue;", "next", "getNext", "()Lcom/facebook/internal/WorkQueue$WorkNode;", "prev", "addToList", "list", "addToFront", "cancel", "moveToFront", "", "removeFromList", "verify", "shouldBeRunning", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class WorkNode implements WorkItem {
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(WorkQueue workQueue, Runnable runnable) {
            j.g(workQueue, "this$0");
            j.g(runnable, "callback");
            this.this$0 = workQueue;
            this.callback = runnable;
        }

        public final WorkNode addToList(WorkNode workNode, boolean z10) {
            boolean z11;
            WorkNode workNode2;
            Companion companion = WorkQueue.Companion;
            boolean z12 = true;
            if (this.next == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            companion.m134assert(z11);
            if (this.prev != null) {
                z12 = false;
            }
            companion.m134assert(z12);
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                WorkNode workNode3 = workNode.prev;
                this.prev = workNode3;
                if (workNode3 != null) {
                    workNode3.next = this;
                }
                WorkNode workNode4 = this.next;
                if (workNode4 != null) {
                    if (workNode3 == null) {
                        workNode2 = null;
                    } else {
                        workNode2 = workNode3.next;
                    }
                    workNode4.prev = workNode2;
                }
            }
            if (z10) {
                return this;
            }
            return workNode;
        }

        public boolean cancel() {
            ReentrantLock access$getWorkLock$p = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            access$getWorkLock$p.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    return true;
                }
                Unit unit = Unit.f32013a;
                access$getWorkLock$p.unlock();
                return false;
            } finally {
                access$getWorkLock$p.unlock();
            }
        }

        public final Runnable getCallback() {
            return this.callback;
        }

        public final WorkNode getNext() {
            return this.next;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void moveToFront() {
            ReentrantLock access$getWorkLock$p = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            access$getWorkLock$p.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
                Unit unit = Unit.f32013a;
            } finally {
                access$getWorkLock$p.unlock();
            }
        }

        public final WorkNode removeFromList(WorkNode workNode) {
            boolean z10;
            Companion companion = WorkQueue.Companion;
            boolean z11 = true;
            if (this.next != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            companion.m134assert(z10);
            if (this.prev == null) {
                z11 = false;
            }
            companion.m134assert(z11);
            if (workNode == this && (workNode = this.next) == this) {
                workNode = null;
            }
            WorkNode workNode2 = this.next;
            if (workNode2 != null) {
                workNode2.prev = this.prev;
            }
            WorkNode workNode3 = this.prev;
            if (workNode3 != null) {
                workNode3.next = workNode2;
            }
            this.prev = null;
            this.next = null;
            return workNode;
        }

        public void setRunning(boolean z10) {
            this.isRunning = z10;
        }

        public final void verify(boolean z10) {
            WorkNode workNode;
            boolean z11;
            WorkNode workNode2;
            boolean z12;
            Companion companion = WorkQueue.Companion;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            boolean z13 = true;
            if (workNode == this) {
                z11 = true;
            } else {
                z11 = false;
            }
            companion.m134assert(z11);
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            if (workNode2 == this) {
                z12 = true;
            } else {
                z12 = false;
            }
            companion.m134assert(z12);
            if (isRunning() != z10) {
                z13 = false;
            }
            companion.m134assert(z13);
        }
    }

    public WorkQueue() {
        this(0, (Executor) null, 3, (DefaultConstructorMarker) null);
    }

    public WorkQueue(int i10) {
        this(i10, (Executor) null, 2, (DefaultConstructorMarker) null);
    }

    public WorkQueue(int i10, Executor executor2) {
        j.g(executor2, "executor");
        this.maxConcurrent = i10;
        this.executor = executor2;
        this.workLock = new ReentrantLock();
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return workQueue.addActiveWorkItem(runnable, z10);
    }

    private final void execute(WorkNode workNode) {
        this.executor.execute(new w(workNode, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-2  reason: not valid java name */
    public static final void m133execute$lambda2(WorkNode workNode, WorkQueue workQueue) {
        j.g(workNode, "$node");
        j.g(workQueue, "this$0");
        try {
            workNode.getCallback().run();
        } finally {
            workQueue.finishItemAndStartNew(workNode);
        }
    }

    private final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setRunning(true);
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void startItem() {
        finishItemAndStartNew((WorkNode) null);
    }

    public final WorkItem addActiveWorkItem(Runnable runnable) {
        j.g(runnable, "callback");
        return addActiveWorkItem$default(this, runnable, false, 2, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public final WorkItem addActiveWorkItem(Runnable runnable, boolean z10) {
        j.g(runnable, "callback");
        WorkNode workNode = new WorkNode(this, runnable);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z10);
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final void validate() {
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            WorkNode workNode = this.runningJobs;
            boolean z10 = false;
            int i10 = 0;
            if (workNode != null) {
                while (workNode != null) {
                    workNode.verify(true);
                    i10++;
                    workNode = workNode.getNext();
                    if (workNode == this.runningJobs) {
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            Companion companion = Companion;
            if (this.runningCount == i10) {
                z10 = true;
            }
            companion.m134assert(z10);
            Unit unit = Unit.f32013a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkQueue(int i10, Executor executor2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 8 : i10, (i11 & 2) != 0 ? FacebookSdk.getExecutor() : executor2);
    }
}
