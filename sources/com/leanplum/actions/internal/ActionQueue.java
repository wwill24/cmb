package com.leanplum.actions.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0005J\u0014\u0010\u0011\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0005J\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/leanplum/actions/internal/ActionQueue;", "", "()V", "queue", "", "Lcom/leanplum/actions/internal/Action;", "getQueue", "()Ljava/util/List;", "setQueue", "(Ljava/util/List;)V", "empty", "", "first", "last", "pop", "popAll", "", "pushBack", "action", "", "actions", "pushFront", "remove", "item", "toString", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class ActionQueue {
    private volatile List<Action> queue = new ArrayList();

    public final synchronized boolean empty() {
        return this.queue.isEmpty();
    }

    public final synchronized Action first() {
        return this.queue.isEmpty() ^ true ? (Action) CollectionsKt___CollectionsKt.N(this.queue) : null;
    }

    public final List<Action> getQueue() {
        return this.queue;
    }

    public final synchronized Action last() {
        return this.queue.isEmpty() ^ true ? (Action) CollectionsKt___CollectionsKt.Y(this.queue) : null;
    }

    public final synchronized Action pop() {
        return this.queue.isEmpty() ^ true ? this.queue.remove(0) : null;
    }

    public final synchronized List<Action> popAll() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        while (!this.queue.isEmpty()) {
            Action pop = pop();
            if (pop != null) {
                arrayList.add(pop);
            }
        }
        return arrayList;
    }

    public final synchronized boolean pushBack(Action action) {
        j.g(action, "action");
        return this.queue.add(action);
    }

    public final synchronized void pushFront(Action action) {
        j.g(action, "action");
        this.queue.add(0, action);
    }

    public final synchronized boolean remove(Action action) {
        j.g(action, "item");
        return this.queue.remove(action);
    }

    public final void setQueue(List<Action> list) {
        j.g(list, "<set-?>");
        this.queue = list;
    }

    public synchronized String toString() {
        return this.queue.toString();
    }

    public final synchronized void pushBack(List<Action> list) {
        j.g(list, "actions");
        for (Action pushBack : list) {
            pushBack(pushBack);
        }
    }

    public final synchronized void pushFront(List<Action> list) {
        j.g(list, "actions");
        for (Action pushFront : CollectionsKt___CollectionsKt.k0(list)) {
            pushFront(pushFront);
        }
    }
}
