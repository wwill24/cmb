package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import fe.a;
import java.util.Arrays;

@Deprecated
public class RegisterRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final int f39425a;

    /* renamed from: b  reason: collision with root package name */
    private final ProtocolVersion f39426b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39427c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39428d;

    RegisterRequest(int i10, String str, byte[] bArr, String str2) {
        this.f39425a = i10;
        try {
            this.f39426b = ProtocolVersion.a(str);
            this.f39427c = bArr;
            this.f39428d = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public String S() {
        return this.f39428d;
    }

    @NonNull
    public byte[] Y() {
        return this.f39427c;
    }

    public int c0() {
        return this.f39425a;
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.f39427c, registerRequest.f39427c) || this.f39426b != registerRequest.f39426b) {
            return false;
        }
        String str = this.f39428d;
        if (str == null) {
            if (registerRequest.f39428d != null) {
                return false;
            }
        } else if (!str.equals(registerRequest.f39428d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((Arrays.hashCode(this.f39427c) + 31) * 31) + this.f39426b.hashCode();
        String str = this.f39428d;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return (hashCode * 31) + i10;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, c0());
        a.C(parcel, 2, this.f39426b.toString(), false);
        a.k(parcel, 3, Y(), false);
        a.C(parcel, 4, S(), false);
        a.b(parcel, a10);
    }
}
