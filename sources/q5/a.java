package q5;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import qj.q;

public class a extends ConstraintLayout {
    private final PublishSubject<x> F = PublishSubject.C0();

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> B() {
        return this.F.P();
    }

    public boolean performClick() {
        this.F.d(x.a());
        return super.performClick();
    }
}
