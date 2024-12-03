package com.jakewharton.rxrelay2;

import qj.u;

final class d<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f22178a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22179b;

    /* renamed from: c  reason: collision with root package name */
    private a<T> f22180c;

    d(c<T> cVar) {
        this.f22178a = cVar;
    }

    private void B0() {
        a<T> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f22180c;
                if (aVar == null) {
                    this.f22179b = false;
                    return;
                }
                this.f22180c = null;
            }
            aVar.a(this.f22178a);
        }
        while (true) {
        }
    }

    public void accept(T t10) {
        synchronized (this) {
            if (this.f22179b) {
                a<T> aVar = this.f22180c;
                if (aVar == null) {
                    aVar = new a<>(4);
                    this.f22180c = aVar;
                }
                aVar.b(t10);
                return;
            }
            this.f22179b = true;
            this.f22178a.accept(t10);
            B0();
        }
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f22178a.e(uVar);
    }
}
