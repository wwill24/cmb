package com.withpersona.sdk2.inquiry.network;

import ai.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class InternalErrorInfo implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final h<Object> fallbackAdapter = new InternalErrorInfo$Companion$fallbackAdapter$1().nullSafe();

    @i(generateAdapter = true)
    public static final class CameraErrorInfo extends InternalErrorInfo {
        public static final Parcelable.Creator<CameraErrorInfo> CREATOR = new Creator();
        private final String message;

        public static final class Creator implements Parcelable.Creator<CameraErrorInfo> {
            public final CameraErrorInfo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new CameraErrorInfo(parcel.readString());
            }

            public final CameraErrorInfo[] newArray(int i10) {
                return new CameraErrorInfo[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CameraErrorInfo(String str) {
            super((DefaultConstructorMarker) null);
            j.g(str, "message");
            this.message = str;
        }

        public static /* synthetic */ CameraErrorInfo copy$default(CameraErrorInfo cameraErrorInfo, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = cameraErrorInfo.message;
            }
            return cameraErrorInfo.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final CameraErrorInfo copy(String str) {
            j.g(str, "message");
            return new CameraErrorInfo(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CameraErrorInfo) && j.b(this.message, ((CameraErrorInfo) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CameraErrorInfo(message=" + this.message + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.message);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h.e createAdapter() {
            b<InternalErrorInfo> d10 = b.b(InternalErrorInfo.class, "type").e(NetworkErrorInfo.class, "network").e(IntegrationErrorInfo.class, "integration").e(PermissionErrorInfo.class, "permission").e(CameraErrorInfo.class, "camera").e(ConfigurationErrorInfo.class, "configuration").d(InternalErrorInfo.fallbackAdapter);
            j.f(d10, "of(InternalErrorInfo::cl…nAdapter(fallbackAdapter)");
            return d10;
        }
    }

    @i(generateAdapter = true)
    public static final class ConfigurationErrorInfo extends InternalErrorInfo {
        public static final Parcelable.Creator<ConfigurationErrorInfo> CREATOR = new Creator();
        private final String message;

        public static final class Creator implements Parcelable.Creator<ConfigurationErrorInfo> {
            public final ConfigurationErrorInfo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ConfigurationErrorInfo(parcel.readString());
            }

            public final ConfigurationErrorInfo[] newArray(int i10) {
                return new ConfigurationErrorInfo[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConfigurationErrorInfo(String str) {
            super((DefaultConstructorMarker) null);
            j.g(str, "message");
            this.message = str;
        }

        public static /* synthetic */ ConfigurationErrorInfo copy$default(ConfigurationErrorInfo configurationErrorInfo, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = configurationErrorInfo.message;
            }
            return configurationErrorInfo.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final ConfigurationErrorInfo copy(String str) {
            j.g(str, "message");
            return new ConfigurationErrorInfo(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfigurationErrorInfo) && j.b(this.message, ((ConfigurationErrorInfo) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ConfigurationErrorInfo(message=" + this.message + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.message);
        }
    }

    @i(generateAdapter = true)
    public static final class IntegrationErrorInfo extends InternalErrorInfo {
        public static final Parcelable.Creator<IntegrationErrorInfo> CREATOR = new Creator();
        private final String message;

        public static final class Creator implements Parcelable.Creator<IntegrationErrorInfo> {
            public final IntegrationErrorInfo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new IntegrationErrorInfo(parcel.readString());
            }

            public final IntegrationErrorInfo[] newArray(int i10) {
                return new IntegrationErrorInfo[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IntegrationErrorInfo(String str) {
            super((DefaultConstructorMarker) null);
            j.g(str, "message");
            this.message = str;
        }

        public static /* synthetic */ IntegrationErrorInfo copy$default(IntegrationErrorInfo integrationErrorInfo, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = integrationErrorInfo.message;
            }
            return integrationErrorInfo.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final IntegrationErrorInfo copy(String str) {
            j.g(str, "message");
            return new IntegrationErrorInfo(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntegrationErrorInfo) && j.b(this.message, ((IntegrationErrorInfo) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "IntegrationErrorInfo(message=" + this.message + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.message);
        }
    }

    @i(generateAdapter = true)
    public static final class NetworkErrorInfo extends InternalErrorInfo {
        public static final Parcelable.Creator<NetworkErrorInfo> CREATOR = new Creator();
        private final int code;
        private final boolean isRecoverable;
        private final String message;
        private final ErrorResponse.Error responseError;

        public static final class Creator implements Parcelable.Creator<NetworkErrorInfo> {
            public final NetworkErrorInfo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new NetworkErrorInfo(parcel.readInt(), parcel.readString(), parcel.readInt() != 0, (ErrorResponse.Error) parcel.readParcelable(NetworkErrorInfo.class.getClassLoader()));
            }

            public final NetworkErrorInfo[] newArray(int i10) {
                return new NetworkErrorInfo[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetworkErrorInfo(int i10, String str, boolean z10, ErrorResponse.Error error, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(i10, str, z10, (i11 & 8) != 0 ? null : error);
        }

        public static /* synthetic */ NetworkErrorInfo copy$default(NetworkErrorInfo networkErrorInfo, int i10, String str, boolean z10, ErrorResponse.Error error, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = networkErrorInfo.code;
            }
            if ((i11 & 2) != 0) {
                str = networkErrorInfo.message;
            }
            if ((i11 & 4) != 0) {
                z10 = networkErrorInfo.isRecoverable;
            }
            if ((i11 & 8) != 0) {
                error = networkErrorInfo.responseError;
            }
            return networkErrorInfo.copy(i10, str, z10, error);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final boolean component3() {
            return this.isRecoverable;
        }

        public final ErrorResponse.Error component4() {
            return this.responseError;
        }

        public final NetworkErrorInfo copy(int i10, String str, boolean z10, ErrorResponse.Error error) {
            return new NetworkErrorInfo(i10, str, z10, error);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetworkErrorInfo)) {
                return false;
            }
            NetworkErrorInfo networkErrorInfo = (NetworkErrorInfo) obj;
            return this.code == networkErrorInfo.code && j.b(this.message, networkErrorInfo.message) && this.isRecoverable == networkErrorInfo.isRecoverable && j.b(this.responseError, networkErrorInfo.responseError);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public final ErrorResponse.Error getResponseError() {
            return this.responseError;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.code) * 31;
            String str = this.message;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z10 = this.isRecoverable;
            if (z10) {
                z10 = true;
            }
            int i11 = (hashCode2 + (z10 ? 1 : 0)) * 31;
            ErrorResponse.Error error = this.responseError;
            if (error != null) {
                i10 = error.hashCode();
            }
            return i11 + i10;
        }

        public final boolean isRecoverable() {
            return this.isRecoverable;
        }

        public String toString() {
            return "NetworkErrorInfo(code=" + this.code + ", message=" + this.message + ", isRecoverable=" + this.isRecoverable + ", responseError=" + this.responseError + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.code);
            parcel.writeString(this.message);
            parcel.writeInt(this.isRecoverable ? 1 : 0);
            parcel.writeParcelable(this.responseError, i10);
        }

        public NetworkErrorInfo(int i10, String str, boolean z10, ErrorResponse.Error error) {
            super((DefaultConstructorMarker) null);
            this.code = i10;
            this.message = str;
            this.isRecoverable = z10;
            this.responseError = error;
        }
    }

    @i(generateAdapter = true)
    public static final class PermissionErrorInfo extends InternalErrorInfo {
        public static final Parcelable.Creator<PermissionErrorInfo> CREATOR = new Creator();
        private final String message;

        public static final class Creator implements Parcelable.Creator<PermissionErrorInfo> {
            public final PermissionErrorInfo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new PermissionErrorInfo(parcel.readString());
            }

            public final PermissionErrorInfo[] newArray(int i10) {
                return new PermissionErrorInfo[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PermissionErrorInfo(String str) {
            super((DefaultConstructorMarker) null);
            j.g(str, "message");
            this.message = str;
        }

        public static /* synthetic */ PermissionErrorInfo copy$default(PermissionErrorInfo permissionErrorInfo, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = permissionErrorInfo.message;
            }
            return permissionErrorInfo.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final PermissionErrorInfo copy(String str) {
            j.g(str, "message");
            return new PermissionErrorInfo(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PermissionErrorInfo) && j.b(this.message, ((PermissionErrorInfo) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "PermissionErrorInfo(message=" + this.message + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.message);
        }
    }

    private InternalErrorInfo() {
    }

    public /* synthetic */ InternalErrorInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
