package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.j;

public final class CompositeGeneratedAdaptersObserver implements i {

    /* renamed from: a  reason: collision with root package name */
    private final e[] f5915a;

    public CompositeGeneratedAdaptersObserver(e[] eVarArr) {
        j.g(eVarArr, "generatedAdapters");
        this.f5915a = eVarArr;
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        s sVar = new s();
        for (e a10 : this.f5915a) {
            a10.a(lVar, event, false, sVar);
        }
        for (e a11 : this.f5915a) {
            a11.a(lVar, event, true, sVar);
        }
    }
}
