package com.withpersona.sdk2.inquiry.selfie.video_capture;

import com.coffeemeetsbagel.models.util.DateUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27441a;

    /* renamed from: b  reason: collision with root package name */
    private final long f27442b;

    public a(boolean z10, long j10) {
        this.f27441a = z10;
        this.f27442b = j10;
    }

    public final long a() {
        return this.f27442b;
    }

    public final boolean b() {
        return this.f27441a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f27441a == aVar.f27441a && this.f27442b == aVar.f27442b;
    }

    public int hashCode() {
        boolean z10 = this.f27441a;
        if (z10) {
            z10 = true;
        }
        return ((z10 ? 1 : 0) * true) + Long.hashCode(this.f27442b);
    }

    public String toString() {
        return "VideoCaptureConfig(useVideoCapture=" + this.f27441a + ", maxRecordingLengthMs=" + this.f27442b + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z10, long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, (i10 & 2) != 0 ? DateUtils.MILLIS_IN_MINUTE : j10);
    }
}
