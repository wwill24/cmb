package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                if (!fastJsonResponse.isFieldSet(next) || !n.b(getFieldValue(next), fastJsonResponse.getFieldValue(next))) {
                    return false;
                }
            } else if (fastJsonResponse.isFieldSet(next)) {
                return false;
            }
        }
        return true;
    }

    public Object getValueObject(@NonNull String str) {
        return null;
    }

    public int hashCode() {
        int i10 = 0;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                i10 = (i10 * 31) + p.k(getFieldValue(next)).hashCode();
            }
        }
        return i10;
    }

    public boolean isPrimitiveFieldSet(@NonNull String str) {
        return false;
    }

    @NonNull
    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
