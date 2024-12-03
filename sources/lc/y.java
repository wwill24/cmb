package lc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Unit;
import kotlin.jvm.internal.j;

public final class y {
    public static final void a(TextView textView, Integer num, int i10, int i11) {
        Unit unit;
        j.g(textView, "<this>");
        if (num != null) {
            Drawable drawable = a.getDrawable(textView.getContext(), num.intValue());
            if (drawable != null) {
                Drawable mutate = drawable.mutate();
                j.f(mutate, "it.mutate()");
                m mVar = m.f41114a;
                Context context = textView.getContext();
                j.f(context, IdentityHttpResponse.CONTEXT);
                int a10 = mVar.a(context, (float) i11);
                mutate.setBounds(0, 0, a10, a10);
                mutate.setTint(a.getColor(textView.getContext(), i10));
                textView.setCompoundDrawables(mutate, (Drawable) null, (Drawable) null, (Drawable) null);
                unit = Unit.f32013a;
            } else {
                unit = null;
            }
            if (unit == null) {
                textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public static /* synthetic */ void b(TextView textView, Integer num, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 16;
        }
        a(textView, num, i10, i11);
    }
}
