package yn;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a  reason: collision with root package name */
    private d f42511a;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.f42511a = dVar;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.f42511a;
        if (dVar == null) {
            return false;
        }
        try {
            float y10 = dVar.y();
            float x10 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (y10 < this.f42511a.u()) {
                d dVar2 = this.f42511a;
                dVar2.G(dVar2.u(), x10, y11, true);
            } else if (y10 < this.f42511a.u() || y10 >= this.f42511a.t()) {
                d dVar3 = this.f42511a;
                dVar3.G(dVar3.v(), x10, y11, true);
            } else {
                d dVar4 = this.f42511a;
                dVar4.G(dVar4.t(), x10, y11, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF n10;
        d dVar = this.f42511a;
        if (dVar == null) {
            return false;
        }
        ImageView q10 = dVar.q();
        if (!(this.f42511a.w() == null || (n10 = this.f42511a.n()) == null)) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (n10.contains(x10, y10)) {
                this.f42511a.w().b(q10, (x10 - n10.left) / n10.width(), (y10 - n10.top) / n10.height());
                return true;
            }
            this.f42511a.w().a();
        }
        if (this.f42511a.x() != null) {
            this.f42511a.x().a(q10, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
