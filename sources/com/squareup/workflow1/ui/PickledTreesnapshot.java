package com.squareup.workflow1.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.workflow1.TreeSnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\u00020\t8\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/squareup/workflow1/ui/PickledTreesnapshot;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "Lcom/squareup/workflow1/TreeSnapshot;", "a", "Lcom/squareup/workflow1/TreeSnapshot;", "()Lcom/squareup/workflow1/TreeSnapshot;", "snapshot", "<init>", "(Lcom/squareup/workflow1/TreeSnapshot;)V", "CREATOR", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class PickledTreesnapshot implements Parcelable {
    public static final a CREATOR = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final TreeSnapshot f23178a;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/PickledTreesnapshot$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/PickledTreesnapshot;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/PickledTreesnapshot;", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class a implements Parcelable.Creator<PickledTreesnapshot> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public PickledTreesnapshot createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            ByteString.Companion companion = ByteString.f33308c;
            byte[] createByteArray = parcel.createByteArray();
            j.d(createByteArray);
            j.f(createByteArray, "parcel.createByteArray()!!");
            return new PickledTreesnapshot(TreeSnapshot.f23059c.a(ByteString.Companion.e(companion, createByteArray, 0, 0, 3, (Object) null)));
        }

        /* renamed from: b */
        public PickledTreesnapshot[] newArray(int i10) {
            return new PickledTreesnapshot[i10];
        }
    }

    public PickledTreesnapshot(TreeSnapshot treeSnapshot) {
        j.g(treeSnapshot, "snapshot");
        this.f23178a = treeSnapshot;
    }

    public final TreeSnapshot a() {
        return this.f23178a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        parcel.writeByteArray(this.f23178a.c().N());
    }
}
