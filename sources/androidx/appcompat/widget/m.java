package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import d.a;

public class m extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private final d f1340a;

    /* renamed from: b  reason: collision with root package name */
    private final n f1341b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1342c;

    public m(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1340a;
        if (dVar != null) {
            dVar.b();
        }
        n nVar = this.f1341b;
        if (nVar != null) {
            nVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1340a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1340a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        n nVar = this.f1341b;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.f1341b;
        if (nVar != null) {
            return nVar.e();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1341b.f() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1340a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1340a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.f1341b;
        if (nVar != null) {
            nVar.c();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        n nVar = this.f1341b;
        if (!(nVar == null || drawable == null || this.f1342c)) {
            nVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        n nVar2 = this.f1341b;
        if (nVar2 != null) {
            nVar2.c();
            if (!this.f1342c) {
                this.f1341b.b();
            }
        }
    }

    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f1342c = true;
    }

    public void setImageResource(int i10) {
        this.f1341b.i(i10);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.f1341b;
        if (nVar != null) {
            nVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1340a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1340a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.f1341b;
        if (nVar != null) {
            nVar.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.f1341b;
        if (nVar != null) {
            nVar.k(mode);
        }
    }

    public m(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        this.f1342c = false;
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1340a = dVar;
        dVar.e(attributeSet, i10);
        n nVar = new n(this);
        this.f1341b = nVar;
        nVar.g(attributeSet, i10);
    }
}
