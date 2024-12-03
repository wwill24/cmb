package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.m;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;

public class CheckableImageButton extends m implements Checkable {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f19784g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    private boolean f19785d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19786e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19787f;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f19788c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void c(@NonNull Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            this.f19788c = z10;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19788c ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            c(parcel);
        }
    }

    class a extends androidx.core.view.a {
        a() {
        }

        public void f(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        public void g(View view, @NonNull k kVar) {
            super.g(view, kVar);
            kVar.Y(CheckableImageButton.this.a());
            kVar.Z(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.imageButtonStyle);
    }

    public boolean a() {
        return this.f19786e;
    }

    public boolean isChecked() {
        return this.f19785d;
    }

    public int[] onCreateDrawableState(int i10) {
        if (!this.f19785d) {
            return super.onCreateDrawableState(i10);
        }
        int[] iArr = f19784g;
        return View.mergeDrawableStates(super.onCreateDrawableState(i10 + iArr.length), iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f19788c);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19788c = this.f19785d;
        return savedState;
    }

    public void setCheckable(boolean z10) {
        if (this.f19786e != z10) {
            this.f19786e = z10;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z10) {
        if (this.f19786e && this.f19785d != z10) {
            this.f19785d = z10;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z10) {
        this.f19787f = z10;
    }

    public void setPressed(boolean z10) {
        if (this.f19787f) {
            super.setPressed(z10);
        }
    }

    public void toggle() {
        setChecked(!this.f19785d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19786e = true;
        this.f19787f = true;
        n0.s0(this, new a());
    }
}
