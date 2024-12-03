package okhttp3;

import bl.d;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.t;
import okio.Buffer;
import okio.BufferedSink;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0002\n\tB%\b\u0000\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0016"}, d2 = {"Lokhttp3/r;", "Lokhttp3/z;", "Lokio/BufferedSink;", "sink", "", "countBytes", "", "j", "Lokhttp3/v;", "b", "a", "", "i", "", "", "Ljava/util/List;", "encodedNames", "c", "encodedValues", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "d", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class r extends z {

    /* renamed from: d  reason: collision with root package name */
    public static final b f33159d = new b((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private static final v f33160e = v.f33190e.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f33161b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f33162c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/r$b;", "", "Lokhttp3/v;", "CONTENT_TYPE", "Lokhttp3/v;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r(List<String> list, List<String> list2) {
        j.g(list, "encodedNames");
        j.g(list2, "encodedValues");
        this.f33161b = d.S(list);
        this.f33162c = d.S(list2);
    }

    private final long j(BufferedSink bufferedSink, boolean z10) {
        Buffer buffer;
        if (z10) {
            buffer = new Buffer();
        } else {
            j.d(bufferedSink);
            buffer = bufferedSink.d();
        }
        int i10 = 0;
        int size = this.f33161b.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                buffer.writeByte(38);
            }
            buffer.h0(this.f33161b.get(i10));
            buffer.writeByte(61);
            buffer.h0(this.f33162c.get(i10));
            i10 = i11;
        }
        if (!z10) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.a();
        return size2;
    }

    public long a() {
        return j((BufferedSink) null, true);
    }

    public v b() {
        return f33160e;
    }

    public void i(BufferedSink bufferedSink) throws IOException {
        j.g(bufferedSink, "sink");
        j(bufferedSink, false);
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u0012"}, d2 = {"Lokhttp3/r$a;", "", "", "name", "value", "a", "b", "Lokhttp3/r;", "c", "Ljava/nio/charset/Charset;", "Ljava/nio/charset/Charset;", "charset", "", "Ljava/util/List;", "names", "values", "<init>", "(Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Charset f33163a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f33164b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f33165c;

        public a() {
            this((Charset) null, 1, (DefaultConstructorMarker) null);
        }

        public a(Charset charset) {
            this.f33163a = charset;
            this.f33164b = new ArrayList();
            this.f33165c = new ArrayList();
        }

        public final a a(String str, String str2) {
            String str3 = str;
            j.g(str3, "name");
            j.g(str2, "value");
            List<String> list = this.f33164b;
            t.b bVar = t.f33169k;
            list.add(t.b.b(bVar, str3, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f33163a, 91, (Object) null));
            this.f33165c.add(t.b.b(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f33163a, 91, (Object) null));
            return this;
        }

        public final a b(String str, String str2) {
            String str3 = str;
            j.g(str3, "name");
            j.g(str2, "value");
            List<String> list = this.f33164b;
            t.b bVar = t.f33169k;
            list.add(t.b.b(bVar, str3, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f33163a, 83, (Object) null));
            this.f33165c.add(t.b.b(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f33163a, 83, (Object) null));
            return this;
        }

        public final r c() {
            return new r(this.f33164b, this.f33165c);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Charset charset, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }
}
