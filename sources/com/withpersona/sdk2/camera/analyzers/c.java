package com.withpersona.sdk2.camera.analyzers;

import android.graphics.Rect;
import android.media.Image;
import android.util.Size;
import com.withpersona.sdk2.camera.ImageLightCondition;
import com.withpersona.sdk2.camera.analyzers.a;
import com.withpersona.sdk2.camera.s;
import java.nio.ByteBuffer;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class c implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f14247c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14248a = new byte[32768];

    /* renamed from: b  reason: collision with root package name */
    private final Size f14249b = new Size(0, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final ImageLightCondition b(ByteBuffer byteBuffer, int i10, int i11, Rect rect) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i12 = i10;
        Rect rect2 = rect;
        if (i12 == 0 || i11 == 0) {
            return null;
        }
        long[] jArr = new long[256];
        byteBuffer.rewind();
        long j10 = 0;
        int width = rect.width() * rect.height();
        int width2 = rect.width();
        if (width2 > 32768) {
            return null;
        }
        int i13 = rect2.bottom;
        for (int i14 = rect2.top; i14 < i13; i14++) {
            byteBuffer2.position((i14 * i12) + rect2.left);
            byteBuffer2.get(this.f14248a, 0, width2);
            for (int i15 = 0; i15 < width2; i15++) {
                byte b10 = this.f14248a[i15] & 255;
                j10 += (long) b10;
                jArr[b10] = jArr[b10] + 1;
            }
        }
        double d10 = ((double) j10) / ((double) width);
        return new ImageLightCondition(d10 / 255.0d, e(byteBuffer2, i12, (int) d10, rect2), ((double) d(this, jArr, width, 0.0d, 0.0d, 12, (Object) null)) / 255.0d, width);
    }

    private final int c(long[] jArr, int i10, double d10, double d11) {
        long[] jArr2 = jArr;
        double d12 = (double) 100;
        double d13 = (double) i10;
        double floor = Math.floor((d10 / d12) * d13);
        double floor2 = Math.floor((d11 / d12) * d13);
        int length = jArr2.length;
        long j10 = 0;
        int i11 = 0;
        long j11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i12 = 0;
                break;
            }
            j11 += jArr2[i12];
            if (((double) j11) > floor) {
                break;
            }
            i12++;
        }
        double d14 = d13 - floor2;
        int length2 = jArr2.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i13 = length2 - 1;
                j10 += jArr2[length2];
                if (((double) j10) > d14) {
                    i11 = length2;
                    break;
                } else if (i13 < 0) {
                    break;
                } else {
                    length2 = i13;
                }
            }
        }
        return i11 - i12;
    }

    static /* synthetic */ int d(c cVar, long[] jArr, int i10, double d10, double d11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            d10 = 1.0d;
        }
        double d12 = d10;
        if ((i11 & 8) != 0) {
            d11 = 99.0d;
        }
        return cVar.c(jArr, i10, d12, d11);
    }

    private final double e(ByteBuffer byteBuffer, int i10, int i11, Rect rect) {
        int width = rect.width() * rect.height();
        int width2 = rect.width();
        int i12 = rect.bottom;
        long j10 = 0;
        for (int i13 = rect.top; i13 < i12; i13++) {
            byteBuffer.position((i13 * i10) + rect.left);
            byteBuffer.get(this.f14248a, 0, width2);
            for (int i14 = 0; i14 < width2; i14++) {
                int i15 = (this.f14248a[i14] & 255) - i11;
                j10 += (long) (i15 * i15);
            }
        }
        return Math.sqrt(((double) j10) / ((double) width)) / 128.0d;
    }

    public Object a(s sVar, Rect rect, kotlin.coroutines.c<? super Result<? extends a>> cVar) {
        Image.Plane plane;
        int width = sVar.t().getWidth();
        int height = sVar.t().getHeight();
        Image.Plane[] planes = sVar.t().getPlanes();
        if (planes != null) {
            plane = planes[0];
        } else {
            plane = null;
        }
        if (plane == null) {
            Result.a aVar = Result.f32010a;
            return Result.b(a.b.f14241a);
        }
        if (rect == null) {
            rect = new Rect(0, 0, width, height);
        }
        ByteBuffer buffer = plane.getBuffer();
        j.f(buffer, "yPlane.buffer");
        ImageLightCondition b10 = b(buffer, width, height, rect);
        if (b10 == null) {
            Result.a aVar2 = Result.f32010a;
            return Result.b(a.b.f14241a);
        }
        Result.a aVar3 = Result.f32010a;
        return Result.b(new a.e(b10));
    }
}
