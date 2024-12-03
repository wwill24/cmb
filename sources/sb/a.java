package sb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bf.f;
import com.google.android.material.snackbar.Snackbar;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.reference.element.ReferenceElement;
import q5.i;
import q5.l;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f41914a = new a();

    private a() {
    }

    private final void a(Snackbar snackbar, Integer num) {
        View K = snackbar.K();
        j.f(K, "snackbar.view");
        TextView textView = (TextView) K.findViewById(l.snackbar_text);
        if (num != null) {
            K.setBackgroundResource(num.intValue());
        } else {
            K.setBackgroundResource(i.main_color);
        }
        textView.setGravity(16);
        K.setElevation(snackbar.K().getContext().getResources().getDimension(q5.j.spacer_1));
        ViewGroup.LayoutParams layoutParams = K.getLayoutParams();
        j.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(0);
        marginLayoutParams.setMarginEnd(0);
    }

    static /* synthetic */ void b(a aVar, Snackbar snackbar, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        aVar.a(snackbar, num);
    }

    public static final void c(View view, int i10, int i11, View view2) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        j.g(view2, ReferenceElement.ATTR_ANCHOR);
        a aVar = f41914a;
        String string = view.getResources().getString(i10);
        j.f(string, "parent.resources.getString(messageStringResId)");
        aVar.d(view, string, i11, view2);
    }

    private final void d(View view, String str, int i10, View view2) {
        Snackbar n02 = Snackbar.n0(view, str, i10);
        j.f(n02, "make(parent, message, length)");
        b(this, n02, (Integer) null, 2, (Object) null);
        n02.W(view2);
        View findViewById = n02.K().findViewById(f.snackbar_text);
        j.e(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setMaxLines(5);
        n02.b0();
    }

    static /* synthetic */ void e(a aVar, View view, String str, int i10, View view2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            view2 = null;
        }
        aVar.d(view, str, i10, view2);
    }

    public static final void f(View view, int i10) {
        int i11;
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        String string = view.getResources().getString(i10);
        j.f(string, "parent.resources.getString(messageStringResId)");
        if (string.length() < 100) {
            i11 = -1;
        } else {
            i11 = 0;
        }
        e(f41914a, view, string, i11, (View) null, 8, (Object) null);
    }

    public static final void g(View view, int i10) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        a aVar = f41914a;
        String string = view.getResources().getString(i10);
        j.f(string, "parent.resources.getString(messageStringResId)");
        e(aVar, view, string, 0, (View) null, 8, (Object) null);
    }

    public static final void h(View view, String str) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        j.g(str, "message");
        e(f41914a, view, str, 0, (View) null, 8, (Object) null);
    }

    public static final void i(View view, int i10) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        a aVar = f41914a;
        String string = view.getResources().getString(i10);
        j.f(string, "parent.resources.getString(messageStringResId)");
        e(aVar, view, string, 0, (View) null, 8, (Object) null);
    }

    public static final void j(View view, String str) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        j.g(str, "message");
        e(f41914a, view, str, 0, (View) null, 8, (Object) null);
    }

    public static final void k(View view, int i10) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        a aVar = f41914a;
        String string = view.getResources().getString(i10);
        j.f(string, "parent.resources.getString(messageStringResId)");
        e(aVar, view, string, -1, (View) null, 8, (Object) null);
    }

    public static final void l(View view, int i10, int i11) {
        j.g(view, Message.Thread.PARENT_ATTRIBUTE_NAME);
        a aVar = f41914a;
        String string = view.getResources().getString(i10);
        j.f(string, "parent.resources.getString(messageStringResId)");
        e(aVar, view, string, i11, (View) null, 8, (Object) null);
    }
}
