package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ie.i;

public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final int f39098a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39099b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f39100c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f39101d;

    /* renamed from: e  reason: collision with root package name */
    private final int f39102e;

    /* renamed from: f  reason: collision with root package name */
    private final a f39103f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final long f39104a;

        /* renamed from: b  reason: collision with root package name */
        private final long f39105b;

        a(long j10, long j11) {
            p.n(j11);
            this.f39104a = j10;
            this.f39105b = j11;
        }
    }

    public ModuleInstallStatusUpdate(int i10, int i11, Long l10, Long l11, int i12) {
        a aVar;
        this.f39098a = i10;
        this.f39099b = i11;
        this.f39100c = l10;
        this.f39101d = l11;
        this.f39102e = i12;
        if (l10 == null || l11 == null || l11.longValue() == 0) {
            aVar = null;
        } else {
            aVar = new a(l10.longValue(), l11.longValue());
        }
        this.f39103f = aVar;
    }

    public int S() {
        return this.f39102e;
    }

    public int Y() {
        return this.f39099b;
    }

    public int c0() {
        return this.f39098a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.s(parcel, 1, c0());
        fe.a.s(parcel, 2, Y());
        fe.a.x(parcel, 3, this.f39100c, false);
        fe.a.x(parcel, 4, this.f39101d, false);
        fe.a.s(parcel, 5, S());
        fe.a.b(parcel, a10);
    }
}
