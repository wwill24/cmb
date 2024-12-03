package r7;

import android.app.Dialog;
import android.content.Context;
import q5.i;
import q5.m;
import q5.o;

public class h extends Dialog {
    public h(Context context) {
        super(context, o.CmbAppTheme);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(i.transparent);
        }
        setContentView(m.dialog_progress_dls);
    }
}
