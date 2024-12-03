package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/squareup/workflow1/ui/q;", "", "T", "other", "", "equals", "", "hashCode", "", "toString", "Lwk/c;", "a", "Lwk/c;", "type", "()Ljava/lang/Object;", "default", "<init>", "(Lwk/c;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public abstract class q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f23292a;

    public q(c<T> cVar) {
        j.g(cVar, "type");
        this.f23292a = cVar;
    }

    public abstract T a();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && !j.b(l.b(getClass()), l.b(obj.getClass()))) {
            return false;
        }
        c<T> cVar = this.f23292a;
        if (obj != null) {
            return j.b(cVar, ((q) obj).f23292a);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.squareup.workflow1.ui.ViewEnvironmentKey<*>");
    }

    public final int hashCode() {
        return this.f23292a.hashCode();
    }

    public String toString() {
        return "ViewEnvironmentKey(" + this.f23292a + ")-" + super.toString();
    }
}
