package androidx.activity.result;

import c.f;
import kotlin.jvm.internal.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private f.e f390a = f.b.f7902a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private f.e f391a = f.b.f7902a;

        public final e a() {
            e eVar = new e();
            eVar.b(this.f391a);
            return eVar;
        }

        public final a b(f.e eVar) {
            j.g(eVar, "mediaType");
            this.f391a = eVar;
            return this;
        }
    }

    public final f.e a() {
        return this.f390a;
    }

    public final void b(f.e eVar) {
        j.g(eVar, "<set-?>");
        this.f390a = eVar;
    }
}
