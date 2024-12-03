package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class IdPart implements Parcelable {

    public static final class PassportNfcPart extends IdPart {
        public static final Parcelable.Creator<PassportNfcPart> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public static final PassportNfcPart f25675a = new PassportNfcPart();

        public static final class a implements Parcelable.Creator<PassportNfcPart> {
            /* renamed from: a */
            public final PassportNfcPart createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return PassportNfcPart.f25675a;
            }

            /* renamed from: b */
            public final PassportNfcPart[] newArray(int i10) {
                return new PassportNfcPart[i10];
            }
        }

        private PassportNfcPart() {
            super((DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }
    }

    public static final class SideIdPart extends IdPart {
        public static final Parcelable.Creator<SideIdPart> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final IdConfig.Side f25676a;

        public static final class a implements Parcelable.Creator<SideIdPart> {
            /* renamed from: a */
            public final SideIdPart createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new SideIdPart(IdConfig.Side.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final SideIdPart[] newArray(int i10) {
                return new SideIdPart[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SideIdPart(IdConfig.Side side) {
            super((DefaultConstructorMarker) null);
            j.g(side, "side");
            this.f25676a = side;
        }

        public final IdConfig.Side a() {
            return this.f25676a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SideIdPart) && this.f25676a == ((SideIdPart) obj).f25676a;
        }

        public int hashCode() {
            return this.f25676a.hashCode();
        }

        public String toString() {
            return "SideIdPart(side=" + this.f25676a + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f25676a.name());
        }
    }

    private IdPart() {
    }

    public /* synthetic */ IdPart(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
