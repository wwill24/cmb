package ij;

import androidx.annotation.NonNull;
import ij.l;

abstract class m {

    class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l.b f30000a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f30001b;

        a(l.b bVar, g gVar) {
            this.f30000a = bVar;
            this.f30001b = gVar;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public l a() {
            return this.f30000a.a(this.f30001b, new r());
        }
    }

    m() {
    }

    @NonNull
    static m b(@NonNull l.b bVar, @NonNull g gVar) {
        return new a(bVar, gVar);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract l a();
}
