package com.mparticle;

import com.mparticle.g0;
import com.mparticle.internal.MPUtility;
import java.util.Arrays;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private long f22303a;

    /* renamed from: b  reason: collision with root package name */
    private String f22304b;

    /* renamed from: c  reason: collision with root package name */
    private String f22305c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f22306d;

    public e(g0.b bVar) {
        this.f22303a = bVar.e();
        this.f22304b = bVar.f();
        this.f22305c = bVar.a();
        this.f22306d = bVar.b();
    }

    private Object[] a() {
        return new Object[]{Long.valueOf(this.f22303a), this.f22304b, this.f22305c, this.f22306d};
    }

    public String b() {
        return this.f22305c;
    }

    public Integer c() {
        return this.f22306d;
    }

    public long d() {
        return this.f22303a;
    }

    public String e() {
        return this.f22304b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        for (int i10 = 0; i10 < a().length; i10++) {
            if (!MPUtility.isEqual(a()[i10], eVar.a()[i10])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(a());
    }
}
