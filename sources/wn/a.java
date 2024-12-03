package wn;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

final class a extends k {

    /* renamed from: c  reason: collision with root package name */
    public static final C0520a f42484c = new C0520a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final j f42485b;

    /* renamed from: wn.a$a  reason: collision with other inner class name */
    public static final class C0520a {
        private C0520a() {
        }

        public /* synthetic */ C0520a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(j jVar) {
        super((DefaultConstructorMarker) null);
        j.g(jVar, "replaceData");
        this.f42485b = jVar;
    }

    public j a() {
        return this.f42485b;
    }

    /* renamed from: c */
    public String invoke() {
        return r.D(a().c(), a().b(), a().a(), false, 4, (Object) null);
    }
}
