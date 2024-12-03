package io.sentry.clientreport;

import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f31170a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31171b;

    c(String str, String str2) {
        this.f31170a = str;
        this.f31171b = str2;
    }

    public String a() {
        return this.f31171b;
    }

    public String b() {
        return this.f31170a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!l.a(b(), cVar.b()) || !l.a(a(), cVar.a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return l.b(b(), a());
    }
}
