package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mparticle.kits.AppsFlyerKit;
import fe.a;
import java.util.List;

@Deprecated
public final class WakeLockEvent extends StatsEvent {
    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f39169a;

    /* renamed from: b  reason: collision with root package name */
    private final long f39170b;

    /* renamed from: c  reason: collision with root package name */
    private int f39171c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39172d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39173e;

    /* renamed from: f  reason: collision with root package name */
    private final String f39174f;

    /* renamed from: g  reason: collision with root package name */
    private final int f39175g;

    /* renamed from: h  reason: collision with root package name */
    private final List f39176h;

    /* renamed from: j  reason: collision with root package name */
    private final String f39177j;

    /* renamed from: k  reason: collision with root package name */
    private final long f39178k;

    /* renamed from: l  reason: collision with root package name */
    private int f39179l;

    /* renamed from: m  reason: collision with root package name */
    private final String f39180m;

    /* renamed from: n  reason: collision with root package name */
    private final float f39181n;

    /* renamed from: p  reason: collision with root package name */
    private final long f39182p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f39183q;

    /* renamed from: t  reason: collision with root package name */
    private long f39184t = -1;

    WakeLockEvent(int i10, long j10, int i11, String str, int i12, List list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.f39169a = i10;
        this.f39170b = j10;
        this.f39171c = i11;
        this.f39172d = str;
        this.f39173e = str3;
        this.f39174f = str5;
        this.f39175g = i12;
        this.f39176h = list;
        this.f39177j = str2;
        this.f39178k = j11;
        this.f39179l = i13;
        this.f39180m = str4;
        this.f39181n = f10;
        this.f39182p = j12;
        this.f39183q = z10;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39169a);
        a.v(parcel, 2, this.f39170b);
        a.C(parcel, 4, this.f39172d, false);
        a.s(parcel, 5, this.f39175g);
        a.E(parcel, 6, this.f39176h, false);
        a.v(parcel, 8, this.f39178k);
        a.C(parcel, 10, this.f39173e, false);
        a.s(parcel, 11, this.f39171c);
        a.C(parcel, 12, this.f39177j, false);
        a.C(parcel, 13, this.f39180m, false);
        a.s(parcel, 14, this.f39179l);
        a.o(parcel, 15, this.f39181n);
        a.v(parcel, 16, this.f39182p);
        a.C(parcel, 17, this.f39174f, false);
        a.g(parcel, 18, this.f39183q);
        a.b(parcel, a10);
    }

    public final int zza() {
        return this.f39171c;
    }

    public final long zzb() {
        return this.f39184t;
    }

    public final long zzc() {
        return this.f39170b;
    }

    @NonNull
    public final String zzd() {
        String str;
        List list = this.f39176h;
        String str2 = this.f39172d;
        int i10 = this.f39175g;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(AppsFlyerKit.COMMA, list);
        }
        int i11 = this.f39179l;
        String str4 = this.f39173e;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.f39180m;
        if (str5 == null) {
            str5 = str3;
        }
        float f10 = this.f39181n;
        String str6 = this.f39174f;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z10 = this.f39183q;
        return "\t" + str2 + "\t" + i10 + "\t" + str + "\t" + i11 + "\t" + str4 + "\t" + str5 + "\t" + f10 + "\t" + str3 + "\t" + z10;
    }
}
