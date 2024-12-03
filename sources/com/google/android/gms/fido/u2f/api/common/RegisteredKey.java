package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONException;
import org.json.b;
import ue.a;

@Deprecated
public class RegisteredKey extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<RegisteredKey> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final KeyHandle f39440a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39441b;

    /* renamed from: c  reason: collision with root package name */
    String f39442c;

    public RegisteredKey(@NonNull KeyHandle keyHandle, @NonNull String str, @NonNull String str2) {
        this.f39440a = (KeyHandle) p.k(keyHandle);
        this.f39442c = str;
        this.f39441b = str2;
    }

    @NonNull
    public String S() {
        return this.f39441b;
    }

    @NonNull
    public String Y() {
        return this.f39442c;
    }

    @NonNull
    public KeyHandle c0() {
        return this.f39440a;
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisteredKey)) {
            return false;
        }
        RegisteredKey registeredKey = (RegisteredKey) obj;
        String str = this.f39442c;
        if (str == null) {
            if (registeredKey.f39442c != null) {
                return false;
            }
        } else if (!str.equals(registeredKey.f39442c)) {
            return false;
        }
        if (!this.f39440a.equals(registeredKey.f39440a)) {
            return false;
        }
        String str2 = this.f39441b;
        if (str2 == null) {
            if (registeredKey.f39441b != null) {
                return false;
            }
        } else if (!str2.equals(registeredKey.f39441b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        String str = this.f39442c;
        int i11 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int hashCode = ((i10 + 31) * 31) + this.f39440a.hashCode();
        String str2 = this.f39441b;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return (hashCode * 31) + i11;
    }

    @NonNull
    public String toString() {
        try {
            b bVar = new b();
            bVar.put("keyHandle", (Object) Base64.encodeToString(this.f39440a.getBytes(), 11));
            if (this.f39440a.S() != ProtocolVersion.f39421a) {
                bVar.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (Object) this.f39440a.S().toString());
            }
            if (this.f39440a.Y() != null) {
                bVar.put("transports", (Object) this.f39440a.Y().toString());
            }
            String str = this.f39442c;
            if (str != null) {
                bVar.put(SaslNonza.Challenge.ELEMENT, (Object) str);
            }
            String str2 = this.f39441b;
            if (str2 != null) {
                bVar.put("appId", (Object) str2);
            }
            return bVar.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 2, c0(), i10, false);
        fe.a.C(parcel, 3, Y(), false);
        fe.a.C(parcel, 4, S(), false);
        fe.a.b(parcel, a10);
    }
}
