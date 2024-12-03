package v;

import android.graphics.Rect;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.e0;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import u.f;
import zf.a;

public class m implements e0 {

    /* renamed from: k  reason: collision with root package name */
    private static final Rect f18043k = new Rect(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f18044a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f18045b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private int f18046c;

    /* renamed from: d  reason: collision with root package name */
    private int f18047d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18048e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f18049f = 0;

    /* renamed from: g  reason: collision with root package name */
    private ImageWriter f18050g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f18051h = f18043k;

    /* renamed from: i  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f18052i;

    /* renamed from: j  reason: collision with root package name */
    private a<Void> f18053j;

    public m(int i10, int i11) {
        this.f18046c = i10;
        this.f18044a = i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object f(CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.f18045b) {
            this.f18052i = aVar;
        }
        return "YuvToJpegProcessor-close";
    }

    public void a(@NonNull Surface surface, int i10) {
        boolean z10;
        if (i10 == 256) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.j(z10, "YuvToJpegProcessor only supports JPEG output format.");
        synchronized (this.f18045b) {
            if (this.f18048e) {
                v1.l("YuvToJpegProcessor", "Cannot set output surface. Processor is closed.");
            } else if (this.f18050g == null) {
                this.f18050g = w.a.d(surface, this.f18044a, i10);
            } else {
                throw new IllegalStateException("Output surface already set.");
            }
        }
    }

    @NonNull
    public a<Void> b() {
        a<Void> aVar;
        synchronized (this.f18045b) {
            if (!this.f18048e || this.f18049f != 0) {
                if (this.f18053j == null) {
                    this.f18053j = CallbackToFutureAdapter.a(new l(this));
                }
                aVar = f.j(this.f18053j);
            } else {
                aVar = f.h(null);
            }
        }
        return aVar;
    }

    public void c(@NonNull Size size) {
        synchronized (this.f18045b) {
            this.f18051h = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r1.c(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f18045b
            monitor-enter(r0)
            boolean r1 = r4.f18048e     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0009:
            r1 = 1
            r4.f18048e = r1     // Catch:{ all -> 0x0033 }
            int r1 = r4.f18049f     // Catch:{ all -> 0x0033 }
            r2 = 0
            if (r1 != 0) goto L_0x0024
            android.media.ImageWriter r1 = r4.f18050g     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = "YuvToJpegProcessor"
            java.lang.String r3 = "No processing in progress. Closing immediately."
            androidx.camera.core.v1.a(r1, r3)     // Catch:{ all -> 0x0033 }
            android.media.ImageWriter r1 = r4.f18050g     // Catch:{ all -> 0x0033 }
            r1.close()     // Catch:{ all -> 0x0033 }
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r1 = r4.f18052i     // Catch:{ all -> 0x0033 }
            goto L_0x002c
        L_0x0024:
            java.lang.String r1 = "YuvToJpegProcessor"
            java.lang.String r3 = "close() called while processing. Will close after completion."
            androidx.camera.core.v1.a(r1, r3)     // Catch:{ all -> 0x0033 }
            r1 = r2
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0032
            r1.c(r2)
        L_0x0032:
            return
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v.m.close():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0143  */
    public void d(@androidx.annotation.NonNull androidx.camera.core.impl.w0 r20) {
        /*
            r19 = this;
            r1 = r19
            java.util.List r0 = r20.a()
            int r2 = r0.size()
            r3 = 0
            r4 = 1
            if (r2 != r4) goto L_0x0010
            r2 = r4
            goto L_0x0011
        L_0x0010:
            r2 = r3
        L_0x0011:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Processing image bundle have single capture id, but found "
            r5.append(r6)
            int r6 = r0.size()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            androidx.core.util.h.b(r2, r5)
            java.lang.Object r0 = r0.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2 = r20
            zf.a r0 = r2.b(r0)
            boolean r2 = r0.isDone()
            androidx.core.util.h.a(r2)
            java.lang.Object r2 = r1.f18045b
            monitor-enter(r2)
            android.media.ImageWriter r5 = r1.f18050g     // Catch:{ all -> 0x01ce }
            boolean r6 = r1.f18048e     // Catch:{ all -> 0x01ce }
            if (r6 != 0) goto L_0x004b
            r6 = r4
            goto L_0x004c
        L_0x004b:
            r6 = r3
        L_0x004c:
            android.graphics.Rect r7 = r1.f18051h     // Catch:{ all -> 0x01ce }
            if (r6 == 0) goto L_0x0055
            int r8 = r1.f18049f     // Catch:{ all -> 0x01ce }
            int r8 = r8 + r4
            r1.f18049f = r8     // Catch:{ all -> 0x01ce }
        L_0x0055:
            int r8 = r1.f18046c     // Catch:{ all -> 0x01ce }
            int r9 = r1.f18047d     // Catch:{ all -> 0x01ce }
            monitor-exit(r2)     // Catch:{ all -> 0x01ce }
            r2 = 0
            java.lang.Object r10 = r0.get()     // Catch:{ Exception -> 0x013e, all -> 0x013a }
            androidx.camera.core.o1 r10 = (androidx.camera.core.o1) r10     // Catch:{ Exception -> 0x013e, all -> 0x013a }
            if (r6 != 0) goto L_0x0099
            java.lang.String r0 = "YuvToJpegProcessor"
            java.lang.String r7 = "Image enqueued for processing on closed processor."
            androidx.camera.core.v1.l(r0, r7)     // Catch:{ Exception -> 0x0137, all -> 0x0134 }
            r10.close()     // Catch:{ Exception -> 0x0137, all -> 0x0134 }
            java.lang.Object r7 = r1.f18045b
            monitor-enter(r7)
            if (r6 == 0) goto L_0x0082
            int r0 = r1.f18049f     // Catch:{ all -> 0x0080 }
            int r6 = r0 + -1
            r1.f18049f = r6     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0082
            boolean r0 = r1.f18048e     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0082
            r3 = r4
            goto L_0x0082
        L_0x0080:
            r0 = move-exception
            goto L_0x0097
        L_0x0082:
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r1.f18052i     // Catch:{ all -> 0x0080 }
            monitor-exit(r7)     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x0096
            r5.close()
            java.lang.String r3 = "YuvToJpegProcessor"
            java.lang.String r4 = "Closed after completion of last image processed."
            androidx.camera.core.v1.a(r3, r4)
            if (r0 == 0) goto L_0x0096
            r0.c(r2)
        L_0x0096:
            return
        L_0x0097:
            monitor-exit(r7)     // Catch:{ all -> 0x0080 }
            throw r0
        L_0x0099:
            android.media.Image r11 = r5.dequeueInputImage()     // Catch:{ Exception -> 0x0137, all -> 0x0134 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0132 }
            r12 = r0
            androidx.camera.core.o1 r12 = (androidx.camera.core.o1) r12     // Catch:{ Exception -> 0x0132 }
            int r0 = r12.getFormat()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r10 = 35
            if (r0 != r10) goto L_0x00ae
            r0 = r4
            goto L_0x00af
        L_0x00ae:
            r0 = r3
        L_0x00af:
            java.lang.String r10 = "Input image is not expected YUV_420_888 image format"
            androidx.core.util.h.j(r0, r10)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            byte[] r14 = androidx.camera.core.internal.utils.ImageUtil.q(r12)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            android.graphics.YuvImage r0 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r15 = 17
            int r16 = r12.getWidth()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            int r17 = r12.getHeight()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r18 = 0
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            android.media.Image$Plane[] r10 = r11.getPlanes()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r10 = r10[r3]     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            java.nio.ByteBuffer r10 = r10.getBuffer()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            int r13 = r10.position()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            androidx.camera.core.impl.utils.k r14 = new androidx.camera.core.impl.utils.k     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            v.b r15 = new v.b     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r15.<init>(r10)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            androidx.camera.core.impl.utils.ExifData r9 = androidx.camera.core.impl.utils.ExifData.b(r12, r9)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r14.<init>(r15, r9)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r0.compressToJpeg(r7, r8, r14)     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            r12.close()     // Catch:{ Exception -> 0x012f, all -> 0x012c }
            int r0 = r10.position()     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r10.limit(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r10.position(r13)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            r5.queueInputImage(r11)     // Catch:{ Exception -> 0x0129, all -> 0x0126 }
            java.lang.Object r7 = r1.f18045b
            monitor-enter(r7)
            if (r6 == 0) goto L_0x010e
            int r0 = r1.f18049f     // Catch:{ all -> 0x010c }
            int r6 = r0 + -1
            r1.f18049f = r6     // Catch:{ all -> 0x010c }
            if (r0 != 0) goto L_0x010e
            boolean r0 = r1.f18048e     // Catch:{ all -> 0x010c }
            if (r0 == 0) goto L_0x010e
            r3 = r4
            goto L_0x010e
        L_0x010c:
            r0 = move-exception
            goto L_0x0124
        L_0x010e:
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r1.f18052i     // Catch:{ all -> 0x010c }
            monitor-exit(r7)     // Catch:{ all -> 0x010c }
            if (r3 == 0) goto L_0x01cb
            r5.close()
            java.lang.String r3 = "YuvToJpegProcessor"
            java.lang.String r4 = "Closed after completion of last image processed."
            androidx.camera.core.v1.a(r3, r4)
            if (r0 == 0) goto L_0x01cb
        L_0x011f:
            r0.c(r2)
            goto L_0x01cb
        L_0x0124:
            monitor-exit(r7)     // Catch:{ all -> 0x010c }
            throw r0
        L_0x0126:
            r0 = move-exception
            r10 = r2
            goto L_0x0163
        L_0x0129:
            r0 = move-exception
            r10 = r2
            goto L_0x0141
        L_0x012c:
            r0 = move-exception
            r10 = r12
            goto L_0x0163
        L_0x012f:
            r0 = move-exception
            r10 = r12
            goto L_0x0141
        L_0x0132:
            r0 = move-exception
            goto L_0x0141
        L_0x0134:
            r0 = move-exception
            r11 = r2
            goto L_0x0163
        L_0x0137:
            r0 = move-exception
            r11 = r2
            goto L_0x0141
        L_0x013a:
            r0 = move-exception
            r10 = r2
            r11 = r10
            goto L_0x0163
        L_0x013e:
            r0 = move-exception
            r10 = r2
            r11 = r10
        L_0x0141:
            if (r6 == 0) goto L_0x0199
            java.lang.String r7 = "YuvToJpegProcessor"
            java.lang.String r8 = "Failed to process YUV -> JPEG"
            androidx.camera.core.v1.d(r7, r8, r0)     // Catch:{ all -> 0x0162 }
            android.media.Image r11 = r5.dequeueInputImage()     // Catch:{ all -> 0x0162 }
            android.media.Image$Plane[] r0 = r11.getPlanes()     // Catch:{ all -> 0x0162 }
            r0 = r0[r3]     // Catch:{ all -> 0x0162 }
            java.nio.ByteBuffer r0 = r0.getBuffer()     // Catch:{ all -> 0x0162 }
            r0.rewind()     // Catch:{ all -> 0x0162 }
            r0.limit(r3)     // Catch:{ all -> 0x0162 }
            r5.queueInputImage(r11)     // Catch:{ all -> 0x0162 }
            goto L_0x0199
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            java.lang.Object r7 = r1.f18045b
            monitor-enter(r7)
            if (r6 == 0) goto L_0x0178
            int r6 = r1.f18049f     // Catch:{ all -> 0x0176 }
            int r8 = r6 + -1
            r1.f18049f = r8     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x0178
            boolean r6 = r1.f18048e     // Catch:{ all -> 0x0176 }
            if (r6 == 0) goto L_0x0178
            r3 = r4
            goto L_0x0178
        L_0x0176:
            r0 = move-exception
            goto L_0x0197
        L_0x0178:
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r4 = r1.f18052i     // Catch:{ all -> 0x0176 }
            monitor-exit(r7)     // Catch:{ all -> 0x0176 }
            if (r11 == 0) goto L_0x0180
            r11.close()
        L_0x0180:
            if (r10 == 0) goto L_0x0185
            r10.close()
        L_0x0185:
            if (r3 == 0) goto L_0x0196
            r5.close()
            java.lang.String r3 = "YuvToJpegProcessor"
            java.lang.String r5 = "Closed after completion of last image processed."
            androidx.camera.core.v1.a(r3, r5)
            if (r4 == 0) goto L_0x0196
            r4.c(r2)
        L_0x0196:
            throw r0
        L_0x0197:
            monitor-exit(r7)     // Catch:{ all -> 0x0176 }
            throw r0
        L_0x0199:
            java.lang.Object r7 = r1.f18045b
            monitor-enter(r7)
            if (r6 == 0) goto L_0x01ae
            int r0 = r1.f18049f     // Catch:{ all -> 0x01ac }
            int r6 = r0 + -1
            r1.f18049f = r6     // Catch:{ all -> 0x01ac }
            if (r0 != 0) goto L_0x01ae
            boolean r0 = r1.f18048e     // Catch:{ all -> 0x01ac }
            if (r0 == 0) goto L_0x01ae
            r3 = r4
            goto L_0x01ae
        L_0x01ac:
            r0 = move-exception
            goto L_0x01cc
        L_0x01ae:
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r1.f18052i     // Catch:{ all -> 0x01ac }
            monitor-exit(r7)     // Catch:{ all -> 0x01ac }
            if (r11 == 0) goto L_0x01b6
            r11.close()
        L_0x01b6:
            if (r10 == 0) goto L_0x01bb
            r10.close()
        L_0x01bb:
            if (r3 == 0) goto L_0x01cb
            r5.close()
            java.lang.String r3 = "YuvToJpegProcessor"
            java.lang.String r4 = "Closed after completion of last image processed."
            androidx.camera.core.v1.a(r3, r4)
            if (r0 == 0) goto L_0x01cb
            goto L_0x011f
        L_0x01cb:
            return
        L_0x01cc:
            monitor-exit(r7)     // Catch:{ all -> 0x01ac }
            throw r0
        L_0x01ce:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x01ce }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v.m.d(androidx.camera.core.impl.w0):void");
    }

    public void g(int i10) {
        synchronized (this.f18045b) {
            this.f18046c = i10;
        }
    }

    public void h(int i10) {
        synchronized (this.f18045b) {
            this.f18047d = i10;
        }
    }
}
