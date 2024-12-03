package hd;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import ed.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static final a f40894e = new C0497a().b();

    /* renamed from: a  reason: collision with root package name */
    private final e f40895a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f40896b;

    /* renamed from: c  reason: collision with root package name */
    private final b f40897c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40898d;

    /* renamed from: hd.a$a  reason: collision with other inner class name */
    public static final class C0497a {

        /* renamed from: a  reason: collision with root package name */
        private e f40899a = null;

        /* renamed from: b  reason: collision with root package name */
        private List<c> f40900b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private b f40901c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f40902d = "";

        C0497a() {
        }

        public C0497a a(c cVar) {
            this.f40900b.add(cVar);
            return this;
        }

        public a b() {
            return new a(this.f40899a, Collections.unmodifiableList(this.f40900b), this.f40901c, this.f40902d);
        }

        public C0497a c(String str) {
            this.f40902d = str;
            return this;
        }

        public C0497a d(b bVar) {
            this.f40901c = bVar;
            return this;
        }

        public C0497a e(e eVar) {
            this.f40899a = eVar;
            return this;
        }
    }

    a(e eVar, List<c> list, b bVar, String str) {
        this.f40895a = eVar;
        this.f40896b = list;
        this.f40897c = bVar;
        this.f40898d = str;
    }

    public static C0497a e() {
        return new C0497a();
    }

    @Protobuf(tag = 4)
    public String a() {
        return this.f40898d;
    }

    @Protobuf(tag = 3)
    @Encodable.Field(name = "globalMetrics")
    public b b() {
        return this.f40897c;
    }

    @Protobuf(tag = 2)
    @Encodable.Field(name = "logSourceMetrics")
    public List<c> c() {
        return this.f40896b;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "window")
    public e d() {
        return this.f40895a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
