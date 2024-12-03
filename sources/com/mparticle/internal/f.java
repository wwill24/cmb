package com.mparticle.internal;

import androidx.annotation.NonNull;
import com.mparticle.internal.g;
import java.io.IOException;
import org.json.JSONException;
import org.json.b;

public interface f {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f22462a;

        /* renamed from: b  reason: collision with root package name */
        private String f22463b;

        public a(int i10) {
            this(i10, (String) null);
        }

        public String a() {
            return this.f22463b;
        }

        public int b() {
            return this.f22462a;
        }

        a(int i10, String str) {
            this.f22462a = i10;
            this.f22463b = str;
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            this.f22463b = str;
        }
    }

    int a(String str) throws IOException, g.d, g.c;

    b a();

    void a(boolean z10) throws IOException, g.a;

    @NonNull
    a b(@NonNull String str) throws JSONException, IOException, g.d, g.c;

    void b() throws IOException, g.a;
}
