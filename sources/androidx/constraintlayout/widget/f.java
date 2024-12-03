package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.bytebuddy.description.type.TypeDescription;

public class f extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f4331a;

    /* renamed from: b  reason: collision with root package name */
    private View f4332b;

    /* renamed from: c  reason: collision with root package name */
    private int f4333c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f4332b != null) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f4332b.getLayoutParams();
            bVar2.f4179v0.j1(0);
            ConstraintWidget.DimensionBehaviour A = bVar.f4179v0.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            if (A != dimensionBehaviour) {
                bVar.f4179v0.k1(bVar2.f4179v0.W());
            }
            if (bVar.f4179v0.T() != dimensionBehaviour) {
                bVar.f4179v0.L0(bVar2.f4179v0.x());
            }
            bVar2.f4179v0.j1(8);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f4331a == -1 && !isInEditMode()) {
            setVisibility(this.f4333c);
        }
        View findViewById = constraintLayout.findViewById(this.f4331a);
        this.f4332b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).f4155j0 = true;
            this.f4332b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f4332b;
    }

    public int getEmptyVisibility() {
        return this.f4333c;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(TypeDescription.Generic.OfWildcardType.SYMBOL, 0, 1, rect);
            canvas.drawText(TypeDescription.Generic.OfWildcardType.SYMBOL, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i10) {
        View findViewById;
        if (this.f4331a != i10) {
            View view = this.f4332b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.b) this.f4332b.getLayoutParams()).f4155j0 = false;
                this.f4332b = null;
            }
            this.f4331a = i10;
            if (i10 != -1 && (findViewById = ((View) getParent()).findViewById(i10)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i10) {
        this.f4333c = i10;
    }
}
