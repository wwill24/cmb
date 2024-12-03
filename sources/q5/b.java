package q5;

import android.view.KeyEvent;
import android.widget.TextView;
import com.coffeemeetsbagel.cmb_views.CmbEditText;

public final /* synthetic */ class b implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CmbEditText f17166a;

    public /* synthetic */ b(CmbEditText cmbEditText) {
        this.f17166a = cmbEditText;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return this.f17166a.h(textView, i10, keyEvent);
    }
}
