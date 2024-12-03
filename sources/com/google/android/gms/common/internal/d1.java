package com.google.android.gms.common.internal;

public abstract class d1 {

    /* renamed from: a  reason: collision with root package name */
    private Object f38973a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38974b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f38975c;

    public d1(d dVar, Object obj) {
        this.f38975c = dVar;
        this.f38973a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.f38973a;
            if (this.f38974b) {
                String obj2 = toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Callback proxy ");
                sb2.append(obj2);
                sb2.append(" being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e10) {
                throw e10;
            }
        }
        synchronized (this) {
            this.f38974b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f38973a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f38975c.zzt) {
            this.f38975c.zzt.remove(this);
        }
    }
}
