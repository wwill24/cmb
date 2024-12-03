package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

class SlidingPaneLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SlidingPaneLayout$SavedState> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    boolean f7006c;

    static class a implements Parcelable.ClassLoaderCreator<SlidingPaneLayout$SavedState> {
        a() {
        }

        /* renamed from: a */
        public SlidingPaneLayout$SavedState createFromParcel(Parcel parcel) {
            return new SlidingPaneLayout$SavedState(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public SlidingPaneLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new SlidingPaneLayout$SavedState(parcel, (ClassLoader) null);
        }

        /* renamed from: c */
        public SlidingPaneLayout$SavedState[] newArray(int i10) {
            return new SlidingPaneLayout$SavedState[i10];
        }
    }

    SlidingPaneLayout$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean z10;
        if (parcel.readInt() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f7006c = z10;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f7006c ? 1 : 0);
    }
}
