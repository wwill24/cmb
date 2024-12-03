package com.squareup.workflow1.ui.backstack;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/ViewStateFrame;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "toString", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "Landroid/util/SparseArray;", "b", "Landroid/util/SparseArray;", "()Landroid/util/SparseArray;", "viewState", "<init>", "(Ljava/lang/String;Landroid/util/SparseArray;)V", "CREATOR", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public final class ViewStateFrame implements Parcelable {
    public static final a CREATOR = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f23232a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<Parcelable> f23233b;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/ViewStateFrame$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/backstack/ViewStateFrame;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/backstack/ViewStateFrame;", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class a implements Parcelable.Creator<ViewStateFrame> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public ViewStateFrame createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            j.d(readString);
            j.f(readString, "parcel.readString()!!");
            SparseArray readSparseArray = parcel.readSparseArray(ViewStateFrame.class.getClassLoader());
            j.d(readSparseArray);
            j.f(readSparseArray, "parcel.readSparseArray<P…class.java.classLoader)!!");
            return new ViewStateFrame(readString, readSparseArray);
        }

        /* renamed from: b */
        public ViewStateFrame[] newArray(int i10) {
            return new ViewStateFrame[i10];
        }
    }

    public ViewStateFrame(String str, SparseArray<Parcelable> sparseArray) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(sparseArray, "viewState");
        this.f23232a = str;
        this.f23233b = sparseArray;
    }

    public final SparseArray<Parcelable> a() {
        return this.f23233b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewStateFrame)) {
            return false;
        }
        ViewStateFrame viewStateFrame = (ViewStateFrame) obj;
        return j.b(this.f23232a, viewStateFrame.f23232a) && j.b(this.f23233b, viewStateFrame.f23233b);
    }

    public int hashCode() {
        return (this.f23232a.hashCode() * 31) + this.f23233b.hashCode();
    }

    public String toString() {
        return "ViewStateFrame(key=" + this.f23232a + ", viewState=" + this.f23233b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "parcel");
        parcel.writeString(this.f23232a);
        parcel.writeSparseArray(this.f23233b);
    }
}
