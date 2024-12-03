package com.mparticle;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.MalformedURLException;

public abstract class b0 {

    /* renamed from: b  reason: collision with root package name */
    private static a f22270b;

    /* renamed from: a  reason: collision with root package name */
    private b0 f22271a;

    interface a {
        b0 a(String str);
    }

    public static b0 a(String str, b0 b0Var) throws MalformedURLException {
        a aVar = f22270b;
        if (aVar != null) {
            try {
                return aVar.a(str).a(b0Var);
            } catch (Exception unused) {
            }
        }
        return new c0(str).a(b0Var);
    }

    public abstract String b();

    public abstract u c() throws IOException;

    public abstract String toString();

    @NonNull
    public b0 a() {
        b0 b0Var = this.f22271a;
        return b0Var != null ? b0Var : this;
    }

    /* access modifiers changed from: package-private */
    public b0 a(b0 b0Var) {
        this.f22271a = b0Var;
        return this;
    }
}
