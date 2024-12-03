package okio;

import androidx.camera.view.h;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0002R\u001a\u0010\r\u001a\u00020\t8\u0006XD¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lokio/SegmentPool;", "", "Lokio/Segment;", "c", "segment", "", "b", "Ljava/util/concurrent/atomic/AtomicReference;", "a", "", "I", "getMAX_SIZE", "()I", "MAX_SIZE", "Lokio/Segment;", "LOCK", "d", "HASH_BUCKET_COUNT", "", "e", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
public final class SegmentPool {

    /* renamed from: a  reason: collision with root package name */
    public static final SegmentPool f33415a = new SegmentPool();

    /* renamed from: b  reason: collision with root package name */
    private static final int f33416b = 65536;

    /* renamed from: c  reason: collision with root package name */
    private static final Segment f33417c = new Segment(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    private static final int f33418d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference<Segment>[] f33419e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f33418d = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i10 = 0; i10 < highestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f33419e = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> a() {
        return f33419e[(int) (Thread.currentThread().getId() & (((long) f33418d) - 1))];
    }

    public static final void b(Segment segment) {
        boolean z10;
        AtomicReference<Segment> a10;
        Segment segment2;
        int i10;
        j.g(segment, "segment");
        if (segment.f33413f == null && segment.f33414g == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.f33411d && (segment2 = a10.get()) != f33417c) {
            if (segment2 != null) {
                i10 = segment2.f33410c;
            } else {
                i10 = 0;
            }
            if (i10 < f33416b) {
                segment.f33413f = segment2;
                segment.f33409b = 0;
                segment.f33410c = i10 + 8192;
                if (!h.a((a10 = f33415a.a()), segment2, segment)) {
                    segment.f33413f = null;
                }
            }
        }
    }

    public static final Segment c() {
        AtomicReference<Segment> a10 = f33415a.a();
        Segment segment = f33417c;
        Segment andSet = a10.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            a10.set((Object) null);
            return new Segment();
        }
        a10.set(andSet.f33413f);
        andSet.f33413f = null;
        andSet.f33410c = 0;
        return andSet;
    }
}
