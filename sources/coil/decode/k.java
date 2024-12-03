package coil.decode;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0004¢\u0006\u0004\b\n\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcoil/decode/k;", "Ljava/io/Closeable;", "Lokio/BufferedSource;", "b", "Lcoil/decode/k$a;", "a", "()Lcoil/decode/k$a;", "getMetadata$annotations", "()V", "metadata", "<init>", "Lcoil/decode/j;", "Lcoil/decode/n;", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public abstract class k implements Closeable {

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcoil/decode/k$a;", "", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class a {
    }

    private k() {
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract a a();

    public abstract BufferedSource b();
}
