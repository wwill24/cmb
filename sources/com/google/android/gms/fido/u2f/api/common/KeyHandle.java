package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import fe.a;
import java.util.Arrays;
import java.util.List;
import me.c;

@Deprecated
public class KeyHandle extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<KeyHandle> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f39417a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f39418b;

    /* renamed from: c  reason: collision with root package name */
    private final ProtocolVersion f39419c;

    /* renamed from: d  reason: collision with root package name */
    private final List f39420d;

    KeyHandle(int i10, byte[] bArr, String str, List list) {
        this.f39417a = i10;
        this.f39418b = bArr;
        try {
            this.f39419c = ProtocolVersion.a(str);
            this.f39420d = list;
        } catch (ProtocolVersion.UnsupportedProtocolException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public ProtocolVersion S() {
        return this.f39419c;
    }

    @NonNull
    public List<Transport> Y() {
        return this.f39420d;
    }

    public int c0() {
        return this.f39417a;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyHandle)) {
            return false;
        }
        KeyHandle keyHandle = (KeyHandle) obj;
        if (!Arrays.equals(this.f39418b, keyHandle.f39418b) || !this.f39419c.equals(keyHandle.f39419c)) {
            return false;
        }
        List list2 = this.f39420d;
        if (list2 == null && keyHandle.f39420d == null) {
            return true;
        }
        if (list2 == null || (list = keyHandle.f39420d) == null || !list2.containsAll(list) || !keyHandle.f39420d.containsAll(this.f39420d)) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] getBytes() {
        return this.f39418b;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(Arrays.hashCode(this.f39418b)), this.f39419c, this.f39420d);
    }

    @NonNull
    public String toString() {
        String str;
        List list = this.f39420d;
        if (list == null) {
            str = "null";
        } else {
            str = list.toString();
        }
        return String.format("{keyHandle: %s, version: %s, transports: %s}", new Object[]{c.c(this.f39418b), this.f39419c, str});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, c0());
        a.k(parcel, 2, getBytes(), false);
        a.C(parcel, 3, this.f39419c.toString(), false);
        a.G(parcel, 4, Y(), false);
        a.b(parcel, a10);
    }
}
