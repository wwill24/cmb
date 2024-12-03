package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import i3.b;
import java.security.MessageDigest;

final class c implements b {

    /* renamed from: b  reason: collision with root package name */
    private final b f9311b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9312c;

    c(b bVar, b bVar2) {
        this.f9311b = bVar;
        this.f9312c = bVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f9311b.equals(cVar.f9311b) || !this.f9312c.equals(cVar.f9312c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f9311b.hashCode() * 31) + this.f9312c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f9311b + ", signature=" + this.f9312c + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9311b.updateDiskCacheKey(messageDigest);
        this.f9312c.updateDiskCacheKey(messageDigest);
    }
}
