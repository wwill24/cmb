package wn;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

final class c extends k {

    /* renamed from: b  reason: collision with root package name */
    private final j f42487b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42488c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(j jVar, int i10) {
        super((DefaultConstructorMarker) null);
        j.g(jVar, "replaceData");
        this.f42487b = jVar;
        this.f42488c = i10;
    }

    public j a() {
        return this.f42487b;
    }

    /* renamed from: c */
    public String invoke() {
        return l.b(a().c(), a().b(), a().a(), this.f42488c);
    }
}
