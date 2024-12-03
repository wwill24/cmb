package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

public class DrawerLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<DrawerLayout$SavedState> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    int f5402c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f5403d;

    /* renamed from: e  reason: collision with root package name */
    int f5404e;

    /* renamed from: f  reason: collision with root package name */
    int f5405f;

    /* renamed from: g  reason: collision with root package name */
    int f5406g;

    class a implements Parcelable.ClassLoaderCreator<DrawerLayout$SavedState> {
        a() {
        }

        /* renamed from: a */
        public DrawerLayout$SavedState createFromParcel(Parcel parcel) {
            return new DrawerLayout$SavedState(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public DrawerLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new DrawerLayout$SavedState(parcel, classLoader);
        }

        /* renamed from: c */
        public DrawerLayout$SavedState[] newArray(int i10) {
            return new DrawerLayout$SavedState[i10];
        }
    }

    public DrawerLayout$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5402c = parcel.readInt();
        this.f5403d = parcel.readInt();
        this.f5404e = parcel.readInt();
        this.f5405f = parcel.readInt();
        this.f5406g = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f5402c);
        parcel.writeInt(this.f5403d);
        parcel.writeInt(this.f5404e);
        parcel.writeInt(this.f5405f);
        parcel.writeInt(this.f5406g);
    }
}
