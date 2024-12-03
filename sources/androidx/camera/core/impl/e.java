package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

final class e<T> extends Config.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f2504a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f2505b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f2506c;

    e(String str, Class<T> cls, Object obj) {
        if (str != null) {
            this.f2504a = str;
            if (cls != null) {
                this.f2505b = cls;
                this.f2506c = obj;
                return;
            }
            throw new NullPointerException("Null valueClass");
        }
        throw new NullPointerException("Null id");
    }

    @NonNull
    public String c() {
        return this.f2504a;
    }

    public Object d() {
        return this.f2506c;
    }

    @NonNull
    public Class<T> e() {
        return this.f2505b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config.a)) {
            return false;
        }
        Config.a aVar = (Config.a) obj;
        if (this.f2504a.equals(aVar.c()) && this.f2505b.equals(aVar.e())) {
            Object obj2 = this.f2506c;
            if (obj2 == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (obj2.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((this.f2504a.hashCode() ^ 1000003) * 1000003) ^ this.f2505b.hashCode()) * 1000003;
        Object obj = this.f2506c;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Option{id=" + this.f2504a + ", valueClass=" + this.f2505b + ", token=" + this.f2506c + "}";
    }
}
