package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import f4.g;
import f4.k;
import i3.b;
import i3.e;
import i3.h;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class r implements b {

    /* renamed from: j  reason: collision with root package name */
    private static final g<Class<?>, byte[]> f9429j = new g<>(50);

    /* renamed from: b  reason: collision with root package name */
    private final m3.b f9430b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9431c;

    /* renamed from: d  reason: collision with root package name */
    private final b f9432d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9433e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9434f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f9435g;

    /* renamed from: h  reason: collision with root package name */
    private final e f9436h;

    /* renamed from: i  reason: collision with root package name */
    private final h<?> f9437i;

    r(m3.b bVar, b bVar2, b bVar3, int i10, int i11, h<?> hVar, Class<?> cls, e eVar) {
        this.f9430b = bVar;
        this.f9431c = bVar2;
        this.f9432d = bVar3;
        this.f9433e = i10;
        this.f9434f = i11;
        this.f9437i = hVar;
        this.f9435g = cls;
        this.f9436h = eVar;
    }

    private byte[] a() {
        g<Class<?>, byte[]> gVar = f9429j;
        byte[] g10 = gVar.g(this.f9435g);
        if (g10 != null) {
            return g10;
        }
        byte[] bytes = this.f9435g.getName().getBytes(b.f15458a);
        gVar.k(this.f9435g, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f9434f != rVar.f9434f || this.f9433e != rVar.f9433e || !k.c(this.f9437i, rVar.f9437i) || !this.f9435g.equals(rVar.f9435g) || !this.f9431c.equals(rVar.f9431c) || !this.f9432d.equals(rVar.f9432d) || !this.f9436h.equals(rVar.f9436h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f9431c.hashCode() * 31) + this.f9432d.hashCode()) * 31) + this.f9433e) * 31) + this.f9434f;
        h<?> hVar = this.f9437i;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f9435g.hashCode()) * 31) + this.f9436h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f9431c + ", signature=" + this.f9432d + ", width=" + this.f9433e + ", height=" + this.f9434f + ", decodedResourceClass=" + this.f9435g + ", transformation='" + this.f9437i + '\'' + ", options=" + this.f9436h + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f9430b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f9433e).putInt(this.f9434f).array();
        this.f9432d.updateDiskCacheKey(messageDigest);
        this.f9431c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        h<?> hVar = this.f9437i;
        if (hVar != null) {
            hVar.updateDiskCacheKey(messageDigest);
        }
        this.f9436h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f9430b.put(bArr);
    }
}
