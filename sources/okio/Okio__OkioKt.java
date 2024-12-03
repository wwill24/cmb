package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokio/Source;", "Lokio/BufferedSource;", "c", "Lokio/Sink;", "Lokio/BufferedSink;", "b", "a", "()Lokio/Sink;", "okio"}, k = 5, mv = {1, 6, 0}, xs = "okio/Okio")
final /* synthetic */ class Okio__OkioKt {
    public static final Sink a() {
        return new BlackholeSink();
    }

    public static final BufferedSink b(Sink sink) {
        j.g(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    public static final BufferedSource c(Source source) {
        j.g(source, "<this>");
        return new RealBufferedSource(source);
    }
}
