package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class AppCompatImageView extends ImageView {
    private final d mBackgroundTintHelper;
    private boolean mHasLevel;
    private final n mImageHelper;

    public AppCompatImageView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.b();
        }
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            return nVar.e();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.f() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.c();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        n nVar = this.mImageHelper;
        if (!(nVar == null || drawable == null || this.mHasLevel)) {
            nVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        n nVar2 = this.mImageHelper;
        if (nVar2 != null) {
            nVar2.c();
            if (!this.mHasLevel) {
                this.mImageHelper.b();
            }
        }
    }

    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.mHasLevel = true;
    }

    public void setImageResource(int i10) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.i(i10);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.mImageHelper;
        if (nVar != null) {
            nVar.k(mode);
        }
    }

    public AppCompatImageView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        this.mHasLevel = false;
        c1.a(this, getContext());
        d dVar = new d(this);
        this.mBackgroundTintHelper = dVar;
        dVar.e(attributeSet, i10);
        n nVar = new n(this);
        this.mImageHelper = nVar;
        nVar.g(attributeSet, i10);
    }
}
