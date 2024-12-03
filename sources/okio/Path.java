package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.internal.g;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u000e\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00010B\u0011\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b.\u0010/J\u0018\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0000H\u0002J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u001a\u0010\u0019\u001a\u00020\u00158\u0000X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010&\u001a\u0004\u0018\u00010#8G¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b'\u0010\u0018R\u0011\u0010+\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010-\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b,\u0010\u001b¨\u00061"}, d2 = {"Lokio/Path;", "", "", "child", "k", "(Ljava/lang/String;)Lokio/Path;", "", "normalize", "l", "other", "j", "Ljava/io/File;", "toFile", "Ljava/nio/file/Path;", "o", "", "a", "", "equals", "hashCode", "toString", "Lokio/ByteString;", "Lokio/ByteString;", "b", "()Lokio/ByteString;", "bytes", "c", "()Lokio/Path;", "root", "", "d", "()Ljava/util/List;", "segmentsBytes", "isAbsolute", "()Z", "", "p", "()Ljava/lang/Character;", "volumeLetter", "h", "nameBytes", "e", "()Ljava/lang/String;", "name", "i", "parent", "<init>", "(Lokio/ByteString;)V", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class Path implements Comparable<Path> {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f33379b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f33380c;

    /* renamed from: a  reason: collision with root package name */
    private final ByteString f33381a;

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u0005*\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u0005*\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokio/Path$Companion;", "", "", "", "normalize", "Lokio/Path;", "b", "(Ljava/lang/String;Z)Lokio/Path;", "Ljava/io/File;", "a", "(Ljava/io/File;Z)Lokio/Path;", "Ljava/nio/file/Path;", "c", "(Ljava/nio/file/Path;Z)Lokio/Path;", "DIRECTORY_SEPARATOR", "Ljava/lang/String;", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path d(Companion companion, File file, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.a(file, z10);
        }

        public static /* synthetic */ Path e(Companion companion, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.b(str, z10);
        }

        public static /* synthetic */ Path f(Companion companion, java.nio.file.Path path, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.c(path, z10);
        }

        public final Path a(File file, boolean z10) {
            j.g(file, "<this>");
            String file2 = file.toString();
            j.f(file2, "toString()");
            return b(file2, z10);
        }

        public final Path b(String str, boolean z10) {
            j.g(str, "<this>");
            return g.k(str, z10);
        }

        @IgnoreJRERequirement
        public final Path c(java.nio.file.Path path, boolean z10) {
            j.g(path, "<this>");
            return b(path.toString(), z10);
        }
    }

    static {
        String str = File.separator;
        j.f(str, "separator");
        f33380c = str;
    }

    public Path(ByteString byteString) {
        j.g(byteString, "bytes");
        this.f33381a = byteString;
    }

    /* renamed from: a */
    public int compareTo(Path path) {
        j.g(path, "other");
        return b().compareTo(path.b());
    }

    public final ByteString b() {
        return this.f33381a;
    }

    public final Path c() {
        int h10 = g.o(this);
        if (h10 == -1) {
            return null;
        }
        return new Path(b().J(0, h10));
    }

    public final List<ByteString> d() {
        ArrayList arrayList = new ArrayList();
        int h10 = g.o(this);
        if (h10 == -1) {
            h10 = 0;
        } else if (h10 < b().H() && b().i(h10) == ((byte) 92)) {
            h10++;
        }
        int H = b().H();
        int i10 = h10;
        while (h10 < H) {
            if (b().i(h10) == ((byte) 47) || b().i(h10) == ((byte) 92)) {
                arrayList.add(b().J(i10, h10));
                i10 = h10 + 1;
            }
            h10++;
        }
        if (i10 < b().H()) {
            arrayList.add(b().J(i10, b().H()));
        }
        return arrayList;
    }

    public final String e() {
        return h().Q();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && j.b(((Path) obj).b(), b());
    }

    public final ByteString h() {
        int d10 = g.l(this);
        if (d10 != -1) {
            return ByteString.K(b(), d10 + 1, 0, 2, (Object) null);
        }
        if (p() == null || b().H() != 2) {
            return b();
        }
        return ByteString.f33309d;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final Path i() {
        Path path;
        if (j.b(b(), g.f33469d) || j.b(b(), g.f33466a) || j.b(b(), g.f33467b) || g.n(this)) {
            return null;
        }
        int d10 = g.l(this);
        if (d10 != 2 || p() == null) {
            if (d10 == 1 && b().I(g.f33467b)) {
                return null;
            }
            if (d10 != -1 || p() == null) {
                if (d10 == -1) {
                    return new Path(g.f33469d);
                }
                if (d10 != 0) {
                    return new Path(ByteString.K(b(), 0, d10, 1, (Object) null));
                }
                path = new Path(ByteString.K(b(), 0, 1, 1, (Object) null));
            } else if (b().H() == 2) {
                return null;
            } else {
                path = new Path(ByteString.K(b(), 0, 2, 1, (Object) null));
            }
        } else if (b().H() == 3) {
            return null;
        } else {
            path = new Path(ByteString.K(b(), 0, 3, 1, (Object) null));
        }
        return path;
    }

    public final boolean isAbsolute() {
        return g.o(this) != -1;
    }

    public final Path j(Path path) {
        j.g(path, "other");
        if (j.b(c(), path.c())) {
            List<ByteString> d10 = d();
            List<ByteString> d11 = path.d();
            int min = Math.min(d10.size(), d11.size());
            int i10 = 0;
            while (i10 < min && j.b(d10.get(i10), d11.get(i10))) {
                i10++;
            }
            boolean z10 = true;
            if (i10 == min && b().H() == path.b().H()) {
                return Companion.e(f33379b, ".", false, 1, (Object) null);
            }
            if (d11.subList(i10, d11.size()).indexOf(g.f33470e) != -1) {
                z10 = false;
            }
            if (z10) {
                Buffer buffer = new Buffer();
                ByteString f10 = g.m(path);
                if (f10 == null && (f10 = g.m(this)) == null) {
                    f10 = g.s(f33380c);
                }
                int size = d11.size();
                for (int i11 = i10; i11 < size; i11++) {
                    buffer.K1(g.f33470e);
                    buffer.K1(f10);
                }
                int size2 = d10.size();
                while (i10 < size2) {
                    buffer.K1(d10.get(i10));
                    buffer.K1(f10);
                    i10++;
                }
                return g.q(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
    }

    public final Path k(String str) {
        j.g(str, "child");
        return g.j(this, g.q(new Buffer().h0(str), false), false);
    }

    public final Path l(Path path, boolean z10) {
        j.g(path, "child");
        return g.j(this, path, z10);
    }

    @IgnoreJRERequirement
    public final java.nio.file.Path o() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        j.f(path, "get(toString())");
        return path;
    }

    public final Character p() {
        boolean z10;
        boolean z11 = false;
        if (ByteString.s(b(), g.f33466a, 0, 2, (Object) null) != -1 || b().H() < 2 || b().i(1) != ((byte) 58)) {
            return null;
        }
        char i10 = (char) b().i(0);
        if ('a' > i10 || i10 >= '{') {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            if ('A' <= i10 && i10 < '[') {
                z11 = true;
            }
            if (!z11) {
                return null;
            }
        }
        return Character.valueOf(i10);
    }

    public final File toFile() {
        return new File(toString());
    }

    public String toString() {
        return b().Q();
    }
}
