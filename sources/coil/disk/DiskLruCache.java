package coil.disk;

import com.facebook.appevents.AppEventsConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import okio.BufferedSink;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001P\b\u0000\u0018\u0000 \u00162\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004$(+-B7\u0012\u0006\u0010S\u001a\u00020T\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020*¢\u0006\u0004\bW\u0010XJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\rR\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0014\u0010\u0015\u001a\u00020\u000f2\n\u0010\u0014\u001a\u00060\u0013R\u00020\u0000H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0004J\u0017\u0010\u001f\u001a\b\u0018\u00010\u001eR\u00020\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0014\u0010 \u001a\b\u0018\u00010\rR\u00020\u00002\u0006\u0010\u001b\u001a\u00020\bJ\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0014\u0010,\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001dR\u0014\u0010.\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001dR\u0014\u00100\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010%R\u0014\u00102\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010%R\u0014\u00104\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010%R8\u00109\u001a&\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0013R\u00020\u000005j\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0013R\u00020\u0000`68\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010\u0012R\u0016\u0010A\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010\u001dR\u0018\u0010D\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0016\u0010O\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010FR\u0014\u0010S\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006Y"}, d2 = {"Lcoil/disk/DiskLruCache;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/io/Flushable;", "", "P", "Lokio/BufferedSink;", "N", "", "line", "S", "O", "i0", "Lcoil/disk/DiskLruCache$b;", "editor", "", "success", "C", "J", "Lcoil/disk/DiskLruCache$c;", "entry", "Y", "y", "e0", "c0", "E", "L", "key", "f0", "I", "Lcoil/disk/DiskLruCache$d;", "G", "F", "close", "flush", "Lokio/Path;", "a", "Lokio/Path;", "directory", "", "b", "maxSize", "", "c", "appVersion", "d", "valueCount", "e", "journalFile", "f", "journalFileTmp", "g", "journalFileBackup", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "h", "Ljava/util/LinkedHashMap;", "lruEntries", "Lkotlinx/coroutines/k0;", "j", "Lkotlinx/coroutines/k0;", "cleanupScope", "k", "size", "l", "operationsSinceRewrite", "m", "Lokio/BufferedSink;", "journalWriter", "n", "Z", "hasJournalErrors", "p", "initialized", "q", "closed", "t", "mostRecentTrimFailed", "w", "mostRecentRebuildFailed", "coil/disk/DiskLruCache$e", "x", "Lcoil/disk/DiskLruCache$e;", "fileSystem", "Lokio/FileSystem;", "Lkotlinx/coroutines/CoroutineDispatcher;", "cleanupDispatcher", "<init>", "(Lokio/FileSystem;Lokio/Path;Lkotlinx/coroutines/CoroutineDispatcher;JII)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: y  reason: collision with root package name */
    public static final a f8121y = new a((DefaultConstructorMarker) null);

    /* renamed from: z  reason: collision with root package name */
    private static final Regex f8122z = new Regex("[a-z0-9_-]{1,120}");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Path f8123a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8124b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8125c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f8126d;

    /* renamed from: e  reason: collision with root package name */
    private final Path f8127e;

    /* renamed from: f  reason: collision with root package name */
    private final Path f8128f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f8129g;

    /* renamed from: h  reason: collision with root package name */
    private final LinkedHashMap<String, c> f8130h;

    /* renamed from: j  reason: collision with root package name */
    private final k0 f8131j;

    /* renamed from: k  reason: collision with root package name */
    private long f8132k;

    /* renamed from: l  reason: collision with root package name */
    private int f8133l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public BufferedSink f8134m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f8135n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f8136p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f8137q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f8138t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f8139w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final e f8140x;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u0012\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\t\u0010\u0004\u0012\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u0012\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u0012\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u0012\u0004\b\u0015\u0010\b¨\u0006\u0017"}, d2 = {"Lcoil/disk/DiskLruCache$a;", "", "", "CLEAN", "Ljava/lang/String;", "DIRTY", "JOURNAL_FILE", "getJOURNAL_FILE$coil_base_release$annotations", "()V", "JOURNAL_FILE_BACKUP", "getJOURNAL_FILE_BACKUP$coil_base_release$annotations", "JOURNAL_FILE_TMP", "getJOURNAL_FILE_TMP$coil_base_release$annotations", "Lkotlin/text/Regex;", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "getMAGIC$coil_base_release$annotations", "READ", "REMOVE", "VERSION", "getVERSION$coil_base_release$annotations", "<init>", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0014\u001a\u00060\u0010R\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\f\u0010\u000e\u001a\b\u0018\u00010\fR\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0004R\u001b\u0010\u0014\u001a\u00060\u0010R\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcoil/disk/DiskLruCache$b;", "", "", "success", "", "d", "", "index", "Lokio/Path;", "f", "e", "b", "Lcoil/disk/DiskLruCache$d;", "Lcoil/disk/DiskLruCache;", "c", "a", "Lcoil/disk/DiskLruCache$c;", "Lcoil/disk/DiskLruCache$c;", "g", "()Lcoil/disk/DiskLruCache$c;", "entry", "Z", "closed", "", "[Z", "h", "()[Z", "written", "<init>", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$c;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f8141a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8142b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean[] f8143c;

        public b(c cVar) {
            this.f8141a = cVar;
            this.f8143c = new boolean[DiskLruCache.this.f8126d];
        }

        private final void d(boolean z10) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!this.f8142b) {
                    if (j.b(this.f8141a.b(), this)) {
                        diskLruCache.C(this, z10);
                    }
                    this.f8142b = true;
                    Unit unit = Unit.f32013a;
                } else {
                    throw new IllegalStateException("editor is closed".toString());
                }
            }
        }

        public final void a() {
            d(false);
        }

        public final void b() {
            d(true);
        }

        public final d c() {
            d G;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                b();
                G = diskLruCache.G(this.f8141a.d());
            }
            return G;
        }

        public final void e() {
            if (j.b(this.f8141a.b(), this)) {
                this.f8141a.m(true);
            }
        }

        public final Path f(int i10) {
            Path path;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!this.f8142b) {
                    this.f8143c[i10] = true;
                    Path path2 = this.f8141a.c().get(i10);
                    coil.util.e.a(diskLruCache.f8140x, path2);
                    path = path2;
                } else {
                    throw new IllegalStateException("editor is closed".toString());
                }
            }
            return path;
        }

        public final c g() {
            return this.f8141a;
        }

        public final boolean[] h() {
            return this.f8143c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b7\u00108J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\f\u0010\f\u001a\b\u0018\u00010\nR\u00020\u000bR\u0017\u0010\u0011\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\r\u0010\u001dR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R(\u00100\u001a\b\u0018\u00010+R\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010,\u001a\u0004\b\u0013\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u0002018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u00102\u001a\u0004\b'\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcoil/disk/DiskLruCache$c;", "", "", "", "strings", "", "j", "Lokio/BufferedSink;", "writer", "o", "Lcoil/disk/DiskLruCache$d;", "Lcoil/disk/DiskLruCache;", "n", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "key", "", "b", "[J", "e", "()[J", "lengths", "Ljava/util/ArrayList;", "Lokio/Path;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "cleanFiles", "dirtyFiles", "", "Z", "g", "()Z", "l", "(Z)V", "readable", "f", "h", "m", "zombie", "Lcoil/disk/DiskLruCache$b;", "Lcoil/disk/DiskLruCache$b;", "()Lcoil/disk/DiskLruCache$b;", "i", "(Lcoil/disk/DiskLruCache$b;)V", "currentEditor", "", "I", "()I", "k", "(I)V", "lockingSnapshotCount", "<init>", "(Lcoil/disk/DiskLruCache;Ljava/lang/String;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f8145a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f8146b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<Path> f8147c;

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList<Path> f8148d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8149e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f8150f;

        /* renamed from: g  reason: collision with root package name */
        private b f8151g;

        /* renamed from: h  reason: collision with root package name */
        private int f8152h;

        public c(String str) {
            this.f8145a = str;
            this.f8146b = new long[DiskLruCache.this.f8126d];
            this.f8147c = new ArrayList<>(DiskLruCache.this.f8126d);
            this.f8148d = new ArrayList<>(DiskLruCache.this.f8126d);
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            int g10 = DiskLruCache.this.f8126d;
            for (int i10 = 0; i10 < g10; i10++) {
                sb2.append(i10);
                this.f8147c.add(DiskLruCache.this.f8123a.k(sb2.toString()));
                sb2.append(".tmp");
                this.f8148d.add(DiskLruCache.this.f8123a.k(sb2.toString()));
                sb2.setLength(length);
            }
        }

        public final ArrayList<Path> a() {
            return this.f8147c;
        }

        public final b b() {
            return this.f8151g;
        }

        public final ArrayList<Path> c() {
            return this.f8148d;
        }

        public final String d() {
            return this.f8145a;
        }

        public final long[] e() {
            return this.f8146b;
        }

        public final int f() {
            return this.f8152h;
        }

        public final boolean g() {
            return this.f8149e;
        }

        public final boolean h() {
            return this.f8150f;
        }

        public final void i(b bVar) {
            this.f8151g = bVar;
        }

        public final void j(List<String> list) {
            if (list.size() == DiskLruCache.this.f8126d) {
                try {
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        this.f8146b[i10] = Long.parseLong(list.get(i10));
                    }
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + list);
                }
            } else {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void k(int i10) {
            this.f8152h = i10;
        }

        public final void l(boolean z10) {
            this.f8149e = z10;
        }

        public final void m(boolean z10) {
            this.f8150f = z10;
        }

        public final d n() {
            if (!this.f8149e || this.f8151g != null || this.f8150f) {
                return null;
            }
            ArrayList<Path> arrayList = this.f8147c;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!diskLruCache.f8140x.j(arrayList.get(i10))) {
                    try {
                        boolean unused = diskLruCache.Y(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
            this.f8152h++;
            return new d(this);
        }

        public final void o(BufferedSink bufferedSink) {
            for (long J0 : this.f8146b) {
                bufferedSink.writeByte(32).J0(J0);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0010\u001a\u00060\fR\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\f\u0010\u000b\u001a\b\u0018\u00010\tR\u00020\nR\u001b\u0010\u0010\u001a\u00060\fR\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcoil/disk/DiskLruCache$d;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "index", "Lokio/Path;", "b", "", "close", "Lcoil/disk/DiskLruCache$b;", "Lcoil/disk/DiskLruCache;", "a", "Lcoil/disk/DiskLruCache$c;", "Lcoil/disk/DiskLruCache$c;", "getEntry", "()Lcoil/disk/DiskLruCache$c;", "entry", "", "Z", "closed", "<init>", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$c;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public final class d implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final c f8154a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8155b;

        public d(c cVar) {
            this.f8154a = cVar;
        }

        public final b a() {
            b F;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                close();
                F = diskLruCache.F(this.f8154a.d());
            }
            return F;
        }

        public final Path b(int i10) {
            if (!this.f8155b) {
                return this.f8154a.a().get(i10);
            }
            throw new IllegalStateException("snapshot is closed".toString());
        }

        public void close() {
            if (!this.f8155b) {
                this.f8155b = true;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    c cVar = this.f8154a;
                    cVar.k(cVar.f() - 1);
                    if (this.f8154a.f() == 0 && this.f8154a.h()) {
                        boolean unused = diskLruCache.Y(this.f8154a);
                    }
                    Unit unit = Unit.f32013a;
                }
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"coil/disk/DiskLruCache$e", "Lokio/ForwardingFileSystem;", "Lokio/Path;", "file", "", "mustCreate", "Lokio/Sink;", "p", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class e extends ForwardingFileSystem {
        e(FileSystem fileSystem) {
            super(fileSystem);
        }

        public Sink p(Path path, boolean z10) {
            Path i10 = path.i();
            if (i10 != null) {
                d(i10);
            }
            return super.p(path, z10);
        }
    }

    public DiskLruCache(FileSystem fileSystem, Path path, CoroutineDispatcher coroutineDispatcher, long j10, int i10, int i11) {
        boolean z10;
        boolean z11;
        this.f8123a = path;
        this.f8124b = j10;
        this.f8125c = i10;
        this.f8126d = i11;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.f8127e = path.k("journal");
                this.f8128f = path.k("journal.tmp");
                this.f8129g = path.k("journal.bkp");
                this.f8130h = new LinkedHashMap<>(0, 0.75f, true);
                this.f8131j = l0.a(o2.b((s1) null, 1, (Object) null).e0(coroutineDispatcher.S(1)));
                this.f8140x = new e(fileSystem);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0122, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void C(coil.disk.DiskLruCache.b r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            coil.disk.DiskLruCache$c r0 = r9.g()     // Catch:{ all -> 0x012f }
            coil.disk.DiskLruCache$b r1 = r0.b()     // Catch:{ all -> 0x012f }
            boolean r1 = kotlin.jvm.internal.j.b(r1, r9)     // Catch:{ all -> 0x012f }
            if (r1 == 0) goto L_0x0123
            r1 = 0
            if (r10 == 0) goto L_0x009c
            boolean r2 = r0.h()     // Catch:{ all -> 0x012f }
            if (r2 != 0) goto L_0x009c
            int r2 = r8.f8126d     // Catch:{ all -> 0x012f }
            r3 = r1
        L_0x001b:
            if (r3 >= r2) goto L_0x003f
            boolean[] r4 = r9.h()     // Catch:{ all -> 0x012f }
            boolean r4 = r4[r3]     // Catch:{ all -> 0x012f }
            if (r4 == 0) goto L_0x003c
            coil.disk.DiskLruCache$e r4 = r8.f8140x     // Catch:{ all -> 0x012f }
            java.util.ArrayList r5 = r0.c()     // Catch:{ all -> 0x012f }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x012f }
            okio.Path r5 = (okio.Path) r5     // Catch:{ all -> 0x012f }
            boolean r4 = r4.j(r5)     // Catch:{ all -> 0x012f }
            if (r4 != 0) goto L_0x003c
            r9.a()     // Catch:{ all -> 0x012f }
            monitor-exit(r8)
            return
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x003f:
            int r9 = r8.f8126d     // Catch:{ all -> 0x012f }
        L_0x0041:
            if (r1 >= r9) goto L_0x00b2
            java.util.ArrayList r2 = r0.c()     // Catch:{ all -> 0x012f }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x012f }
            okio.Path r2 = (okio.Path) r2     // Catch:{ all -> 0x012f }
            java.util.ArrayList r3 = r0.a()     // Catch:{ all -> 0x012f }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x012f }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x012f }
            coil.disk.DiskLruCache$e r4 = r8.f8140x     // Catch:{ all -> 0x012f }
            boolean r4 = r4.j(r2)     // Catch:{ all -> 0x012f }
            if (r4 == 0) goto L_0x0065
            coil.disk.DiskLruCache$e r4 = r8.f8140x     // Catch:{ all -> 0x012f }
            r4.c(r2, r3)     // Catch:{ all -> 0x012f }
            goto L_0x0074
        L_0x0065:
            coil.disk.DiskLruCache$e r2 = r8.f8140x     // Catch:{ all -> 0x012f }
            java.util.ArrayList r4 = r0.a()     // Catch:{ all -> 0x012f }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x012f }
            okio.Path r4 = (okio.Path) r4     // Catch:{ all -> 0x012f }
            coil.util.e.a(r2, r4)     // Catch:{ all -> 0x012f }
        L_0x0074:
            long[] r2 = r0.e()     // Catch:{ all -> 0x012f }
            r4 = r2[r1]     // Catch:{ all -> 0x012f }
            coil.disk.DiskLruCache$e r2 = r8.f8140x     // Catch:{ all -> 0x012f }
            okio.FileMetadata r2 = r2.l(r3)     // Catch:{ all -> 0x012f }
            java.lang.Long r2 = r2.d()     // Catch:{ all -> 0x012f }
            if (r2 == 0) goto L_0x008b
            long r2 = r2.longValue()     // Catch:{ all -> 0x012f }
            goto L_0x008d
        L_0x008b:
            r2 = 0
        L_0x008d:
            long[] r6 = r0.e()     // Catch:{ all -> 0x012f }
            r6[r1] = r2     // Catch:{ all -> 0x012f }
            long r6 = r8.f8132k     // Catch:{ all -> 0x012f }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.f8132k = r6     // Catch:{ all -> 0x012f }
            int r1 = r1 + 1
            goto L_0x0041
        L_0x009c:
            int r9 = r8.f8126d     // Catch:{ all -> 0x012f }
        L_0x009e:
            if (r1 >= r9) goto L_0x00b2
            coil.disk.DiskLruCache$e r2 = r8.f8140x     // Catch:{ all -> 0x012f }
            java.util.ArrayList r3 = r0.c()     // Catch:{ all -> 0x012f }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x012f }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x012f }
            r2.h(r3)     // Catch:{ all -> 0x012f }
            int r1 = r1 + 1
            goto L_0x009e
        L_0x00b2:
            r9 = 0
            r0.i(r9)     // Catch:{ all -> 0x012f }
            boolean r9 = r0.h()     // Catch:{ all -> 0x012f }
            if (r9 == 0) goto L_0x00c1
            r8.Y(r0)     // Catch:{ all -> 0x012f }
            monitor-exit(r8)
            return
        L_0x00c1:
            int r9 = r8.f8133l     // Catch:{ all -> 0x012f }
            r1 = 1
            int r9 = r9 + r1
            r8.f8133l = r9     // Catch:{ all -> 0x012f }
            okio.BufferedSink r9 = r8.f8134m     // Catch:{ all -> 0x012f }
            kotlin.jvm.internal.j.d(r9)     // Catch:{ all -> 0x012f }
            r2 = 10
            r3 = 32
            if (r10 != 0) goto L_0x00f5
            boolean r10 = r0.g()     // Catch:{ all -> 0x012f }
            if (r10 == 0) goto L_0x00d9
            goto L_0x00f5
        L_0x00d9:
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$c> r10 = r8.f8130h     // Catch:{ all -> 0x012f }
            java.lang.String r1 = r0.d()     // Catch:{ all -> 0x012f }
            r10.remove(r1)     // Catch:{ all -> 0x012f }
            java.lang.String r10 = "REMOVE"
            r9.h0(r10)     // Catch:{ all -> 0x012f }
            r9.writeByte(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r10 = r0.d()     // Catch:{ all -> 0x012f }
            r9.h0(r10)     // Catch:{ all -> 0x012f }
            r9.writeByte(r2)     // Catch:{ all -> 0x012f }
            goto L_0x010d
        L_0x00f5:
            r0.l(r1)     // Catch:{ all -> 0x012f }
            java.lang.String r10 = "CLEAN"
            r9.h0(r10)     // Catch:{ all -> 0x012f }
            r9.writeByte(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r10 = r0.d()     // Catch:{ all -> 0x012f }
            r9.h0(r10)     // Catch:{ all -> 0x012f }
            r0.o(r9)     // Catch:{ all -> 0x012f }
            r9.writeByte(r2)     // Catch:{ all -> 0x012f }
        L_0x010d:
            r9.flush()     // Catch:{ all -> 0x012f }
            long r9 = r8.f8132k     // Catch:{ all -> 0x012f }
            long r0 = r8.f8124b     // Catch:{ all -> 0x012f }
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L_0x011e
            boolean r9 = r8.J()     // Catch:{ all -> 0x012f }
            if (r9 == 0) goto L_0x0121
        L_0x011e:
            r8.L()     // Catch:{ all -> 0x012f }
        L_0x0121:
            monitor-exit(r8)
            return
        L_0x0123:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x012f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x012f }
            r10.<init>(r9)     // Catch:{ all -> 0x012f }
            throw r10     // Catch:{ all -> 0x012f }
        L_0x012f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.C(coil.disk.DiskLruCache$b, boolean):void");
    }

    private final void E() {
        close();
        coil.util.e.b(this.f8140x, this.f8123a);
    }

    /* access modifiers changed from: private */
    public final boolean J() {
        return this.f8133l >= 2000;
    }

    private final void L() {
        s1 unused = j.d(this.f8131j, (CoroutineContext) null, (CoroutineStart) null, new DiskLruCache$launchCleanup$1(this, (kotlin.coroutines.c<? super DiskLruCache$launchCleanup$1>) null), 3, (Object) null);
    }

    private final BufferedSink N() {
        return Okio.b(new b(this.f8140x.a(this.f8127e), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void O() {
        Iterator<c> it = this.f8130h.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            c next = it.next();
            int i10 = 0;
            if (next.b() == null) {
                int i11 = this.f8126d;
                while (i10 < i11) {
                    j10 += next.e()[i10];
                    i10++;
                }
            } else {
                next.i((b) null);
                int i12 = this.f8126d;
                while (i10 < i12) {
                    this.f8140x.h(next.a().get(i10));
                    this.f8140x.h(next.c().get(i10));
                    i10++;
                }
                it.remove();
            }
        }
        this.f8132k = j10;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|(1:22)(1:23)|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r12.f8133l = r9 - r12.f8130h.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r1.Y0() == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        i0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        r12.f8134m = N();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r0 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void P() {
        /*
            r12 = this;
            java.lang.String r0 = ", "
            coil.disk.DiskLruCache$e r1 = r12.f8140x
            okio.Path r2 = r12.f8127e
            okio.Source r1 = r1.q(r2)
            okio.BufferedSource r1 = okio.Okio.c(r1)
            r2 = 0
            java.lang.String r3 = r1.w0()     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r1.w0()     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = r1.w0()     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = r1.w0()     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = r1.w0()     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "libcore.io.DiskLruCache"
            boolean r8 = kotlin.jvm.internal.j.b(r8, r3)     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = "1"
            boolean r8 = kotlin.jvm.internal.j.b(r8, r4)     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x007d
            int r8 = r12.f8125c     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00b1 }
            boolean r8 = kotlin.jvm.internal.j.b(r8, r5)     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x007d
            int r8 = r12.f8126d     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00b1 }
            boolean r8 = kotlin.jvm.internal.j.b(r8, r6)     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x007d
            int r8 = r7.length()     // Catch:{ all -> 0x00b1 }
            r9 = 0
            if (r8 <= 0) goto L_0x0054
            r8 = 1
            goto L_0x0055
        L_0x0054:
            r8 = r9
        L_0x0055:
            if (r8 != 0) goto L_0x007d
        L_0x0057:
            java.lang.String r0 = r1.w0()     // Catch:{ EOFException -> 0x0061 }
            r12.S(r0)     // Catch:{ EOFException -> 0x0061 }
            int r9 = r9 + 1
            goto L_0x0057
        L_0x0061:
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$c> r0 = r12.f8130h     // Catch:{ all -> 0x00b1 }
            int r0 = r0.size()     // Catch:{ all -> 0x00b1 }
            int r9 = r9 - r0
            r12.f8133l = r9     // Catch:{ all -> 0x00b1 }
            boolean r0 = r1.Y0()     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x0074
            r12.i0()     // Catch:{ all -> 0x00b1 }
            goto L_0x007a
        L_0x0074:
            okio.BufferedSink r0 = r12.N()     // Catch:{ all -> 0x00b1 }
            r12.f8134m = r0     // Catch:{ all -> 0x00b1 }
        L_0x007a:
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00b1 }
            goto L_0x00b5
        L_0x007d:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r9.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "unexpected journal header: ["
            r9.append(r10)     // Catch:{ all -> 0x00b1 }
            r9.append(r3)     // Catch:{ all -> 0x00b1 }
            r9.append(r0)     // Catch:{ all -> 0x00b1 }
            r9.append(r4)     // Catch:{ all -> 0x00b1 }
            r9.append(r0)     // Catch:{ all -> 0x00b1 }
            r9.append(r5)     // Catch:{ all -> 0x00b1 }
            r9.append(r0)     // Catch:{ all -> 0x00b1 }
            r9.append(r6)     // Catch:{ all -> 0x00b1 }
            r9.append(r0)     // Catch:{ all -> 0x00b1 }
            r9.append(r7)     // Catch:{ all -> 0x00b1 }
            r0 = 93
            r9.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x00b1 }
            r8.<init>(r0)     // Catch:{ all -> 0x00b1 }
            throw r8     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r0 = move-exception
            r11 = r2
            r2 = r0
            r0 = r11
        L_0x00b5:
            if (r1 == 0) goto L_0x00c3
            r1.close()     // Catch:{ all -> 0x00bb }
            goto L_0x00c3
        L_0x00bb:
            r1 = move-exception
            if (r2 != 0) goto L_0x00c0
            r2 = r1
            goto L_0x00c3
        L_0x00c0:
            gk.b.a(r2, r1)
        L_0x00c3:
            if (r2 != 0) goto L_0x00c9
            kotlin.jvm.internal.j.d(r0)
            return
        L_0x00c9:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.P():void");
    }

    private final void S(String str) {
        String str2;
        int a02 = StringsKt__StringsKt.a0(str, ' ', 0, false, 6, (Object) null);
        if (a02 != -1) {
            int i10 = a02 + 1;
            int a03 = StringsKt__StringsKt.a0(str, ' ', i10, false, 4, (Object) null);
            if (a03 == -1) {
                str2 = str.substring(i10);
                j.f(str2, "this as java.lang.String).substring(startIndex)");
                if (a02 == 6 && r.J(str, "REMOVE", false, 2, (Object) null)) {
                    this.f8130h.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, a03);
                j.f(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            LinkedHashMap<String, c> linkedHashMap = this.f8130h;
            c cVar = linkedHashMap.get(str2);
            if (cVar == null) {
                cVar = new c(str2);
                linkedHashMap.put(str2, cVar);
            }
            c cVar2 = cVar;
            if (a03 != -1 && a02 == 5 && r.J(str, "CLEAN", false, 2, (Object) null)) {
                String substring = str.substring(a03 + 1);
                j.f(substring, "this as java.lang.String).substring(startIndex)");
                List B0 = StringsKt__StringsKt.B0(substring, new char[]{' '}, false, 0, 6, (Object) null);
                cVar2.l(true);
                cVar2.i((b) null);
                cVar2.j(B0);
            } else if (a03 == -1 && a02 == 5 && r.J(str, "DIRTY", false, 2, (Object) null)) {
                cVar2.i(new b(cVar2));
            } else if (a03 != -1 || a02 != 4 || !r.J(str, "READ", false, 2, (Object) null)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: private */
    public final boolean Y(c cVar) {
        BufferedSink bufferedSink;
        if (cVar.f() > 0 && (bufferedSink = this.f8134m) != null) {
            bufferedSink.h0("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.h0(cVar.d());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (cVar.f() > 0 || cVar.b() != null) {
            cVar.m(true);
            return true;
        }
        int i10 = this.f8126d;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f8140x.h(cVar.a().get(i11));
            this.f8132k -= cVar.e()[i11];
            cVar.e()[i11] = 0;
        }
        this.f8133l++;
        BufferedSink bufferedSink2 = this.f8134m;
        if (bufferedSink2 != null) {
            bufferedSink2.h0("REMOVE");
            bufferedSink2.writeByte(32);
            bufferedSink2.h0(cVar.d());
            bufferedSink2.writeByte(10);
        }
        this.f8130h.remove(cVar.d());
        if (J()) {
            L();
        }
        return true;
    }

    private final boolean c0() {
        for (c next : this.f8130h.values()) {
            if (!next.h()) {
                Y(next);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void e0() {
        while (this.f8132k > this.f8124b) {
            if (!c0()) {
                return;
            }
        }
        this.f8138t = false;
    }

    private final void f0(String str) {
        if (!f8122z.e(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void i0() {
        Unit unit;
        BufferedSink bufferedSink = this.f8134m;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink b10 = Okio.b(this.f8140x.p(this.f8128f, false));
        Throwable th2 = null;
        try {
            b10.h0("libcore.io.DiskLruCache").writeByte(10);
            b10.h0(AppEventsConstants.EVENT_PARAM_VALUE_YES).writeByte(10);
            b10.J0((long) this.f8125c).writeByte(10);
            b10.J0((long) this.f8126d).writeByte(10);
            b10.writeByte(10);
            for (c next : this.f8130h.values()) {
                if (next.b() != null) {
                    b10.h0("DIRTY");
                    b10.writeByte(32);
                    b10.h0(next.d());
                    b10.writeByte(10);
                } else {
                    b10.h0("CLEAN");
                    b10.writeByte(32);
                    b10.h0(next.d());
                    next.o(b10);
                    b10.writeByte(10);
                }
            }
            unit = Unit.f32013a;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            unit = null;
            th2 = th4;
        }
        if (b10 != null) {
            try {
                b10.close();
            } catch (Throwable th5) {
                if (th2 == null) {
                    th2 = th5;
                } else {
                    b.a(th2, th5);
                }
            }
        }
        if (th2 == null) {
            j.d(unit);
            if (this.f8140x.j(this.f8127e)) {
                this.f8140x.c(this.f8127e, this.f8129g);
                this.f8140x.c(this.f8128f, this.f8127e);
                this.f8140x.h(this.f8129g);
            } else {
                this.f8140x.c(this.f8128f, this.f8127e);
            }
            this.f8134m = N();
            this.f8133l = 0;
            this.f8135n = false;
            this.f8139w = false;
        } else {
            throw th2;
        }
    }

    private final void y() {
        if (!(!this.f8137q)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public final synchronized b F(String str) {
        b bVar;
        y();
        f0(str);
        I();
        c cVar = this.f8130h.get(str);
        if (cVar != null) {
            bVar = cVar.b();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return null;
        }
        if (cVar != null) {
            if (cVar.f() != 0) {
                return null;
            }
        }
        if (!this.f8138t) {
            if (!this.f8139w) {
                BufferedSink bufferedSink = this.f8134m;
                j.d(bufferedSink);
                bufferedSink.h0("DIRTY");
                bufferedSink.writeByte(32);
                bufferedSink.h0(str);
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                if (this.f8135n) {
                    return null;
                }
                if (cVar == null) {
                    cVar = new c(str);
                    this.f8130h.put(str, cVar);
                }
                b bVar2 = new b(cVar);
                cVar.i(bVar2);
                return bVar2;
            }
        }
        L();
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized coil.disk.DiskLruCache.d G(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.y()     // Catch:{ all -> 0x0046 }
            r3.f0(r4)     // Catch:{ all -> 0x0046 }
            r3.I()     // Catch:{ all -> 0x0046 }
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$c> r0 = r3.f8130h     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0046 }
            coil.disk.DiskLruCache$c r0 = (coil.disk.DiskLruCache.c) r0     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0043
            coil.disk.DiskLruCache$d r0 = r0.n()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x001b
            goto L_0x0043
        L_0x001b:
            int r1 = r3.f8133l     // Catch:{ all -> 0x0046 }
            int r1 = r1 + 1
            r3.f8133l = r1     // Catch:{ all -> 0x0046 }
            okio.BufferedSink r1 = r3.f8134m     // Catch:{ all -> 0x0046 }
            kotlin.jvm.internal.j.d(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "READ"
            r1.h0(r2)     // Catch:{ all -> 0x0046 }
            r2 = 32
            r1.writeByte(r2)     // Catch:{ all -> 0x0046 }
            r1.h0(r4)     // Catch:{ all -> 0x0046 }
            r4 = 10
            r1.writeByte(r4)     // Catch:{ all -> 0x0046 }
            boolean r4 = r3.J()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0041
            r3.L()     // Catch:{ all -> 0x0046 }
        L_0x0041:
            monitor-exit(r3)
            return r0
        L_0x0043:
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0046:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.G(java.lang.String):coil.disk.DiskLruCache$d");
    }

    public final synchronized void I() {
        if (!this.f8136p) {
            this.f8140x.h(this.f8128f);
            if (this.f8140x.j(this.f8129g)) {
                if (this.f8140x.j(this.f8127e)) {
                    this.f8140x.h(this.f8129g);
                } else {
                    this.f8140x.c(this.f8129g, this.f8127e);
                }
            }
            if (this.f8140x.j(this.f8127e)) {
                try {
                    P();
                    O();
                    this.f8136p = true;
                    return;
                } catch (IOException unused) {
                    E();
                    this.f8137q = false;
                } catch (Throwable th2) {
                    this.f8137q = false;
                    throw th2;
                }
            }
            i0();
            this.f8136p = true;
        }
    }

    public synchronized void close() {
        if (this.f8136p) {
            if (!this.f8137q) {
                Object[] array2 = this.f8130h.values().toArray(new c[0]);
                j.e(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                for (c b10 : (c[]) array2) {
                    b b11 = b10.b();
                    if (b11 != null) {
                        b11.e();
                    }
                }
                e0();
                l0.f(this.f8131j, (CancellationException) null, 1, (Object) null);
                BufferedSink bufferedSink = this.f8134m;
                j.d(bufferedSink);
                bufferedSink.close();
                this.f8134m = null;
                this.f8137q = true;
                return;
            }
        }
        this.f8137q = true;
    }

    public synchronized void flush() {
        if (this.f8136p) {
            y();
            e0();
            BufferedSink bufferedSink = this.f8134m;
            j.d(bufferedSink);
            bufferedSink.flush();
        }
    }
}
