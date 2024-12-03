package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import f4.j;
import i3.b;
import i3.e;
import i3.h;
import java.security.MessageDigest;
import java.util.Map;

class k implements b {

    /* renamed from: b  reason: collision with root package name */
    private final Object f9392b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9393c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9394d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f9395e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f9396f;

    /* renamed from: g  reason: collision with root package name */
    private final b f9397g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, h<?>> f9398h;

    /* renamed from: i  reason: collision with root package name */
    private final e f9399i;

    /* renamed from: j  reason: collision with root package name */
    private int f9400j;

    k(Object obj, b bVar, int i10, int i11, Map<Class<?>, h<?>> map, Class<?> cls, Class<?> cls2, e eVar) {
        this.f9392b = j.d(obj);
        this.f9397g = (b) j.e(bVar, "Signature must not be null");
        this.f9393c = i10;
        this.f9394d = i11;
        this.f9398h = (Map) j.d(map);
        this.f9395e = (Class) j.e(cls, "Resource class must not be null");
        this.f9396f = (Class) j.e(cls2, "Transcode class must not be null");
        this.f9399i = (e) j.d(eVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!this.f9392b.equals(kVar.f9392b) || !this.f9397g.equals(kVar.f9397g) || this.f9394d != kVar.f9394d || this.f9393c != kVar.f9393c || !this.f9398h.equals(kVar.f9398h) || !this.f9395e.equals(kVar.f9395e) || !this.f9396f.equals(kVar.f9396f) || !this.f9399i.equals(kVar.f9399i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f9400j == 0) {
            int hashCode = this.f9392b.hashCode();
            this.f9400j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f9397g.hashCode()) * 31) + this.f9393c) * 31) + this.f9394d;
            this.f9400j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f9398h.hashCode();
            this.f9400j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f9395e.hashCode();
            this.f9400j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f9396f.hashCode();
            this.f9400j = hashCode5;
            this.f9400j = (hashCode5 * 31) + this.f9399i.hashCode();
        }
        return this.f9400j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f9392b + ", width=" + this.f9393c + ", height=" + this.f9394d + ", resourceClass=" + this.f9395e + ", transcodeClass=" + this.f9396f + ", signature=" + this.f9397g + ", hashCode=" + this.f9400j + ", transformations=" + this.f9398h + ", options=" + this.f9399i + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
