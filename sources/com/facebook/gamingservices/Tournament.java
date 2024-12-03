package com.facebook.gamingservices;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u000e\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001aB/\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR(\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8F@BX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/facebook/gamingservices/Tournament;", "Lcom/facebook/share/model/ShareModel;", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "", "writeToParcel", "", "identifier", "Ljava/lang/String;", "title", "payload", "endTime", "j$/time/ZonedDateTime", "newValue", "getExpiration", "()Lj$/time/ZonedDateTime;", "setExpiration", "(Lj$/time/ZonedDateTime;)V", "expiration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
public final class Tournament implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    @c("tournament_end_time")
    public String endTime;
    @c("id")
    public final String identifier;
    @c("tournament_payload")
    public final String payload;
    @c("tournament_title")
    public final String title;

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b)\u0010*J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006+"}, d2 = {"Lcom/facebook/gamingservices/Tournament$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/Tournament;", "", "identifier", "j$/time/ZonedDateTime", "expiration", "title", "payload", "build", "tournament", "readFrom", "component1", "component2", "component3", "component4", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "Lj$/time/ZonedDateTime;", "getExpiration", "()Lj$/time/ZonedDateTime;", "setExpiration", "(Lj$/time/ZonedDateTime;)V", "getTitle", "setTitle", "getPayload", "setPayload", "endTime", "getEndTime", "setEndTime", "<init>", "(Ljava/lang/String;Lj$/time/ZonedDateTime;Ljava/lang/String;Ljava/lang/String;)V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
    public static final class Builder implements ShareModelBuilder<Tournament, Builder> {
        private String endTime;
        private ZonedDateTime expiration;
        private String identifier;
        private String payload;
        private String title;

        public Builder(String str, ZonedDateTime zonedDateTime, String str2, String str3) {
            j.g(str, "identifier");
            this.identifier = str;
            this.expiration = zonedDateTime;
            this.title = str2;
            this.payload = str3;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, ZonedDateTime zonedDateTime, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = builder.identifier;
            }
            if ((i10 & 2) != 0) {
                zonedDateTime = builder.expiration;
            }
            if ((i10 & 4) != 0) {
                str2 = builder.title;
            }
            if ((i10 & 8) != 0) {
                str3 = builder.payload;
            }
            return builder.copy(str, zonedDateTime, str2, str3);
        }

        public final String component1() {
            return this.identifier;
        }

        public final ZonedDateTime component2() {
            return this.expiration;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.payload;
        }

        public final Builder copy(String str, ZonedDateTime zonedDateTime, String str2, String str3) {
            j.g(str, "identifier");
            return new Builder(str, zonedDateTime, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return j.b(this.identifier, builder.identifier) && j.b(this.expiration, builder.expiration) && j.b(this.title, builder.title) && j.b(this.payload, builder.payload);
        }

        public final Builder expiration(ZonedDateTime zonedDateTime) {
            setExpiration(zonedDateTime);
            if (Build.VERSION.SDK_INT >= 26 && zonedDateTime != null) {
                setEndTime(zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
            }
            return this;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final ZonedDateTime getExpiration() {
            return this.expiration;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode = this.identifier.hashCode() * 31;
            ZonedDateTime zonedDateTime = this.expiration;
            int i10 = 0;
            int hashCode2 = (hashCode + (zonedDateTime == null ? 0 : zonedDateTime.hashCode())) * 31;
            String str = this.title;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.payload;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return hashCode3 + i10;
        }

        public final Builder identifier(String str) {
            j.g(str, "identifier");
            setIdentifier(str);
            return this;
        }

        public final Builder payload(String str) {
            setPayload(str);
            return this;
        }

        public final void setEndTime(String str) {
            this.endTime = str;
        }

        public final void setExpiration(ZonedDateTime zonedDateTime) {
            this.expiration = zonedDateTime;
        }

        public final void setIdentifier(String str) {
            j.g(str, "<set-?>");
            this.identifier = str;
        }

        public final void setPayload(String str) {
            this.payload = str;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Builder title(String str) {
            setTitle(str);
            return this;
        }

        public String toString() {
            return "Builder(identifier=" + this.identifier + ", expiration=" + this.expiration + ", title=" + this.title + ", payload=" + this.payload + PropertyUtils.MAPPED_DELIM2;
        }

        public Tournament build() {
            return new Tournament(this.identifier, this.endTime, this.title, this.payload);
        }

        public Builder readFrom(Tournament tournament) {
            Builder builder;
            if (tournament == null) {
                builder = null;
            } else {
                builder = identifier(tournament.identifier).expiration(tournament.getExpiration()).title(tournament.title).payload(tournament.payload);
            }
            return builder == null ? this : builder;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(String str, ZonedDateTime zonedDateTime, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? null : zonedDateTime, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/Tournament$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/Tournament;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/Tournament;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<Tournament> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Tournament createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new Tournament(parcel);
        }

        public Tournament[] newArray(int i10) {
            return new Tournament[i10];
        }
    }

    public Tournament(String str, String str2, String str3, String str4) {
        ZonedDateTime zonedDateTime;
        j.g(str, "identifier");
        this.identifier = str;
        this.endTime = str2;
        this.title = str3;
        this.payload = str4;
        if (str2 == null) {
            zonedDateTime = null;
        } else {
            zonedDateTime = DateFormatter.INSTANCE.format$facebook_gamingservices_release(str2);
        }
        setExpiration(zonedDateTime);
    }

    private final void setExpiration(ZonedDateTime zonedDateTime) {
        if (Build.VERSION.SDK_INT >= 26 && zonedDateTime != null) {
            this.endTime = zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
            setExpiration(zonedDateTime);
        }
    }

    public int describeContents() {
        return 0;
    }

    public final ZonedDateTime getExpiration() {
        String str = this.endTime;
        if (str == null) {
            return null;
        }
        return DateFormatter.INSTANCE.format$facebook_gamingservices_release(str);
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.identifier);
        parcel.writeString(this.endTime);
        parcel.writeString(this.title);
        parcel.writeString(this.payload);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Tournament(Parcel parcel) {
        this(parcel.toString(), parcel.toString(), parcel.toString(), parcel.toString());
        j.g(parcel, "parcel");
    }
}
