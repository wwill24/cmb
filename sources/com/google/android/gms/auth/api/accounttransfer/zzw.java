package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import fe.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzw extends zzbz {
    public static final Parcelable.Creator<zzw> CREATOR = new d();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap f38220h;

    /* renamed from: a  reason: collision with root package name */
    final Set f38221a;

    /* renamed from: b  reason: collision with root package name */
    final int f38222b;

    /* renamed from: c  reason: collision with root package name */
    private String f38223c;

    /* renamed from: d  reason: collision with root package name */
    private int f38224d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f38225e;

    /* renamed from: f  reason: collision with root package name */
    private PendingIntent f38226f;

    /* renamed from: g  reason: collision with root package name */
    private DeviceMetaData f38227g;

    static {
        HashMap hashMap = new HashMap();
        f38220h = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.i0("accountType", 2));
        hashMap.put("status", FastJsonResponse.Field.f0("status", 3));
        hashMap.put("transferBytes", FastJsonResponse.Field.S("transferBytes", 4));
    }

    public zzw() {
        this.f38221a = new b(3);
        this.f38222b = 1;
    }

    public final /* synthetic */ Map getFieldMappings() {
        return f38220h;
    }

    /* access modifiers changed from: protected */
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int q02 = field.q0();
        if (q02 == 1) {
            return Integer.valueOf(this.f38222b);
        }
        if (q02 == 2) {
            return this.f38223c;
        }
        if (q02 == 3) {
            return Integer.valueOf(this.f38224d);
        }
        if (q02 == 4) {
            return this.f38225e;
        }
        int q03 = field.q0();
        throw new IllegalStateException("Unknown SafeParcelable id=" + q03);
    }

    /* access modifiers changed from: protected */
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f38221a.contains(Integer.valueOf(field.q0()));
    }

    /* access modifiers changed from: protected */
    public final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        int q02 = field.q0();
        if (q02 == 4) {
            this.f38225e = bArr;
            this.f38221a.add(Integer.valueOf(q02));
            return;
        }
        throw new IllegalArgumentException("Field with id=" + q02 + " is not known to be an byte array.");
    }

    /* access modifiers changed from: protected */
    public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i10) {
        int q02 = field.q0();
        if (q02 == 3) {
            this.f38224d = i10;
            this.f38221a.add(Integer.valueOf(q02));
            return;
        }
        throw new IllegalArgumentException("Field with id=" + q02 + " is not known to be an int.");
    }

    /* access modifiers changed from: protected */
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int q02 = field.q0();
        if (q02 == 2) {
            this.f38223c = str2;
            this.f38221a.add(Integer.valueOf(q02));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(q02)}));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        Set set = this.f38221a;
        if (set.contains(1)) {
            a.s(parcel, 1, this.f38222b);
        }
        if (set.contains(2)) {
            a.C(parcel, 2, this.f38223c, true);
        }
        if (set.contains(3)) {
            a.s(parcel, 3, this.f38224d);
        }
        if (set.contains(4)) {
            a.k(parcel, 4, this.f38225e, true);
        }
        if (set.contains(5)) {
            a.A(parcel, 5, this.f38226f, i10, true);
        }
        if (set.contains(6)) {
            a.A(parcel, 6, this.f38227g, i10, true);
        }
        a.b(parcel, a10);
    }

    zzw(Set set, int i10, String str, int i11, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f38221a = set;
        this.f38222b = i10;
        this.f38223c = str;
        this.f38224d = i11;
        this.f38225e = bArr;
        this.f38226f = pendingIntent;
        this.f38227g = deviceMetaData;
    }
}
