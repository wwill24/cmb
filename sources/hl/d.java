package hl;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import hl.f;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u0001:\u0004JPV\\B\u0015\b\u0000\u0012\b\u0010´\u0001\u001a\u00030³\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0002J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J-\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010 \u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0014J\u001f\u0010#\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010%\u001a\u00020!H\u0000¢\u0006\u0004\b&\u0010$J\u001f\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0014H\u0000¢\u0006\u0004\b(\u0010)J\u001e\u0010-\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010.\u001a\u00020\rJ\u000e\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020!J\b\u00100\u001a\u00020\rH\u0016J)\u00104\u001a\u00020\r2\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b4\u00105J\u001c\u00109\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020\u00072\b\b\u0002\u00108\u001a\u000207H\u0007J\u000e\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0014J\u000f\u0010<\u001a\u00020\rH\u0000¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0000¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b@\u0010AJ-\u0010C\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010B\u001a\u00020\u0007H\u0000¢\u0006\u0004\bC\u0010DJ/\u0010G\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010F\u001a\u00020E2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007H\u0000¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\bI\u0010$R\u001a\u0010N\u001a\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010T\u001a\u00020O8\u0000X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR&\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0U8\u0000X\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001a\u0010`\u001a\u00020[8\u0000X\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\"\u0010e\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010i\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000e\u001a\u0004\bg\u0010b\"\u0004\bh\u0010dR\u0016\u0010k\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010KR\u0014\u00108\u001a\u0002078\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010q\u001a\u00020n8\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020n8\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010pR\u0014\u0010u\u001a\u00020n8\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010pR\u0014\u0010y\u001a\u00020v8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010LR\u0016\u0010}\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010LR\u0016\u0010\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010LR\u0018\u0010\u0001\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010LR\u0018\u0010\u0001\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010LR\u0018\u0010\u0001\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010LR\u001d\u0010\u0001\u001a\u00030\u00018\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u00148\u0006@BX\u000e¢\u0006\u000f\n\u0005\b\u0001\u0010L\u001a\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u00148\u0006@BX\u000e¢\u0006\u000f\n\u0005\b\u0001\u0010L\u001a\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u00148\u0006@BX\u000e¢\u0006\u000f\n\u0005\b\u0001\u0010L\u001a\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u00148\u0006@BX\u000e¢\u0006\u000f\n\u0005\b\u0001\u0010L\u001a\u0006\b\u0001\u0010\u0001R \u0010¤\u0001\u001a\u00030\u00018\u0000X\u0004¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010©\u0001\u001a\u00030¥\u00018\u0006¢\u0006\u000f\n\u0005\b4\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010¯\u0001\u001a\u00070ª\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001R\u001d\u0010²\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020°\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010±\u0001¨\u0006·\u0001"}, d2 = {"Lhl/d;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lhl/a;", "requestHeaders", "", "out", "Lhl/g;", "s0", "Ljava/io/IOException;", "e", "", "I", "id", "e0", "streamId", "E0", "(I)Lhl/g;", "", "read", "W0", "(J)V", "t0", "outFinished", "alternating", "b1", "(IZLjava/util/List;)V", "Lokio/Buffer;", "buffer", "byteCount", "a1", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "e1", "(ILokhttp3/internal/http2/ErrorCode;)V", "statusCode", "d1", "unacknowledgedBytesRead", "g1", "(IJ)V", "reply", "payload1", "payload2", "c1", "flush", "R0", "close", "connectionCode", "streamCode", "cause", "G", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lel/e;", "taskRunner", "S0", "nowNs", "r0", "H0", "()V", "B0", "(I)Z", "x0", "(ILjava/util/List;)V", "inFinished", "v0", "(ILjava/util/List;Z)V", "Lokio/BufferedSource;", "source", "u0", "(ILokio/BufferedSource;IZ)V", "A0", "a", "Z", "J", "()Z", "client", "Lhl/d$c;", "b", "Lhl/d$c;", "O", "()Lhl/d$c;", "listener", "", "c", "Ljava/util/Map;", "f0", "()Ljava/util/Map;", "streams", "", "d", "Ljava/lang/String;", "L", "()Ljava/lang/String;", "connectionName", "N", "()I", "I0", "(I)V", "lastGoodStreamId", "f", "P", "N0", "nextStreamId", "g", "isShutdown", "h", "Lel/e;", "Lel/d;", "j", "Lel/d;", "writerQueue", "k", "pushQueue", "l", "settingsListenerQueue", "Lhl/j;", "m", "Lhl/j;", "pushObserver", "n", "intervalPingsSent", "p", "intervalPongsReceived", "q", "degradedPingsSent", "t", "degradedPongsReceived", "w", "awaitPongsReceived", "x", "degradedPongDeadlineNs", "Lhl/k;", "y", "Lhl/k;", "S", "()Lhl/k;", "okHttpSettings", "z", "Y", "Q0", "(Lhl/k;)V", "peerSettings", "<set-?>", "B", "getReadBytesTotal", "()J", "readBytesTotal", "C", "getReadBytesAcknowledged", "readBytesAcknowledged", "D", "m0", "writeBytesTotal", "E", "i0", "writeBytesMaximum", "Ljava/net/Socket;", "F", "Ljava/net/Socket;", "c0", "()Ljava/net/Socket;", "socket", "Lhl/h;", "Lhl/h;", "q0", "()Lhl/h;", "writer", "Lhl/d$d;", "H", "Lhl/d$d;", "getReaderRunnable", "()Lhl/d$d;", "readerRunnable", "", "Ljava/util/Set;", "currentPushRequests", "Lhl/d$a;", "builder", "<init>", "(Lhl/d$a;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d implements Closeable {
    public static final b J = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final k K;
    private long B;
    private long C;
    private long D;
    /* access modifiers changed from: private */
    public long E;
    private final Socket F;
    private final h G;
    private final C0347d H;
    /* access modifiers changed from: private */
    public final Set<Integer> I;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f29786a;

    /* renamed from: b  reason: collision with root package name */
    private final c f29787b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, g> f29788c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final String f29789d;

    /* renamed from: e  reason: collision with root package name */
    private int f29790e;

    /* renamed from: f  reason: collision with root package name */
    private int f29791f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f29792g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final el.e f29793h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final el.d f29794j;

    /* renamed from: k  reason: collision with root package name */
    private final el.d f29795k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final el.d f29796l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final j f29797m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public long f29798n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public long f29799p;

    /* renamed from: q  reason: collision with root package name */
    private long f29800q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public long f29801t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public long f29802w;

    /* renamed from: x  reason: collision with root package name */
    private long f29803x;

    /* renamed from: y  reason: collision with root package name */
    private final k f29804y;

    /* renamed from: z  reason: collision with root package name */
    private k f29805z;

    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\bE\u0010FJ.\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010*\u001a\u00020\u00048\u0000@\u0000X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u001f\u0010'\"\u0004\b(\u0010)R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b3\u00107\u001a\u0004\b%\u00108\"\u0004\b9\u0010:R\"\u0010@\u001a\u00020;8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b!\u0010<\u001a\u0004\b1\u0010=\"\u0004\b>\u0010?R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b-\u0010A\u001a\u0004\b+\u0010B\"\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lhl/d$a;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "sink", "s", "Lhl/d$c;", "listener", "k", "", "pingIntervalMillis", "l", "Lhl/d;", "a", "", "Z", "b", "()Z", "setClient$okhttp", "(Z)V", "client", "Lel/e;", "Lel/e;", "j", "()Lel/e;", "taskRunner", "c", "Ljava/net/Socket;", "h", "()Ljava/net/Socket;", "q", "(Ljava/net/Socket;)V", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "connectionName", "e", "Lokio/BufferedSource;", "i", "()Lokio/BufferedSource;", "r", "(Lokio/BufferedSource;)V", "f", "Lokio/BufferedSink;", "g", "()Lokio/BufferedSink;", "p", "(Lokio/BufferedSink;)V", "Lhl/d$c;", "()Lhl/d$c;", "n", "(Lhl/d$c;)V", "Lhl/j;", "Lhl/j;", "()Lhl/j;", "setPushObserver$okhttp", "(Lhl/j;)V", "pushObserver", "I", "()I", "o", "(I)V", "<init>", "(ZLel/e;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f29806a;

        /* renamed from: b  reason: collision with root package name */
        private final el.e f29807b;

        /* renamed from: c  reason: collision with root package name */
        public Socket f29808c;

        /* renamed from: d  reason: collision with root package name */
        public String f29809d;

        /* renamed from: e  reason: collision with root package name */
        public BufferedSource f29810e;

        /* renamed from: f  reason: collision with root package name */
        public BufferedSink f29811f;

        /* renamed from: g  reason: collision with root package name */
        private c f29812g = c.f29816b;

        /* renamed from: h  reason: collision with root package name */
        private j f29813h = j.f29941b;

        /* renamed from: i  reason: collision with root package name */
        private int f29814i;

        public a(boolean z10, el.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "taskRunner");
            this.f29806a = z10;
            this.f29807b = eVar;
        }

        public final d a() {
            return new d(this);
        }

        public final boolean b() {
            return this.f29806a;
        }

        public final String c() {
            String str = this.f29809d;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.j.y("connectionName");
            return null;
        }

        public final c d() {
            return this.f29812g;
        }

        public final int e() {
            return this.f29814i;
        }

        public final j f() {
            return this.f29813h;
        }

        public final BufferedSink g() {
            BufferedSink bufferedSink = this.f29811f;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            kotlin.jvm.internal.j.y("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.f29808c;
            if (socket != null) {
                return socket;
            }
            kotlin.jvm.internal.j.y("socket");
            return null;
        }

        public final BufferedSource i() {
            BufferedSource bufferedSource = this.f29810e;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            kotlin.jvm.internal.j.y("source");
            return null;
        }

        public final el.e j() {
            return this.f29807b;
        }

        public final a k(c cVar) {
            kotlin.jvm.internal.j.g(cVar, "listener");
            n(cVar);
            return this;
        }

        public final a l(int i10) {
            o(i10);
            return this;
        }

        public final void m(String str) {
            kotlin.jvm.internal.j.g(str, "<set-?>");
            this.f29809d = str;
        }

        public final void n(c cVar) {
            kotlin.jvm.internal.j.g(cVar, "<set-?>");
            this.f29812g = cVar;
        }

        public final void o(int i10) {
            this.f29814i = i10;
        }

        public final void p(BufferedSink bufferedSink) {
            kotlin.jvm.internal.j.g(bufferedSink, "<set-?>");
            this.f29811f = bufferedSink;
        }

        public final void q(Socket socket) {
            kotlin.jvm.internal.j.g(socket, "<set-?>");
            this.f29808c = socket;
        }

        public final void r(BufferedSource bufferedSource) {
            kotlin.jvm.internal.j.g(bufferedSource, "<set-?>");
            this.f29810e = bufferedSource;
        }

        public final a s(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) throws IOException {
            String str2;
            kotlin.jvm.internal.j.g(socket, "socket");
            kotlin.jvm.internal.j.g(str, "peerName");
            kotlin.jvm.internal.j.g(bufferedSource, "source");
            kotlin.jvm.internal.j.g(bufferedSink, "sink");
            q(socket);
            if (b()) {
                str2 = bl.d.f24936i + ' ' + str;
            } else {
                str2 = kotlin.jvm.internal.j.p("MockWebServer ", str);
            }
            m(str2);
            r(bufferedSource);
            p(bufferedSink);
            return this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lhl/d$b;", "", "Lhl/k;", "DEFAULT_SETTINGS", "Lhl/k;", "a", "()Lhl/k;", "", "AWAIT_PING", "I", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a() {
            return d.K;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lhl/d$c;", "", "Lhl/g;", "stream", "", "b", "Lhl/d;", "connection", "Lhl/k;", "settings", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f29815a = new b((DefaultConstructorMarker) null);

        /* renamed from: b  reason: collision with root package name */
        public static final c f29816b = new a();

        @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"hl/d$c$a", "Lhl/d$c;", "Lhl/g;", "stream", "", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends c {
            a() {
            }

            public void b(g gVar) throws IOException {
                kotlin.jvm.internal.j.g(gVar, "stream");
                gVar.d(ErrorCode.REFUSED_STREAM, (IOException) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lhl/d$c$b;", "", "Lhl/d$c;", "REFUSE_INCOMING_STREAMS", "Lhl/d$c;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void a(d dVar, k kVar) {
            kotlin.jvm.internal.j.g(dVar, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            kotlin.jvm.internal.j.g(kVar, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        }

        public abstract void b(g gVar) throws IOException;
    }

    @Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u00101\u001a\u00020-¢\u0006\u0004\b2\u00103J\t\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J.\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J \u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016J(\u0010)\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0016J&\u0010,\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u001a\u00101\u001a\u00020-8\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lhl/d$d;", "Lhl/f$c;", "Lkotlin/Function0;", "", "o", "", "inFinished", "", "streamId", "Lokio/BufferedSource;", "source", "length", "h", "associatedStreamId", "", "Lhl/a;", "headerBlock", "a", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "k", "clearPrevious", "Lhl/k;", "settings", "c", "n", "f", "ack", "payload1", "payload2", "i", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "m", "", "windowSizeIncrement", "d", "streamDependency", "weight", "exclusive", "j", "promisedStreamId", "requestHeaders", "e", "Lhl/f;", "Lhl/f;", "getReader$okhttp", "()Lhl/f;", "reader", "<init>", "(Lhl/d;Lhl/f;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: hl.d$d  reason: collision with other inner class name */
    public final class C0347d implements f.c, Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        private final f f29817a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f29818b;

        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: hl.d$d$a */
        public static final class a extends el.a {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f29819e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f29820f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ d f29821g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ Ref$ObjectRef f29822h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z10, d dVar, Ref$ObjectRef ref$ObjectRef) {
                super(str, z10);
                this.f29819e = str;
                this.f29820f = z10;
                this.f29821g = dVar;
                this.f29822h = ref$ObjectRef;
            }

            public long f() {
                this.f29821g.O().a(this.f29821g, (k) this.f29822h.element);
                return -1;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: hl.d$d$b */
        public static final class b extends el.a {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f29823e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f29824f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ d f29825g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ g f29826h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z10, d dVar, g gVar) {
                super(str, z10);
                this.f29823e = str;
                this.f29824f = z10;
                this.f29825g = dVar;
                this.f29826h = gVar;
            }

            public long f() {
                try {
                    this.f29825g.O().b(this.f29826h);
                    return -1;
                } catch (IOException e10) {
                    il.j.f30050a.g().j(kotlin.jvm.internal.j.p("Http2Connection.Listener failure for ", this.f29825g.L()), 4, e10);
                    try {
                        this.f29826h.d(ErrorCode.PROTOCOL_ERROR, e10);
                        return -1;
                    } catch (IOException unused) {
                        return -1;
                    }
                }
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: hl.d$d$c */
        public static final class c extends el.a {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f29827e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f29828f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ d f29829g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ int f29830h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ int f29831i;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z10, d dVar, int i10, int i11) {
                super(str, z10);
                this.f29827e = str;
                this.f29828f = z10;
                this.f29829g = dVar;
                this.f29830h = i10;
                this.f29831i = i11;
            }

            public long f() {
                this.f29829g.c1(true, this.f29830h, this.f29831i);
                return -1;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: hl.d$d$d  reason: collision with other inner class name */
        public static final class C0348d extends el.a {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f29832e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ boolean f29833f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ C0347d f29834g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ boolean f29835h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ k f29836i;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0348d(String str, boolean z10, C0347d dVar, boolean z11, k kVar) {
                super(str, z10);
                this.f29832e = str;
                this.f29833f = z10;
                this.f29834g = dVar;
                this.f29835h = z11;
                this.f29836i = kVar;
            }

            public long f() {
                this.f29834g.n(this.f29835h, this.f29836i);
                return -1;
            }
        }

        public C0347d(d dVar, f fVar) {
            kotlin.jvm.internal.j.g(dVar, "this$0");
            kotlin.jvm.internal.j.g(fVar, "reader");
            this.f29818b = dVar;
            this.f29817a = fVar;
        }

        public void a(boolean z10, int i10, int i11, List<a> list) {
            kotlin.jvm.internal.j.g(list, "headerBlock");
            if (this.f29818b.B0(i10)) {
                this.f29818b.v0(i10, list, z10);
                return;
            }
            d dVar = this.f29818b;
            synchronized (dVar) {
                g e02 = dVar.e0(i10);
                if (e02 != null) {
                    Unit unit = Unit.f32013a;
                    e02.x(bl.d.P(list), z10);
                } else if (!dVar.f29792g) {
                    if (i10 > dVar.N()) {
                        if (i10 % 2 != dVar.P() % 2) {
                            g gVar = new g(i10, dVar, false, z10, bl.d.P(list));
                            dVar.I0(i10);
                            dVar.f0().put(Integer.valueOf(i10), gVar);
                            el.d i12 = dVar.f29793h.i();
                            i12.i(new b(dVar.L() + '[' + i10 + "] onStream", true, dVar, gVar), 0);
                        }
                    }
                }
            }
        }

        public void c(boolean z10, k kVar) {
            kotlin.jvm.internal.j.g(kVar, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
            this.f29818b.f29794j.i(new C0348d(kotlin.jvm.internal.j.p(this.f29818b.L(), " applyAndAckSettings"), true, this, z10, kVar), 0);
        }

        public void d(int i10, long j10) {
            if (i10 == 0) {
                d dVar = this.f29818b;
                synchronized (dVar) {
                    dVar.E = dVar.i0() + j10;
                    dVar.notifyAll();
                    Unit unit = Unit.f32013a;
                }
                return;
            }
            g e02 = this.f29818b.e0(i10);
            if (e02 != null) {
                synchronized (e02) {
                    e02.a(j10);
                    Unit unit2 = Unit.f32013a;
                }
            }
        }

        public void e(int i10, int i11, List<a> list) {
            kotlin.jvm.internal.j.g(list, "requestHeaders");
            this.f29818b.x0(i11, list);
        }

        public void f() {
        }

        public void h(boolean z10, int i10, BufferedSource bufferedSource, int i11) throws IOException {
            kotlin.jvm.internal.j.g(bufferedSource, "source");
            if (this.f29818b.B0(i10)) {
                this.f29818b.u0(i10, bufferedSource, i11, z10);
                return;
            }
            g e02 = this.f29818b.e0(i10);
            if (e02 == null) {
                this.f29818b.e1(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = (long) i11;
                this.f29818b.W0(j10);
                bufferedSource.skip(j10);
                return;
            }
            e02.w(bufferedSource, i11);
            if (z10) {
                e02.x(bl.d.f24929b, true);
            }
        }

        public void i(boolean z10, int i10, int i11) {
            if (z10) {
                d dVar = this.f29818b;
                synchronized (dVar) {
                    if (i10 == 1) {
                        dVar.f29799p = dVar.f29799p + 1;
                    } else if (i10 != 2) {
                        if (i10 == 3) {
                            dVar.f29802w = dVar.f29802w + 1;
                            dVar.notifyAll();
                        }
                        Unit unit = Unit.f32013a;
                    } else {
                        dVar.f29801t = dVar.f29801t + 1;
                    }
                }
                return;
            }
            this.f29818b.f29794j.i(new c(kotlin.jvm.internal.j.p(this.f29818b.L(), " ping"), true, this.f29818b, i10, i11), 0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            o();
            return Unit.f32013a;
        }

        public void j(int i10, int i11, int i12, boolean z10) {
        }

        public void k(int i10, ErrorCode errorCode) {
            kotlin.jvm.internal.j.g(errorCode, "errorCode");
            if (this.f29818b.B0(i10)) {
                this.f29818b.A0(i10, errorCode);
                return;
            }
            g E0 = this.f29818b.E0(i10);
            if (E0 != null) {
                E0.y(errorCode);
            }
        }

        public void m(int i10, ErrorCode errorCode, ByteString byteString) {
            int i11;
            Object[] array2;
            kotlin.jvm.internal.j.g(errorCode, "errorCode");
            kotlin.jvm.internal.j.g(byteString, "debugData");
            byteString.H();
            d dVar = this.f29818b;
            synchronized (dVar) {
                i11 = 0;
                array2 = dVar.f0().values().toArray(new g[0]);
                if (array2 != null) {
                    dVar.f29792g = true;
                    Unit unit = Unit.f32013a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
            g[] gVarArr = (g[]) array2;
            int length = gVarArr.length;
            while (i11 < length) {
                g gVar = gVarArr[i11];
                i11++;
                if (gVar.j() > i10 && gVar.t()) {
                    gVar.y(ErrorCode.REFUSED_STREAM);
                    this.f29818b.E0(gVar.j());
                }
            }
        }

        public final void n(boolean z10, T t10) {
            long c10;
            int i10;
            g[] gVarArr;
            kotlin.jvm.internal.j.g(t10, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            h q02 = this.f29818b.q0();
            d dVar = this.f29818b;
            synchronized (q02) {
                synchronized (dVar) {
                    k Y = dVar.Y();
                    if (!z10) {
                        T kVar = new k();
                        kVar.g(Y);
                        kVar.g(t10);
                        t10 = kVar;
                    }
                    ref$ObjectRef.element = t10;
                    c10 = ((long) t10.c()) - ((long) Y.c());
                    i10 = 0;
                    if (c10 != 0) {
                        if (!dVar.f0().isEmpty()) {
                            Object[] array2 = dVar.f0().values().toArray(new g[0]);
                            if (array2 != null) {
                                gVarArr = (g[]) array2;
                                dVar.Q0((k) ref$ObjectRef.element);
                                dVar.f29796l.i(new a(kotlin.jvm.internal.j.p(dVar.L(), " onSettings"), true, dVar, ref$ObjectRef), 0);
                                Unit unit = Unit.f32013a;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            }
                        }
                    }
                    gVarArr = null;
                    dVar.Q0((k) ref$ObjectRef.element);
                    dVar.f29796l.i(new a(kotlin.jvm.internal.j.p(dVar.L(), " onSettings"), true, dVar, ref$ObjectRef), 0);
                    Unit unit2 = Unit.f32013a;
                }
                try {
                    dVar.q0().a((k) ref$ObjectRef.element);
                } catch (IOException e10) {
                    dVar.I(e10);
                }
                Unit unit3 = Unit.f32013a;
            }
            if (gVarArr != null) {
                int length = gVarArr.length;
                while (i10 < length) {
                    g gVar = gVarArr[i10];
                    i10++;
                    synchronized (gVar) {
                        gVar.a(c10);
                        Unit unit4 = Unit.f32013a;
                    }
                }
            }
        }

        public void o() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            e = null;
            try {
                this.f29817a.c(this);
                while (this.f29817a.b(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                try {
                    this.f29818b.G(errorCode, ErrorCode.CANCEL, (IOException) null);
                } catch (IOException e10) {
                    e = e10;
                    try {
                        ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                        this.f29818b.G(errorCode3, errorCode3, e);
                        bl.d.m(this.f29817a);
                    } catch (Throwable th2) {
                        th = th2;
                        this.f29818b.G(errorCode, errorCode2, e);
                        bl.d.m(this.f29817a);
                        throw th;
                    }
                }
            } catch (IOException e11) {
                e = e11;
                errorCode = errorCode2;
                ErrorCode errorCode32 = ErrorCode.PROTOCOL_ERROR;
                this.f29818b.G(errorCode32, errorCode32, e);
                bl.d.m(this.f29817a);
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                this.f29818b.G(errorCode, errorCode2, e);
                bl.d.m(this.f29817a);
                throw th;
            }
            bl.d.m(this.f29817a);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class e extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29837e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29838f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29839g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f29840h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Buffer f29841i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ int f29842j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ boolean f29843k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z10, d dVar, int i10, Buffer buffer, int i11, boolean z11) {
            super(str, z10);
            this.f29837e = str;
            this.f29838f = z10;
            this.f29839g = dVar;
            this.f29840h = i10;
            this.f29841i = buffer;
            this.f29842j = i11;
            this.f29843k = z11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long f() {
            /*
                r5 = this;
                hl.d r0 = r5.f29839g     // Catch:{ IOException -> 0x003e }
                hl.j r0 = r0.f29797m     // Catch:{ IOException -> 0x003e }
                int r1 = r5.f29840h     // Catch:{ IOException -> 0x003e }
                okio.Buffer r2 = r5.f29841i     // Catch:{ IOException -> 0x003e }
                int r3 = r5.f29842j     // Catch:{ IOException -> 0x003e }
                boolean r4 = r5.f29843k     // Catch:{ IOException -> 0x003e }
                boolean r0 = r0.d(r1, r2, r3, r4)     // Catch:{ IOException -> 0x003e }
                if (r0 == 0) goto L_0x0021
                hl.d r1 = r5.f29839g     // Catch:{ IOException -> 0x003e }
                hl.h r1 = r1.q0()     // Catch:{ IOException -> 0x003e }
                int r2 = r5.f29840h     // Catch:{ IOException -> 0x003e }
                okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x003e }
                r1.n(r2, r3)     // Catch:{ IOException -> 0x003e }
            L_0x0021:
                if (r0 != 0) goto L_0x0027
                boolean r0 = r5.f29843k     // Catch:{ IOException -> 0x003e }
                if (r0 == 0) goto L_0x003e
            L_0x0027:
                hl.d r0 = r5.f29839g     // Catch:{ IOException -> 0x003e }
                monitor-enter(r0)     // Catch:{ IOException -> 0x003e }
                hl.d r1 = r5.f29839g     // Catch:{ all -> 0x003b }
                java.util.Set r1 = r1.I     // Catch:{ all -> 0x003b }
                int r2 = r5.f29840h     // Catch:{ all -> 0x003b }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x003b }
                r1.remove(r2)     // Catch:{ all -> 0x003b }
                monitor-exit(r0)     // Catch:{ IOException -> 0x003e }
                goto L_0x003e
            L_0x003b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ IOException -> 0x003e }
                throw r1     // Catch:{ IOException -> 0x003e }
            L_0x003e:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: hl.d.e.f():long");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class f extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29844e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29845f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29846g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f29847h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ List f29848i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f29849j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z10, d dVar, int i10, List list, boolean z11) {
            super(str, z10);
            this.f29844e = str;
            this.f29845f = z10;
            this.f29846g = dVar;
            this.f29847h = i10;
            this.f29848i = list;
            this.f29849j = z11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long f() {
            /*
                r4 = this;
                hl.d r0 = r4.f29846g
                hl.j r0 = r0.f29797m
                int r1 = r4.f29847h
                java.util.List r2 = r4.f29848i
                boolean r3 = r4.f29849j
                boolean r0 = r0.c(r1, r2, r3)
                if (r0 == 0) goto L_0x001f
                hl.d r1 = r4.f29846g     // Catch:{ IOException -> 0x003c }
                hl.h r1 = r1.q0()     // Catch:{ IOException -> 0x003c }
                int r2 = r4.f29847h     // Catch:{ IOException -> 0x003c }
                okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x003c }
                r1.n(r2, r3)     // Catch:{ IOException -> 0x003c }
            L_0x001f:
                if (r0 != 0) goto L_0x0025
                boolean r0 = r4.f29849j     // Catch:{ IOException -> 0x003c }
                if (r0 == 0) goto L_0x003c
            L_0x0025:
                hl.d r0 = r4.f29846g     // Catch:{ IOException -> 0x003c }
                monitor-enter(r0)     // Catch:{ IOException -> 0x003c }
                hl.d r1 = r4.f29846g     // Catch:{ all -> 0x0039 }
                java.util.Set r1 = r1.I     // Catch:{ all -> 0x0039 }
                int r2 = r4.f29847h     // Catch:{ all -> 0x0039 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0039 }
                r1.remove(r2)     // Catch:{ all -> 0x0039 }
                monitor-exit(r0)     // Catch:{ IOException -> 0x003c }
                goto L_0x003c
            L_0x0039:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ IOException -> 0x003c }
                throw r1     // Catch:{ IOException -> 0x003c }
            L_0x003c:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: hl.d.f.f():long");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class g extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29850e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29851f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29852g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f29853h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ List f29854i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z10, d dVar, int i10, List list) {
            super(str, z10);
            this.f29850e = str;
            this.f29851f = z10;
            this.f29852g = dVar;
            this.f29853h = i10;
            this.f29854i = list;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long f() {
            /*
                r3 = this;
                hl.d r0 = r3.f29852g
                hl.j r0 = r0.f29797m
                int r1 = r3.f29853h
                java.util.List r2 = r3.f29854i
                boolean r0 = r0.b(r1, r2)
                if (r0 == 0) goto L_0x0034
                hl.d r0 = r3.f29852g     // Catch:{ IOException -> 0x0034 }
                hl.h r0 = r0.q0()     // Catch:{ IOException -> 0x0034 }
                int r1 = r3.f29853h     // Catch:{ IOException -> 0x0034 }
                okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0034 }
                r0.n(r1, r2)     // Catch:{ IOException -> 0x0034 }
                hl.d r0 = r3.f29852g     // Catch:{ IOException -> 0x0034 }
                monitor-enter(r0)     // Catch:{ IOException -> 0x0034 }
                hl.d r1 = r3.f29852g     // Catch:{ all -> 0x0031 }
                java.util.Set r1 = r1.I     // Catch:{ all -> 0x0031 }
                int r2 = r3.f29853h     // Catch:{ all -> 0x0031 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0031 }
                r1.remove(r2)     // Catch:{ all -> 0x0031 }
                monitor-exit(r0)     // Catch:{ IOException -> 0x0034 }
                goto L_0x0034
            L_0x0031:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ IOException -> 0x0034 }
                throw r1     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: hl.d.g.f():long");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class h extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29855e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29856f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29857g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f29858h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ErrorCode f29859i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z10, d dVar, int i10, ErrorCode errorCode) {
            super(str, z10);
            this.f29855e = str;
            this.f29856f = z10;
            this.f29857g = dVar;
            this.f29858h = i10;
            this.f29859i = errorCode;
        }

        public long f() {
            this.f29857g.f29797m.a(this.f29858h, this.f29859i);
            synchronized (this.f29857g) {
                this.f29857g.I.remove(Integer.valueOf(this.f29858h));
                Unit unit = Unit.f32013a;
            }
            return -1;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class i extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29860e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29861f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29862g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z10, d dVar) {
            super(str, z10);
            this.f29860e = str;
            this.f29861f = z10;
            this.f29862g = dVar;
        }

        public long f() {
            this.f29862g.c1(false, 2, 0);
            return -1;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"hl/d$j", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class j extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29863e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ d f29864f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f29865g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str, d dVar, long j10) {
            super(str, false, 2, (DefaultConstructorMarker) null);
            this.f29863e = str;
            this.f29864f = dVar;
            this.f29865g = j10;
        }

        public long f() {
            boolean z10;
            synchronized (this.f29864f) {
                if (this.f29864f.f29799p < this.f29864f.f29798n) {
                    z10 = true;
                } else {
                    this.f29864f.f29798n = this.f29864f.f29798n + 1;
                    z10 = false;
                }
            }
            if (z10) {
                this.f29864f.I((IOException) null);
                return -1;
            }
            this.f29864f.c1(false, 1, 0);
            return this.f29865g;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class k extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29866e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29867f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29868g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f29869h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ErrorCode f29870i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z10, d dVar, int i10, ErrorCode errorCode) {
            super(str, z10);
            this.f29866e = str;
            this.f29867f = z10;
            this.f29868g = dVar;
            this.f29869h = i10;
            this.f29870i = errorCode;
        }

        public long f() {
            try {
                this.f29868g.d1(this.f29869h, this.f29870i);
                return -1;
            } catch (IOException e10) {
                this.f29868g.I(e10);
                return -1;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"el/c", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class l extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f29871e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f29872f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d f29873g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f29874h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ long f29875i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z10, d dVar, int i10, long j10) {
            super(str, z10);
            this.f29871e = str;
            this.f29872f = z10;
            this.f29873g = dVar;
            this.f29874h = i10;
            this.f29875i = j10;
        }

        public long f() {
            try {
                this.f29873g.q0().v(this.f29874h, this.f29875i);
                return -1;
            } catch (IOException e10) {
                this.f29873g.I(e10);
                return -1;
            }
        }
    }

    static {
        k kVar = new k();
        kVar.h(7, 65535);
        kVar.h(5, Opcodes.ACC_ENUM);
        K = kVar;
    }

    public d(a aVar) {
        int i10;
        kotlin.jvm.internal.j.g(aVar, "builder");
        boolean b10 = aVar.b();
        this.f29786a = b10;
        this.f29787b = aVar.d();
        String c10 = aVar.c();
        this.f29789d = c10;
        if (aVar.b()) {
            i10 = 3;
        } else {
            i10 = 2;
        }
        this.f29791f = i10;
        el.e j10 = aVar.j();
        this.f29793h = j10;
        el.d i11 = j10.i();
        this.f29794j = i11;
        this.f29795k = j10.i();
        this.f29796l = j10.i();
        this.f29797m = aVar.f();
        k kVar = new k();
        if (aVar.b()) {
            kVar.h(7, 16777216);
        }
        this.f29804y = kVar;
        k kVar2 = K;
        this.f29805z = kVar2;
        this.E = (long) kVar2.c();
        this.F = aVar.h();
        this.G = new h(aVar.g(), b10);
        this.H = new C0347d(this, new f(aVar.i(), b10));
        this.I = new LinkedHashSet();
        if (aVar.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) aVar.e());
            i11.i(new j(kotlin.jvm.internal.j.p(c10, " ping"), this, nanos), nanos);
        }
    }

    /* access modifiers changed from: private */
    public final void I(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        G(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void U0(d dVar, boolean z10, el.e eVar, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            eVar = el.e.f29630i;
        }
        dVar.S0(z10, eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final hl.g s0(int r11, java.util.List<hl.a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            hl.h r7 = r10.G
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0099 }
            int r0 = r10.P()     // Catch:{ all -> 0x0096 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0015
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0096 }
            r10.R0(r0)     // Catch:{ all -> 0x0096 }
        L_0x0015:
            boolean r0 = r10.f29792g     // Catch:{ all -> 0x0096 }
            if (r0 != 0) goto L_0x0090
            int r8 = r10.P()     // Catch:{ all -> 0x0096 }
            int r0 = r10.P()     // Catch:{ all -> 0x0096 }
            int r0 = r0 + 2
            r10.N0(r0)     // Catch:{ all -> 0x0096 }
            hl.g r9 = new hl.g     // Catch:{ all -> 0x0096 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0096 }
            r0 = 1
            if (r13 == 0) goto L_0x004e
            long r1 = r10.m0()     // Catch:{ all -> 0x0096 }
            long r3 = r10.i0()     // Catch:{ all -> 0x0096 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x004e
            long r1 = r9.r()     // Catch:{ all -> 0x0096 }
            long r3 = r9.q()     // Catch:{ all -> 0x0096 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r13 = 0
            goto L_0x004f
        L_0x004e:
            r13 = r0
        L_0x004f:
            boolean r1 = r9.u()     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0060
            java.util.Map r1 = r10.f0()     // Catch:{ all -> 0x0096 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0096 }
            r1.put(r2, r9)     // Catch:{ all -> 0x0096 }
        L_0x0060:
            kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0096 }
            monitor-exit(r10)     // Catch:{ all -> 0x0099 }
            if (r11 != 0) goto L_0x006d
            hl.h r11 = r10.q0()     // Catch:{ all -> 0x0099 }
            r11.h(r6, r8, r12)     // Catch:{ all -> 0x0099 }
            goto L_0x007b
        L_0x006d:
            boolean r1 = r10.J()     // Catch:{ all -> 0x0099 }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0084
            hl.h r0 = r10.q0()     // Catch:{ all -> 0x0099 }
            r0.m(r11, r8, r12)     // Catch:{ all -> 0x0099 }
        L_0x007b:
            monitor-exit(r7)
            if (r13 == 0) goto L_0x0083
            hl.h r11 = r10.G
            r11.flush()
        L_0x0083:
            return r9
        L_0x0084:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0099 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0099 }
            r12.<init>(r11)     // Catch:{ all -> 0x0099 }
            throw r12     // Catch:{ all -> 0x0099 }
        L_0x0090:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0096 }
            r11.<init>()     // Catch:{ all -> 0x0096 }
            throw r11     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0099 }
            throw r11     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.d.s0(int, java.util.List, boolean):hl.g");
    }

    public final void A0(int i10, ErrorCode errorCode) {
        kotlin.jvm.internal.j.g(errorCode, "errorCode");
        el.d dVar = this.f29795k;
        dVar.i(new h(this.f29789d + '[' + i10 + "] onReset", true, this, i10, errorCode), 0);
    }

    public final boolean B0(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public final synchronized g E0(int i10) {
        g remove;
        remove = this.f29788c.remove(Integer.valueOf(i10));
        notifyAll();
        return remove;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0088 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(okhttp3.internal.http2.ErrorCode r4, okhttp3.internal.http2.ErrorCode r5, java.io.IOException r6) {
        /*
            r3 = this;
            java.lang.String r0 = "connectionCode"
            kotlin.jvm.internal.j.g(r4, r0)
            java.lang.String r0 = "streamCode"
            kotlin.jvm.internal.j.g(r5, r0)
            boolean r0 = bl.d.f24935h
            if (r0 == 0) goto L_0x003c
            boolean r0 = java.lang.Thread.holdsLock(r3)
            if (r0 != 0) goto L_0x0015
            goto L_0x003c
        L_0x0015:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Thread "
            r5.append(r6)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.String r6 = r6.getName()
            r5.append(r6)
            java.lang.String r6 = " MUST NOT hold lock on "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x003c:
            r3.R0(r4)     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            r4 = 0
            monitor-enter(r3)
            java.util.Map r0 = r3.f0()     // Catch:{ all -> 0x009f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x009f }
            r0 = r0 ^ 1
            r1 = 0
            if (r0 == 0) goto L_0x006e
            java.util.Map r4 = r3.f0()     // Catch:{ all -> 0x009f }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x009f }
            hl.g[] r0 = new hl.g[r1]     // Catch:{ all -> 0x009f }
            java.lang.Object[] r4 = r4.toArray(r0)     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0066
            java.util.Map r0 = r3.f0()     // Catch:{ all -> 0x009f }
            r0.clear()     // Catch:{ all -> 0x009f }
            goto L_0x006e
        L_0x0066:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ all -> 0x009f }
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r4.<init>(r5)     // Catch:{ all -> 0x009f }
            throw r4     // Catch:{ all -> 0x009f }
        L_0x006e:
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x009f }
            monitor-exit(r3)
            hl.g[] r4 = (hl.g[]) r4
            if (r4 != 0) goto L_0x0076
            goto L_0x0081
        L_0x0076:
            int r0 = r4.length
        L_0x0077:
            if (r1 >= r0) goto L_0x0081
            r2 = r4[r1]
            r2.d(r5, r6)     // Catch:{ IOException -> 0x007e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x0077
        L_0x0081:
            hl.h r4 = r3.q0()     // Catch:{ IOException -> 0x0088 }
            r4.close()     // Catch:{ IOException -> 0x0088 }
        L_0x0088:
            java.net.Socket r4 = r3.c0()     // Catch:{ IOException -> 0x008f }
            r4.close()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            el.d r4 = r3.f29794j
            r4.o()
            el.d r4 = r3.f29795k
            r4.o()
            el.d r4 = r3.f29796l
            r4.o()
            return
        L_0x009f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.d.G(okhttp3.internal.http2.ErrorCode, okhttp3.internal.http2.ErrorCode, java.io.IOException):void");
    }

    public final void H0() {
        synchronized (this) {
            long j10 = this.f29801t;
            long j11 = this.f29800q;
            if (j10 >= j11) {
                this.f29800q = j11 + 1;
                this.f29803x = System.nanoTime() + ((long) 1000000000);
                Unit unit = Unit.f32013a;
                this.f29794j.i(new i(kotlin.jvm.internal.j.p(this.f29789d, " ping"), true, this), 0);
            }
        }
    }

    public final void I0(int i10) {
        this.f29790e = i10;
    }

    public final boolean J() {
        return this.f29786a;
    }

    public final String L() {
        return this.f29789d;
    }

    public final int N() {
        return this.f29790e;
    }

    public final void N0(int i10) {
        this.f29791f = i10;
    }

    public final c O() {
        return this.f29787b;
    }

    public final int P() {
        return this.f29791f;
    }

    public final void Q0(k kVar) {
        kotlin.jvm.internal.j.g(kVar, "<set-?>");
        this.f29805z = kVar;
    }

    public final void R0(ErrorCode errorCode) throws IOException {
        kotlin.jvm.internal.j.g(errorCode, "statusCode");
        synchronized (this.G) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (!this.f29792g) {
                    this.f29792g = true;
                    ref$IntRef.element = N();
                    Unit unit = Unit.f32013a;
                    q0().g(ref$IntRef.element, errorCode, bl.d.f24928a);
                }
            }
        }
    }

    public final k S() {
        return this.f29804y;
    }

    public final void S0(boolean z10, el.e eVar) throws IOException {
        kotlin.jvm.internal.j.g(eVar, "taskRunner");
        if (z10) {
            this.G.b();
            this.G.u(this.f29804y);
            int c10 = this.f29804y.c();
            if (c10 != 65535) {
                this.G.v(0, (long) (c10 - 65535));
            }
        }
        eVar.i().i(new el.c(this.f29789d, true, this.H), 0);
    }

    public final synchronized void W0(long j10) {
        long j11 = this.B + j10;
        this.B = j11;
        long j12 = j11 - this.C;
        if (j12 >= ((long) (this.f29804y.c() / 2))) {
            g1(0, j12);
            this.C += j12;
        }
    }

    public final k Y() {
        return this.f29805z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, i0() - m0()), q0().k());
        r6 = (long) r2;
        r8.D = m0() + r6;
        r4 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a1(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            hl.h r12 = r8.G
            r12.c(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x007e
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.m0()     // Catch:{ InterruptedException -> 0x006f }
            long r6 = r8.i0()     // Catch:{ InterruptedException -> 0x006f }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0038
            java.util.Map r2 = r8.f0()     // Catch:{ InterruptedException -> 0x006f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x006f }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x006f }
            if (r2 == 0) goto L_0x0030
            r8.wait()     // Catch:{ InterruptedException -> 0x006f }
            goto L_0x0012
        L_0x0030:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x006f }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x006f }
            throw r9     // Catch:{ InterruptedException -> 0x006f }
        L_0x0038:
            long r4 = r8.i0()     // Catch:{ all -> 0x006d }
            long r6 = r8.m0()     // Catch:{ all -> 0x006d }
            long r4 = r4 - r6
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x006d }
            int r2 = (int) r4     // Catch:{ all -> 0x006d }
            hl.h r4 = r8.q0()     // Catch:{ all -> 0x006d }
            int r4 = r4.k()     // Catch:{ all -> 0x006d }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x006d }
            long r4 = r8.m0()     // Catch:{ all -> 0x006d }
            long r6 = (long) r2     // Catch:{ all -> 0x006d }
            long r4 = r4 + r6
            r8.D = r4     // Catch:{ all -> 0x006d }
            kotlin.Unit r4 = kotlin.Unit.f32013a     // Catch:{ all -> 0x006d }
            monitor-exit(r8)
            long r12 = r12 - r6
            hl.h r4 = r8.G
            if (r10 == 0) goto L_0x0068
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0068
            r5 = 1
            goto L_0x0069
        L_0x0068:
            r5 = r3
        L_0x0069:
            r4.c(r5, r9, r11, r2)
            goto L_0x000d
        L_0x006d:
            r9 = move-exception
            goto L_0x007c
        L_0x006f:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x006d }
            r9.interrupt()     // Catch:{ all -> 0x006d }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x006d }
            r9.<init>()     // Catch:{ all -> 0x006d }
            throw r9     // Catch:{ all -> 0x006d }
        L_0x007c:
            monitor-exit(r8)
            throw r9
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.d.a1(int, boolean, okio.Buffer, long):void");
    }

    public final void b1(int i10, boolean z10, List<a> list) throws IOException {
        kotlin.jvm.internal.j.g(list, "alternating");
        this.G.h(z10, i10, list);
    }

    public final Socket c0() {
        return this.F;
    }

    public final void c1(boolean z10, int i10, int i11) {
        try {
            this.G.l(z10, i10, i11);
        } catch (IOException e10) {
            I(e10);
        }
    }

    public void close() {
        G(ErrorCode.NO_ERROR, ErrorCode.CANCEL, (IOException) null);
    }

    public final void d1(int i10, ErrorCode errorCode) throws IOException {
        kotlin.jvm.internal.j.g(errorCode, "statusCode");
        this.G.n(i10, errorCode);
    }

    public final synchronized g e0(int i10) {
        return this.f29788c.get(Integer.valueOf(i10));
    }

    public final void e1(int i10, ErrorCode errorCode) {
        kotlin.jvm.internal.j.g(errorCode, "errorCode");
        el.d dVar = this.f29794j;
        dVar.i(new k(this.f29789d + '[' + i10 + "] writeSynReset", true, this, i10, errorCode), 0);
    }

    public final Map<Integer, g> f0() {
        return this.f29788c;
    }

    public final void flush() throws IOException {
        this.G.flush();
    }

    public final void g1(int i10, long j10) {
        el.d dVar = this.f29794j;
        dVar.i(new l(this.f29789d + '[' + i10 + "] windowUpdate", true, this, i10, j10), 0);
    }

    public final long i0() {
        return this.E;
    }

    public final long m0() {
        return this.D;
    }

    public final h q0() {
        return this.G;
    }

    public final synchronized boolean r0(long j10) {
        if (this.f29792g) {
            return false;
        }
        if (this.f29801t >= this.f29800q || j10 < this.f29803x) {
            return true;
        }
        return false;
    }

    public final g t0(List<a> list, boolean z10) throws IOException {
        kotlin.jvm.internal.j.g(list, "requestHeaders");
        return s0(0, list, z10);
    }

    public final void u0(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException {
        kotlin.jvm.internal.j.g(bufferedSource, "source");
        Buffer buffer = new Buffer();
        long j10 = (long) i11;
        bufferedSource.G0(j10);
        bufferedSource.N1(buffer, j10);
        el.d dVar = this.f29795k;
        dVar.i(new e(this.f29789d + '[' + i10 + "] onData", true, this, i10, buffer, i11, z10), 0);
    }

    public final void v0(int i10, List<a> list, boolean z10) {
        kotlin.jvm.internal.j.g(list, "requestHeaders");
        el.d dVar = this.f29795k;
        dVar.i(new f(this.f29789d + '[' + i10 + "] onHeaders", true, this, i10, list, z10), 0);
    }

    public final void x0(int i10, List<a> list) {
        kotlin.jvm.internal.j.g(list, "requestHeaders");
        synchronized (this) {
            if (this.I.contains(Integer.valueOf(i10))) {
                e1(i10, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.I.add(Integer.valueOf(i10));
            el.d dVar = this.f29795k;
            dVar.i(new g(this.f29789d + '[' + i10 + "] onRequest", true, this, i10, list), 0);
        }
    }
}
