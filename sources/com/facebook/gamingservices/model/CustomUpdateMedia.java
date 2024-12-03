package com.facebook.gamingservices.model;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "", "Lorg/json/b;", "toJSONObject", "Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "component1", "component2", "gif", "video", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "getGif", "()Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "getVideo", "<init>", "(Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;)V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
public final class CustomUpdateMedia {
    private final CustomUpdateMediaInfo gif;
    private final CustomUpdateMediaInfo video;

    public CustomUpdateMedia() {
        this((CustomUpdateMediaInfo) null, (CustomUpdateMediaInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        this.gif = customUpdateMediaInfo;
        this.video = customUpdateMediaInfo2;
    }

    public static /* synthetic */ CustomUpdateMedia copy$default(CustomUpdateMedia customUpdateMedia, CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            customUpdateMediaInfo = customUpdateMedia.gif;
        }
        if ((i10 & 2) != 0) {
            customUpdateMediaInfo2 = customUpdateMedia.video;
        }
        return customUpdateMedia.copy(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public final CustomUpdateMediaInfo component1() {
        return this.gif;
    }

    public final CustomUpdateMediaInfo component2() {
        return this.video;
    }

    public final CustomUpdateMedia copy(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        return new CustomUpdateMedia(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateMedia)) {
            return false;
        }
        CustomUpdateMedia customUpdateMedia = (CustomUpdateMedia) obj;
        return j.b(this.gif, customUpdateMedia.gif) && j.b(this.video, customUpdateMedia.video);
    }

    public final CustomUpdateMediaInfo getGif() {
        return this.gif;
    }

    public final CustomUpdateMediaInfo getVideo() {
        return this.video;
    }

    public int hashCode() {
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        int i10 = 0;
        int hashCode = (customUpdateMediaInfo == null ? 0 : customUpdateMediaInfo.hashCode()) * 31;
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            i10 = customUpdateMediaInfo2.hashCode();
        }
        return hashCode + i10;
    }

    public final b toJSONObject() {
        b bVar = new b();
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        if (customUpdateMediaInfo != null) {
            b bVar2 = new b();
            bVar2.put("url", (Object) customUpdateMediaInfo.getUrl());
            bVar.put("gif", (Object) bVar2);
        }
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            b bVar3 = new b();
            bVar3.put("url", (Object) customUpdateMediaInfo2.getUrl());
            bVar.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, (Object) bVar3);
        }
        return bVar;
    }

    public String toString() {
        return "CustomUpdateMedia(gif=" + this.gif + ", video=" + this.video + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : customUpdateMediaInfo, (i10 & 2) != 0 ? null : customUpdateMediaInfo2);
    }
}
