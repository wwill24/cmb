package hd;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static final c f40906c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f40907a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogEventDropped> f40908b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f40909a = "";

        /* renamed from: b  reason: collision with root package name */
        private List<LogEventDropped> f40910b = new ArrayList();

        a() {
        }

        public c a() {
            return new c(this.f40909a, Collections.unmodifiableList(this.f40910b));
        }

        public a b(List<LogEventDropped> list) {
            this.f40910b = list;
            return this;
        }

        public a c(String str) {
            this.f40909a = str;
            return this;
        }
    }

    c(String str, List<LogEventDropped> list) {
        this.f40907a = str;
        this.f40908b = list;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 2)
    @Encodable.Field(name = "logEventDropped")
    public List<LogEventDropped> a() {
        return this.f40908b;
    }

    @Protobuf(tag = 1)
    public String b() {
        return this.f40907a;
    }
}
