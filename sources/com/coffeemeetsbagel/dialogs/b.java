package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public abstract class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f12081a = ((CmbTextView) findViewById(R.id.closeable_dialog_title));

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f12082b = ((CmbTextView) findViewById(R.id.closeable_dialog_text));

    /* renamed from: c  reason: collision with root package name */
    private TextView f12083c = ((TextView) findViewById(R.id.closeable_dialog_selection_counter));

    public interface a {
        String a();
    }

    /* renamed from: com.coffeemeetsbagel.dialogs.b$b  reason: collision with other inner class name */
    public interface C0132b<Item> {
        void a(Item item);

        void b(Item item);
    }

    b(Context context, String str, String str2) {
        super(context);
        f();
        e(str);
        d(str2);
        ((CmbImageView) findViewById(R.id.closeable_dialog_close_button)).setOnClickListener(new a(this));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.closeable_dialog_content);
        View b10 = b(context, relativeLayout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b10.getLayoutParams();
        layoutParams.addRule(3, R.id.closeable_dialog_text);
        b10.setLayoutParams(layoutParams);
        relativeLayout.addView(b10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    private void f() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.abstract_closeable_dialog_dls);
    }

    /* access modifiers changed from: package-private */
    public abstract View b(Context context, ViewGroup viewGroup);

    public void d(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12082b;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12082b.setText(str);
    }

    public void e(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12081a;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12081a.setText(str);
    }

    public void g(int i10) {
        this.f12083c.setVisibility(0);
        String string = getContext().getString(R.string.selections_left, new Object[]{Integer.valueOf(i10)});
        if (i10 == 0) {
            this.f12083c.setBackgroundResource(R.drawable.pill_light_gray);
            this.f12083c.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.dark_gray));
        } else {
            this.f12083c.setBackgroundResource(R.drawable.pill_accent);
            this.f12083c.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.main_color));
        }
        this.f12083c.setText(string);
    }
}
