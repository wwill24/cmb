package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mparticle.identity.IdentityHttpResponse;
import fe.a;

public final class ConnectionResult extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new j();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final ConnectionResult f38485e = new ConnectionResult(0);

    /* renamed from: a  reason: collision with root package name */
    final int f38486a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38487b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f38488c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38489d;

    public ConnectionResult(int i10) {
        this(i10, (PendingIntent) null, (String) null);
    }

    ConnectionResult(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f38486a = i10;
        this.f38487b = i11;
        this.f38488c = pendingIntent;
        this.f38489d = str;
    }

    @NonNull
    static String m0(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return IdentityHttpResponse.UNKNOWN;
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i10 + ")";
                }
        }
    }

    public int S() {
        return this.f38487b;
    }

    public String Y() {
        return this.f38489d;
    }

    public PendingIntent c0() {
        return this.f38488c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (this.f38487b != connectionResult.f38487b || !n.b(this.f38488c, connectionResult.f38488c) || !n.b(this.f38489d, connectionResult.f38489d)) {
            return false;
        }
        return true;
    }

    public boolean f0() {
        return (this.f38487b == 0 || this.f38488c == null) ? false : true;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f38487b), this.f38488c, this.f38489d);
    }

    public boolean i0() {
        return this.f38487b == 0;
    }

    @NonNull
    public String toString() {
        n.a d10 = n.d(this);
        d10.a("statusCode", m0(this.f38487b));
        d10.a("resolution", this.f38488c);
        d10.a("message", this.f38489d);
        return d10.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38486a);
        a.s(parcel, 2, S());
        a.A(parcel, 3, c0(), i10, false);
        a.C(parcel, 4, Y(), false);
        a.b(parcel, a10);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, (String) null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }
}
