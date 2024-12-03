package mg;

import com.google.gson.d;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class m<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    private final o<T> f23722a;

    /* renamed from: b  reason: collision with root package name */
    private final i<T> f23723b;

    /* renamed from: c  reason: collision with root package name */
    final d f23724c;

    /* renamed from: d  reason: collision with root package name */
    private final qg.a<T> f23725d;

    /* renamed from: e  reason: collision with root package name */
    private final r f23726e;

    /* renamed from: f  reason: collision with root package name */
    private final m<T>.defpackage.b f23727f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f23728g;

    /* renamed from: h  reason: collision with root package name */
    private volatile q<T> f23729h;

    private final class b implements n, h {
        private b() {
        }
    }

    public m(o<T> oVar, i<T> iVar, d dVar, qg.a<T> aVar, r rVar, boolean z10) {
        this.f23722a = oVar;
        this.f23723b = iVar;
        this.f23724c = dVar;
        this.f23725d = aVar;
        this.f23726e = rVar;
        this.f23728g = z10;
    }

    private q<T> f() {
        q<T> qVar = this.f23729h;
        if (qVar != null) {
            return qVar;
        }
        q<T> p10 = this.f23724c.p(this.f23726e, this.f23725d);
        this.f23729h = p10;
        return p10;
    }

    public T b(JsonReader jsonReader) throws IOException {
        if (this.f23723b == null) {
            return f().b(jsonReader);
        }
        j a10 = com.google.gson.internal.j.a(jsonReader);
        if (!this.f23728g || !a10.i()) {
            return this.f23723b.a(a10, this.f23725d.d(), this.f23727f);
        }
        return null;
    }

    public void d(JsonWriter jsonWriter, T t10) throws IOException {
        o<T> oVar = this.f23722a;
        if (oVar == null) {
            f().d(jsonWriter, t10);
        } else if (!this.f23728g || t10 != null) {
            com.google.gson.internal.j.b(oVar.a(t10, this.f23725d.d(), this.f23727f), jsonWriter);
        } else {
            jsonWriter.nullValue();
        }
    }

    public q<T> e() {
        return this.f23722a != null ? this : f();
    }
}
