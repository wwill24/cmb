package com.uber.autodispose;

import qj.f;
import qj.h;
import qj.q;
import qj.w;

public final class a {

    /* renamed from: com.uber.autodispose.a$a  reason: collision with other inner class name */
    class C0268a implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f23302a;

        /* renamed from: com.uber.autodispose.a$a$a  reason: collision with other inner class name */
        class C0269a implements m {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ qj.a f23303a;

            C0269a(qj.a aVar) {
                this.f23303a = aVar;
            }

            public tj.b d() {
                return new c(this.f23303a, C0268a.this.f23302a).d();
            }

            public void e(qj.d dVar) {
                new c(this.f23303a, C0268a.this.f23302a).e(dVar);
            }

            public tj.b f(vj.a aVar, vj.f<? super Throwable> fVar) {
                return new c(this.f23303a, C0268a.this.f23302a).f(aVar, fVar);
            }

            public tj.b g(vj.a aVar) {
                return new c(this.f23303a, C0268a.this.f23302a).g(aVar);
            }
        }

        /* renamed from: com.uber.autodispose.a$a$b */
        class b implements n<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f23305a;

            b(h hVar) {
                this.f23305a = hVar;
            }

            public tj.b b(vj.f<? super T> fVar, vj.f<? super Throwable> fVar2) {
                return new f(this.f23305a, C0268a.this.f23302a).b(fVar, fVar2);
            }

            public tj.b c(vj.f<? super T> fVar) {
                return new f(this.f23305a, C0268a.this.f23302a).c(fVar);
            }
        }

        /* renamed from: com.uber.autodispose.a$a$c */
        class c implements p<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ q f23307a;

            c(q qVar) {
                this.f23307a = qVar;
            }

            public tj.b b(vj.f<? super T> fVar, vj.f<? super Throwable> fVar2) {
                return new g(this.f23307a, C0268a.this.f23302a).b(fVar, fVar2);
            }

            public tj.b c(vj.f<? super T> fVar) {
                return new g(this.f23307a, C0268a.this.f23302a).c(fVar);
            }
        }

        /* renamed from: com.uber.autodispose.a$a$d */
        class d implements t<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ w f23309a;

            d(w wVar) {
                this.f23309a = wVar;
            }

            public tj.b b(vj.f<? super T> fVar, vj.f<? super Throwable> fVar2) {
                return new i(this.f23309a, C0268a.this.f23302a).b(fVar, fVar2);
            }

            public tj.b c(vj.f<? super T> fVar) {
                return new i(this.f23309a, C0268a.this.f23302a).c(fVar);
            }

            public tj.b d() {
                return new i(this.f23309a, C0268a.this.f23302a).d();
            }

            public tj.b e(vj.b<? super T, ? super Throwable> bVar) {
                return new i(this.f23309a, C0268a.this.f23302a).e(bVar);
            }
        }

        C0268a(f fVar) {
            this.f23302a = fVar;
        }

        /* renamed from: e */
        public m b(qj.a aVar) {
            if (!h.f23330c) {
                return new c(aVar, this.f23302a);
            }
            return new C0269a(aVar);
        }

        /* renamed from: f */
        public n<T> c(h<T> hVar) {
            if (!h.f23330c) {
                return new f(hVar, this.f23302a);
            }
            return new b(hVar);
        }

        /* renamed from: g */
        public p<T> a(q<T> qVar) {
            if (!h.f23330c) {
                return new g(qVar, this.f23302a);
            }
            return new c(qVar);
        }

        /* renamed from: h */
        public t<T> d(w<T> wVar) {
            if (!h.f23330c) {
                return new i(wVar, this.f23302a);
            }
            return new d(wVar);
        }
    }

    public static <T> d<T> a(q qVar) {
        j.a(qVar, "provider == null");
        return b(s.b(qVar));
    }

    public static <T> d<T> b(f fVar) {
        j.a(fVar, "scope == null");
        return new C0268a(fVar);
    }
}
