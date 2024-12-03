package fl;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.b0;
import okhttp3.v;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lfl/h;", "Lokhttp3/b0;", "", "contentLength", "Lokhttp3/v;", "contentType", "Lokio/BufferedSource;", "source", "", "a", "Ljava/lang/String;", "contentTypeString", "b", "J", "c", "Lokio/BufferedSource;", "<init>", "(Ljava/lang/String;JLokio/BufferedSource;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h extends b0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f29671a;

    /* renamed from: b  reason: collision with root package name */
    private final long f29672b;

    /* renamed from: c  reason: collision with root package name */
    private final BufferedSource f29673c;

    public h(String str, long j10, BufferedSource bufferedSource) {
        j.g(bufferedSource, "source");
        this.f29671a = str;
        this.f29672b = j10;
        this.f29673c = bufferedSource;
    }

    public long contentLength() {
        return this.f29672b;
    }

    public v contentType() {
        String str = this.f29671a;
        if (str == null) {
            return null;
        }
        return v.f33190e.b(str);
    }

    public BufferedSource source() {
        return this.f29673c;
    }
}
