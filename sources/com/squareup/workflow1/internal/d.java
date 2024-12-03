package com.squareup.workflow1.internal;

import com.squareup.workflow1.internal.d.a;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003:\u0001\bB\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0005R$\u0010\r\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/squareup/workflow1/internal/d;", "Lcom/squareup/workflow1/internal/d$a;", "T", "", "node", "", "d", "(Lcom/squareup/workflow1/internal/d$a;)V", "a", "Lcom/squareup/workflow1/internal/d$a;", "b", "()Lcom/squareup/workflow1/internal/d$a;", "e", "head", "c", "f", "tail", "<init>", "()V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class d<T extends a<T>> {

    /* renamed from: a  reason: collision with root package name */
    private T f23122a;

    /* renamed from: b  reason: collision with root package name */
    private T f23123b;

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u000e\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u00020\u0002R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u00018&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/squareup/workflow1/internal/d$a;", "T", "", "a", "()Lcom/squareup/workflow1/internal/d$a;", "b", "(Lcom/squareup/workflow1/internal/d$a;)V", "nextListNode", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
    public interface a<T extends a<T>> {
        T a();

        void b(T t10);
    }

    public final void a() {
        this.f23122a = null;
        this.f23123b = null;
    }

    public final T b() {
        return this.f23122a;
    }

    public final T c() {
        return this.f23123b;
    }

    public final void d(T t10) {
        boolean z10;
        j.g(t10, NodeElement.ELEMENT);
        boolean z11 = true;
        if (t10.a() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            T t11 = this.f23123b;
            if (t11 == null) {
                if (this.f23122a != null) {
                    z11 = false;
                }
                if (z11) {
                    this.f23122a = t10;
                    this.f23123b = t10;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            f(t10);
            t11.b(t10);
            return;
        }
        throw new IllegalArgumentException("Expected node to not be linked.".toString());
    }

    public final void e(T t10) {
        this.f23122a = t10;
    }

    public final void f(T t10) {
        this.f23123b = t10;
    }
}
