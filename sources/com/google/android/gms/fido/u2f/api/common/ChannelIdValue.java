package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

@Deprecated
public class ChannelIdValue extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ChannelIdValue> CREATOR = new b();
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final ChannelIdValue f39397d = new ChannelIdValue();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final ChannelIdValue f39398e = new ChannelIdValue("unavailable");
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final ChannelIdValue f39399f = new ChannelIdValue("unused");

    /* renamed from: a  reason: collision with root package name */
    private final ChannelIdValueType f39400a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39401b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39402c;

    public enum ChannelIdValueType implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);
        
        @NonNull
        public static final Parcelable.Creator<ChannelIdValueType> CREATOR = null;
        /* access modifiers changed from: private */
        public final int zzb;

        static {
            CREATOR = new a();
        }

        private ChannelIdValueType(int i10) {
            this.zzb = i10;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            parcel.writeInt(this.zzb);
        }
    }

    public static class UnsupportedChannelIdValueTypeException extends Exception {
        public UnsupportedChannelIdValueTypeException(int i10) {
            super(String.format("ChannelIdValueType %s not supported", new Object[]{Integer.valueOf(i10)}));
        }
    }

    private ChannelIdValue() {
        this.f39400a = ChannelIdValueType.ABSENT;
        this.f39402c = null;
        this.f39401b = null;
    }

    @NonNull
    public static ChannelIdValueType f0(int i10) throws UnsupportedChannelIdValueTypeException {
        for (ChannelIdValueType channelIdValueType : ChannelIdValueType.values()) {
            if (i10 == channelIdValueType.zzb) {
                return channelIdValueType;
            }
        }
        throw new UnsupportedChannelIdValueTypeException(i10);
    }

    @NonNull
    public String S() {
        return this.f39402c;
    }

    @NonNull
    public String Y() {
        return this.f39401b;
    }

    public int c0() {
        return this.f39400a.zzb;
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelIdValue)) {
            return false;
        }
        ChannelIdValue channelIdValue = (ChannelIdValue) obj;
        if (!this.f39400a.equals(channelIdValue.f39400a)) {
            return false;
        }
        int ordinal = this.f39400a.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal == 1) {
            return this.f39401b.equals(channelIdValue.f39401b);
        }
        if (ordinal != 2) {
            return false;
        }
        return this.f39402c.equals(channelIdValue.f39402c);
    }

    public int hashCode() {
        int i10;
        int hashCode;
        int hashCode2 = this.f39400a.hashCode() + 31;
        int ordinal = this.f39400a.ordinal();
        if (ordinal == 1) {
            i10 = hashCode2 * 31;
            hashCode = this.f39401b.hashCode();
        } else if (ordinal != 2) {
            return hashCode2;
        } else {
            i10 = hashCode2 * 31;
            hashCode = this.f39402c.hashCode();
        }
        return i10 + hashCode;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, c0());
        a.C(parcel, 3, Y(), false);
        a.C(parcel, 4, S(), false);
        a.b(parcel, a10);
    }

    ChannelIdValue(int i10, String str, String str2) {
        try {
            this.f39400a = f0(i10);
            this.f39401b = str;
            this.f39402c = str2;
        } catch (UnsupportedChannelIdValueTypeException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    private ChannelIdValue(String str) {
        this.f39401b = (String) p.k(str);
        this.f39400a = ChannelIdValueType.STRING;
        this.f39402c = null;
    }
}
