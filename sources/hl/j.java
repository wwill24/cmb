package hl;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.http2.ErrorCode;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0014"}, d2 = {"Lhl/j;", "", "", "streamId", "", "Lhl/a;", "requestHeaders", "", "b", "responseHeaders", "last", "c", "Lokio/BufferedSource;", "source", "byteCount", "d", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29940a = a.f29942a;

    /* renamed from: b  reason: collision with root package name */
    public static final j f29941b = new a.C0349a();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lhl/j$a;", "", "Lhl/j;", "CANCEL", "Lhl/j;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f29942a = new a();

        @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lhl/j$a$a;", "Lhl/j;", "", "streamId", "", "Lhl/a;", "requestHeaders", "", "b", "responseHeaders", "last", "c", "Lokio/BufferedSource;", "source", "byteCount", "d", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: hl.j$a$a  reason: collision with other inner class name */
        private static final class C0349a implements j {
            public void a(int i10, ErrorCode errorCode) {
                kotlin.jvm.internal.j.g(errorCode, "errorCode");
            }

            public boolean b(int i10, List<a> list) {
                kotlin.jvm.internal.j.g(list, "requestHeaders");
                return true;
            }

            public boolean c(int i10, List<a> list, boolean z10) {
                kotlin.jvm.internal.j.g(list, "responseHeaders");
                return true;
            }

            public boolean d(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException {
                kotlin.jvm.internal.j.g(bufferedSource, "source");
                bufferedSource.skip((long) i11);
                return true;
            }
        }

        private a() {
        }
    }

    void a(int i10, ErrorCode errorCode);

    boolean b(int i10, List<a> list);

    boolean c(int i10, List<a> list, boolean z10);

    boolean d(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException;
}
