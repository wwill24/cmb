package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareMediaContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareMediaContent$Builder;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "media", "", "Lcom/facebook/share/model/ShareMedia;", "getMedia", "()Ljava/util/List;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new ShareMediaContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<ShareMedia<?, ?>> media;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\u00002\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010\u0010\u001a\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\nR\"\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareMediaContent;", "()V", "media", "", "Lcom/facebook/share/model/ShareMedia;", "getMedia$facebook_common_release", "()Ljava/util/List;", "addMedia", "", "addMedium", "medium", "build", "readFrom", "content", "setMedia", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia<?, ?>> media = new ArrayList();

        public final Builder addMedia(List<? extends ShareMedia<?, ?>> list) {
            if (list != null) {
                for (ShareMedia addMedium : list) {
                    addMedium(addMedium);
                }
            }
            return this;
        }

        public final Builder addMedium(ShareMedia<?, ?> shareMedia) {
            Object obj;
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    obj = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    obj = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                this.media.add(obj);
            }
            return this;
        }

        public final List<ShareMedia<?, ?>> getMedia$facebook_common_release() {
            return this.media;
        }

        public final Builder setMedia(List<? extends ShareMedia<?, ?>> list) {
            this.media.clear();
            addMedia(list);
            return this;
        }

        public ShareMediaContent build() {
            return new ShareMediaContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            return shareMediaContent == null ? this : ((Builder) super.readFrom(shareMediaContent)).addMedia(shareMediaContent.getMedia());
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareMediaContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ShareMediaContent(Builder builder) {
        super(builder);
        this.media = CollectionsKt___CollectionsKt.x0(builder.getMedia$facebook_common_release());
    }

    public /* synthetic */ ShareMediaContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final List<ShareMedia<?, ?>> getMedia() {
        return this.media;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        super.writeToParcel(parcel, i10);
        Object[] array2 = this.media.toArray(new ShareMedia[0]);
        if (array2 != null) {
            parcel.writeParcelableArray((Parcelable[]) array2, i10);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareMediaContent(Parcel parcel) {
        super(parcel);
        List<ShareMedia<?, ?>> list;
        j.g(parcel, "source");
        Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
        if (readParcelableArray == null) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : readParcelableArray) {
                ShareMedia shareMedia = (ShareMedia) parcelable;
                if (shareMedia != null) {
                    arrayList.add(shareMedia);
                }
            }
            list = arrayList;
        }
        this.media = list == null ? q.j() : list;
    }
}
