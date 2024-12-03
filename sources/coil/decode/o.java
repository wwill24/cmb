package coil.decode;

import coil.util.i;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\"\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lcoil/decode/d;", "Lokio/BufferedSource;", "source", "", "a", "Lokio/ByteString;", "Lokio/ByteString;", "SVG_TAG", "b", "LEFT_ANGLE_BRACKET", "coil-svg_release"}, k = 2, mv = {1, 7, 1})
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteString f8119a;

    /* renamed from: b  reason: collision with root package name */
    private static final ByteString f8120b;

    static {
        ByteString.Companion companion = ByteString.f33308c;
        f8119a = companion.c("<svg");
        f8120b = companion.c("<");
    }

    public static final boolean a(d dVar, BufferedSource bufferedSource) {
        if (bufferedSource.j0(0, f8120b)) {
            if (i.a(bufferedSource, f8119a, 0, 1024) != -1) {
                return true;
            }
        }
        return false;
    }
}
