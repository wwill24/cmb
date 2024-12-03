package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public final class zzs extends zzbz {
    public static final Parcelable.Creator<zzs> CREATOR = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final a f38206g;

    /* renamed from: a  reason: collision with root package name */
    final int f38207a;

    /* renamed from: b  reason: collision with root package name */
    private List f38208b;

    /* renamed from: c  reason: collision with root package name */
    private List f38209c;

    /* renamed from: d  reason: collision with root package name */
    private List f38210d;

    /* renamed from: e  reason: collision with root package name */
    private List f38211e;

    /* renamed from: f  reason: collision with root package name */
    private List f38212f;

    static {
        a aVar = new a();
        f38206g = aVar;
        aVar.put("registered", FastJsonResponse.Field.m0("registered", 2));
        aVar.put("in_progress", FastJsonResponse.Field.m0("in_progress", 3));
        aVar.put("success", FastJsonResponse.Field.m0("success", 4));
        aVar.put(StreamManagement.Failed.ELEMENT, FastJsonResponse.Field.m0(StreamManagement.Failed.ELEMENT, 5));
        aVar.put("escrowed", FastJsonResponse.Field.m0("escrowed", 6));
    }

    public zzs() {
        this.f38207a = 1;
    }

    public final Map getFieldMappings() {
        return f38206g;
    }

    /* access modifiers changed from: protected */
    public final Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.q0()) {
            case 1:
                return Integer.valueOf(this.f38207a);
            case 2:
                return this.f38208b;
            case 3:
                return this.f38209c;
            case 4:
                return this.f38210d;
            case 5:
                return this.f38211e;
            case 6:
                return this.f38212f;
            default:
                int q02 = field.q0();
                throw new IllegalStateException("Unknown SafeParcelable id=" + q02);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void setStringsInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int q02 = field.q0();
        if (q02 == 2) {
            this.f38208b = arrayList;
        } else if (q02 == 3) {
            this.f38209c = arrayList;
        } else if (q02 == 4) {
            this.f38210d = arrayList;
        } else if (q02 == 5) {
            this.f38211e = arrayList;
        } else if (q02 == 6) {
            this.f38212f = arrayList;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[]{Integer.valueOf(q02)}));
        }
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.s(parcel, 1, this.f38207a);
        fe.a.E(parcel, 2, this.f38208b, false);
        fe.a.E(parcel, 3, this.f38209c, false);
        fe.a.E(parcel, 4, this.f38210d, false);
        fe.a.E(parcel, 5, this.f38211e, false);
        fe.a.E(parcel, 6, this.f38212f, false);
        fe.a.b(parcel, a10);
    }

    zzs(int i10, List list, List list2, List list3, List list4, List list5) {
        this.f38207a = i10;
        this.f38208b = list;
        this.f38209c = list2;
        this.f38210d = list3;
        this.f38211e = list4;
        this.f38212f = list5;
    }
}
