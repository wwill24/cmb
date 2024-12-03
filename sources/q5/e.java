package q5;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class e implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f17169a;

    public /* synthetic */ e(float f10) {
        this.f17169a = f10;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return f.d(this.f17169a, view, motionEvent);
    }
}
