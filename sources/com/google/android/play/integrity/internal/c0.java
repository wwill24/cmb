package com.google.android.play.integrity.internal;

public final class c0 implements d {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f20512c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile d f20513a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f20514b = f20512c;

    private c0(d dVar) {
        this.f20513a = dVar;
    }

    public static d b(d dVar) {
        dVar.getClass();
        if (dVar instanceof c0) {
            return dVar;
        }
        return new c0(dVar);
    }

    public final Object a() {
        Object obj = this.f20514b;
        Object obj2 = f20512c;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f20514b;
                if (obj == obj2) {
                    obj = this.f20513a.a();
                    Object obj3 = this.f20514b;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.f20514b = obj;
                    this.f20513a = null;
                }
            }
        }
        return obj;
    }
}
