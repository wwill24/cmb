package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.text.d;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0000*\n\u0010\u0005\"\u00020\u00042\u00020\u0004*\n\u0010\u0007\"\u00020\u00062\u00020\u0006*\n\u0010\t\"\u00020\b2\u00020\b*\n\u0010\u000b\"\u00020\n2\u00020\n*\n\u0010\r\"\u00020\f2\u00020\f*\n\u0010\u000f\"\u00020\u000e2\u00020\u000e¨\u0006\u0010"}, d2 = {"", "", "b", "a", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Ljava/io/Closeable;", "Closeable", "Ljava/io/EOFException;", "EOFException", "Ljava/io/FileNotFoundException;", "FileNotFoundException", "Ljava/io/IOException;", "IOException", "Ljava/net/ProtocolException;", "ProtocolException", "okio"}, k = 2, mv = {1, 6, 0})
public final class _JvmPlatformKt {
    public static final byte[] a(String str) {
        j.g(str, "<this>");
        byte[] bytes = str.getBytes(d.f32216b);
        j.f(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        j.g(bArr, "<this>");
        return new String(bArr, d.f32216b);
    }
}
