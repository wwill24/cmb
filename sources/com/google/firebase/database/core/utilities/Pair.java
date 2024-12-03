package com.google.firebase.database.core.utilities;

import com.mparticle.kits.AppsFlyerKit;

public final class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T t10, U u10) {
        this.first = t10;
        this.second = u10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        T t10 = this.first;
        if (t10 == null ? pair.first != null : !t10.equals(pair.first)) {
            return false;
        }
        U u10 = this.second;
        U u11 = pair.second;
        if (u10 == null ? u11 == null : u10.equals(u11)) {
            return true;
        }
        return false;
    }

    public T getFirst() {
        return this.first;
    }

    public U getSecond() {
        return this.second;
    }

    public int hashCode() {
        int i10;
        T t10 = this.first;
        int i11 = 0;
        if (t10 != null) {
            i10 = t10.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = i10 * 31;
        U u10 = this.second;
        if (u10 != null) {
            i11 = u10.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "Pair(" + this.first + AppsFlyerKit.COMMA + this.second + ")";
    }
}
