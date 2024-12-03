package com.withpersona.sdk2.inquiry.governmentid.video_capture;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26022a;

    /* renamed from: b  reason: collision with root package name */
    private final long f26023b;

    public a(boolean z10, long j10) {
        this.f26022a = z10;
        this.f26023b = j10;
    }

    public final long a() {
        return this.f26023b;
    }

    public final boolean b() {
        return this.f26022a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f26022a == aVar.f26022a && this.f26023b == aVar.f26023b;
    }

    public int hashCode() {
        boolean z10 = this.f26022a;
        if (z10) {
            z10 = true;
        }
        return ((z10 ? 1 : 0) * true) + Long.hashCode(this.f26023b);
    }

    public String toString() {
        return "VideoCaptureConfig(useVideoCapture=" + this.f26022a + ", maxRecordingLengthMs=" + this.f26023b + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z10, long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, (i10 & 2) != 0 ? 120000 : j10);
    }
}
