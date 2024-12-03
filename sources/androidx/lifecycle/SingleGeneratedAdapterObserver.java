package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.j;

public final class SingleGeneratedAdapterObserver implements i {

    /* renamed from: a  reason: collision with root package name */
    private final e f5985a;

    public SingleGeneratedAdapterObserver(e eVar) {
        j.g(eVar, "generatedAdapter");
        this.f5985a = eVar;
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        this.f5985a.a(lVar, event, false, (s) null);
        this.f5985a.a(lVar, event, true, (s) null);
    }
}
