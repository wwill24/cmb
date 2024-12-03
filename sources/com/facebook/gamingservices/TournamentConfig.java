package com.facebook.gamingservices;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.TournamentScoreType;
import com.facebook.gamingservices.internal.TournamentSortOrder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import j$.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0002+*B\u0011\b\u0012\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u0011\b\u0010\u0012\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b&\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r¨\u0006,"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/share/model/ShareModel;", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "", "writeToParcel", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "sortOrder", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "getSortOrder", "()Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "scoreType", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "getScoreType", "()Lcom/facebook/gamingservices/internal/TournamentScoreType;", "j$/time/Instant", "endTime", "Lj$/time/Instant;", "getEndTime", "()Lj$/time/Instant;", "Landroid/media/Image;", "image", "Landroid/media/Image;", "getImage", "()Landroid/media/Image;", "payload", "getPayload", "Lcom/facebook/gamingservices/TournamentConfig$Builder;", "builder", "<init>", "(Lcom/facebook/gamingservices/TournamentConfig$Builder;)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
public final class TournamentConfig implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final Instant endTime;
    private final Image image;
    private final String payload;
    private final TournamentScoreType scoreType;
    private final TournamentSortOrder sortOrder;
    private final String title;

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001f¨\u00068"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/TournamentConfig;", "", "title", "setTournamentTitle", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "sortOrder", "setTournamentSortOrder", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "scoreType", "setTournamentScoreType", "j$/time/Instant", "endTime", "setTournamentEndTime", "Landroid/media/Image;", "image", "setTournamentImage", "payload", "setTournamentPayload", "build", "Landroid/os/Parcel;", "parcel", "readFrom$facebook_gamingservices_release", "(Landroid/os/Parcel;)Lcom/facebook/gamingservices/TournamentConfig$Builder;", "readFrom", "model", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "getSortOrder", "()Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "setSortOrder", "(Lcom/facebook/gamingservices/internal/TournamentSortOrder;)V", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "getScoreType", "()Lcom/facebook/gamingservices/internal/TournamentScoreType;", "setScoreType", "(Lcom/facebook/gamingservices/internal/TournamentScoreType;)V", "Lj$/time/Instant;", "getEndTime", "()Lj$/time/Instant;", "setEndTime", "(Lj$/time/Instant;)V", "Landroid/media/Image;", "getImage", "()Landroid/media/Image;", "setImage", "(Landroid/media/Image;)V", "getPayload", "setPayload", "<init>", "()V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
    public static final class Builder implements ShareModelBuilder<TournamentConfig, Builder> {
        private Instant endTime;
        private Image image;
        private String payload;
        private TournamentScoreType scoreType;
        private TournamentSortOrder sortOrder;
        private String title;

        public final Instant getEndTime() {
            return this.endTime;
        }

        public final Image getImage() {
            return this.image;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final TournamentScoreType getScoreType() {
            return this.scoreType;
        }

        public final TournamentSortOrder getSortOrder() {
            return this.sortOrder;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Builder readFrom$facebook_gamingservices_release(Parcel parcel) {
            j.g(parcel, "parcel");
            return readFrom((TournamentConfig) parcel.readParcelable(TournamentConfig.class.getClassLoader()));
        }

        public final void setEndTime(Instant instant) {
            this.endTime = instant;
        }

        public final void setImage(Image image2) {
            this.image = image2;
        }

        public final void setPayload(String str) {
            this.payload = str;
        }

        public final void setScoreType(TournamentScoreType tournamentScoreType) {
            this.scoreType = tournamentScoreType;
        }

        public final void setSortOrder(TournamentSortOrder tournamentSortOrder) {
            this.sortOrder = tournamentSortOrder;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Builder setTournamentEndTime(Instant instant) {
            j.g(instant, SDKConstants.PARAM_END_TIME);
            this.endTime = instant;
            return this;
        }

        public final Builder setTournamentImage(Image image2) {
            this.image = image2;
            return this;
        }

        public final Builder setTournamentPayload(String str) {
            this.payload = str;
            return this;
        }

        public final Builder setTournamentScoreType(TournamentScoreType tournamentScoreType) {
            j.g(tournamentScoreType, "scoreType");
            this.scoreType = tournamentScoreType;
            return this;
        }

        public final Builder setTournamentSortOrder(TournamentSortOrder tournamentSortOrder) {
            j.g(tournamentSortOrder, SDKConstants.PARAM_SORT_ORDER);
            this.sortOrder = tournamentSortOrder;
            return this;
        }

        public final Builder setTournamentTitle(String str) {
            this.title = str;
            return this;
        }

        public TournamentConfig build() {
            return new TournamentConfig(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(TournamentConfig tournamentConfig) {
            if (tournamentConfig == null) {
                return this;
            }
            TournamentSortOrder sortOrder2 = tournamentConfig.getSortOrder();
            if (sortOrder2 != null) {
                setTournamentSortOrder(sortOrder2);
            }
            TournamentScoreType scoreType2 = tournamentConfig.getScoreType();
            if (scoreType2 != null) {
                setTournamentScoreType(scoreType2);
            }
            Instant endTime2 = tournamentConfig.getEndTime();
            if (endTime2 != null) {
                setTournamentEndTime(endTime2);
            }
            String title2 = tournamentConfig.getTitle();
            if (title2 != null) {
                setTournamentTitle(title2);
            }
            setTournamentPayload(tournamentConfig.getPayload());
            return this;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/TournamentConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/TournamentConfig;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<TournamentConfig> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public TournamentConfig createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new TournamentConfig(parcel);
        }

        public TournamentConfig[] newArray(int i10) {
            return new TournamentConfig[i10];
        }
    }

    private TournamentConfig(Builder builder) {
        this.title = builder.getTitle();
        this.sortOrder = builder.getSortOrder();
        this.scoreType = builder.getScoreType();
        this.endTime = builder.getEndTime();
        this.image = builder.getImage();
        this.payload = builder.getPayload();
    }

    public /* synthetic */ TournamentConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final Image getImage() {
        return this.image;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final TournamentScoreType getScoreType() {
        return this.scoreType;
    }

    public final TournamentSortOrder getSortOrder() {
        return this.sortOrder;
    }

    public final String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(String.valueOf(this.sortOrder));
        parcel.writeString(String.valueOf(this.scoreType));
        parcel.writeString(String.valueOf(this.endTime));
        parcel.writeString(this.title);
        parcel.writeString(this.payload);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        r0 = r9.readString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TournamentConfig(android.os.Parcel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.j.g(r9, r0)
            r8.<init>()
            java.lang.String r0 = r9.readString()
            r8.title = r0
            com.facebook.gamingservices.internal.TournamentSortOrder[] r0 = com.facebook.gamingservices.internal.TournamentSortOrder.values()
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x0015:
            r4 = 0
            if (r3 >= r1) goto L_0x002c
            r5 = r0[r3]
            java.lang.String r6 = r5.name()
            java.lang.String r7 = r9.readString()
            boolean r6 = kotlin.jvm.internal.j.b(r6, r7)
            if (r6 == 0) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x002c:
            r5 = r4
        L_0x002d:
            r8.sortOrder = r5
            com.facebook.gamingservices.internal.TournamentScoreType[] r0 = com.facebook.gamingservices.internal.TournamentScoreType.values()
            int r1 = r0.length
        L_0x0034:
            if (r2 >= r1) goto L_0x004a
            r3 = r0[r2]
            java.lang.String r5 = r3.name()
            java.lang.String r6 = r9.readString()
            boolean r5 = kotlin.jvm.internal.j.b(r5, r6)
            if (r5 == 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0034
        L_0x004a:
            r3 = r4
        L_0x004b:
            r8.scoreType = r3
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0065
            java.lang.String r0 = r9.readString()
            if (r0 != 0) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            com.facebook.gamingservices.internal.DateFormatter r1 = com.facebook.gamingservices.internal.DateFormatter.INSTANCE
            j$.time.ZonedDateTime r0 = r1.format$facebook_gamingservices_release(r0)
            j$.time.Instant r0 = j$.time.Instant.from(r0)
            goto L_0x0066
        L_0x0065:
            r0 = r4
        L_0x0066:
            r8.endTime = r0
            java.lang.String r9 = r9.readString()
            r8.payload = r9
            r8.image = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.TournamentConfig.<init>(android.os.Parcel):void");
    }
}
