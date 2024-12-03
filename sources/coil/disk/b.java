package coil.disk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcoil/disk/b;", "Lokio/ForwardingSink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "Lkotlin/Function1;", "Ljava/io/IOException;", "Lokio/IOException;", "b", "Lkotlin/jvm/functions/Function1;", "onException", "", "c", "Z", "hasErrors", "Lokio/Sink;", "delegate", "<init>", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class b extends ForwardingSink {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<IOException, Unit> f8164b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8165c;

    public b(Sink sink, Function1<? super IOException, Unit> function1) {
        super(sink);
        this.f8164b = function1;
    }

    public void close() {
        try {
            super.close();
        } catch (IOException e10) {
            this.f8165c = true;
            this.f8164b.invoke(e10);
        }
    }

    public void flush() {
        try {
            super.flush();
        } catch (IOException e10) {
            this.f8165c = true;
            this.f8164b.invoke(e10);
        }
    }

    public void k0(Buffer buffer, long j10) {
        if (this.f8165c) {
            buffer.skip(j10);
            return;
        }
        try {
            super.k0(buffer, j10);
        } catch (IOException e10) {
            this.f8165c = true;
            this.f8164b.invoke(e10);
        }
    }
}
