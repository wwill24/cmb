package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.graphics.e;
import androidx.core.util.h;
import java.util.concurrent.Executor;

public class g {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f4676a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f4677b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f4676a = i10;
            this.f4677b = bVarArr;
        }

        static a a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] b() {
            return this.f4677b;
        }

        public int c() {
            return this.f4676a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f4678a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4679b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4680c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f4681d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4682e;

        @Deprecated
        public b(@NonNull Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f4678a = (Uri) h.g(uri);
            this.f4679b = i10;
            this.f4680c = i11;
            this.f4681d = z10;
            this.f4682e = i12;
        }

        static b a(@NonNull Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f4682e;
        }

        public int c() {
            return this.f4679b;
        }

        @NonNull
        public Uri d() {
            return this.f4678a;
        }

        public int e() {
            return this.f4680c;
        }

        public boolean f() {
            return this.f4681d;
        }
    }

    public static class c {
        public void a(int i10) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull b[] bVarArr) {
        return e.b(context, cancellationSignal, bVarArr, 0);
    }

    @NonNull
    public static a b(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull e eVar) throws PackageManager.NameNotFoundException {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(@NonNull Context context, @NonNull e eVar, int i10, boolean z10, int i11, @NonNull Handler handler, @NonNull c cVar) {
        a aVar = new a(cVar, handler);
        if (z10) {
            return f.e(context, eVar, aVar, i10, i11);
        }
        return f.d(context, eVar, i10, (Executor) null, aVar);
    }
}
