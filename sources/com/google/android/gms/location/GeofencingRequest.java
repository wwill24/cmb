package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzdh;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new i0();

    /* renamed from: a  reason: collision with root package name */
    private final List f39493a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39494b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39495c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39496d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f39497a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private int f39498b = 5;

        /* renamed from: c  reason: collision with root package name */
        private String f39499c = "";

        @NonNull
        public a a(@NonNull e eVar) {
            p.l(eVar, "geofence can't be null.");
            p.b(eVar instanceof zzdh, "Geofence must be created using Geofence.Builder.");
            this.f39497a.add((zzdh) eVar);
            return this;
        }

        @NonNull
        public a b(@NonNull List<e> list) {
            if (list != null && !list.isEmpty()) {
                for (e next : list) {
                    if (next != null) {
                        a(next);
                    }
                }
            }
            return this;
        }

        @NonNull
        public GeofencingRequest c() {
            p.b(!this.f39497a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.f39497a, this.f39498b, this.f39499c, (String) null);
        }

        @NonNull
        public a d(int i10) {
            this.f39498b = i10 & 7;
            return this;
        }
    }

    GeofencingRequest(List list, int i10, String str, String str2) {
        this.f39493a = list;
        this.f39494b = i10;
        this.f39495c = str;
        this.f39496d = str2;
    }

    public int S() {
        return this.f39494b;
    }

    @NonNull
    public final GeofencingRequest Y(String str) {
        return new GeofencingRequest(this.f39493a, this.f39494b, this.f39495c, str);
    }

    @NonNull
    public String toString() {
        return "GeofencingRequest[geofences=" + this.f39493a + ", initialTrigger=" + this.f39494b + ", tag=" + this.f39495c + ", attributionTag=" + this.f39496d + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.G(parcel, 1, this.f39493a, false);
        fe.a.s(parcel, 2, S());
        fe.a.C(parcel, 3, this.f39495c, false);
        fe.a.C(parcel, 4, this.f39496d, false);
        fe.a.b(parcel, a10);
    }
}
