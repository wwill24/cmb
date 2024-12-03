package p000if;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;

/* renamed from: if.a  reason: invalid package */
public class a implements View.OnTouchListener {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Dialog f23480a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23481b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23482c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23483d;

    public a(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f23480a = dialog;
        this.f23481b = rect.left;
        this.f23482c = rect.top;
        this.f23483d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f23481b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f23482c + findViewById.getTop();
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i10 = this.f23483d;
            obtain.setLocation((float) ((-i10) - 1), (float) ((-i10) - 1));
        }
        view.performClick();
        return this.f23480a.onTouchEvent(obtain);
    }
}
