package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import j5.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qj.q;

public class DialogMultiButtonDls extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f12052a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f12053b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f12054c;

    /* renamed from: d  reason: collision with root package name */
    private Map<Button, CmbTextView> f12055d;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12064a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.coffeemeetsbagel.dialogs.DialogMultiButtonDls$Button$Type[] r0 = com.coffeemeetsbagel.dialogs.DialogMultiButtonDls.Button.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12064a = r0
                com.coffeemeetsbagel.dialogs.DialogMultiButtonDls$Button$Type r1 = com.coffeemeetsbagel.dialogs.DialogMultiButtonDls.Button.Type.PRIMARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12064a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.dialogs.DialogMultiButtonDls$Button$Type r1 = com.coffeemeetsbagel.dialogs.DialogMultiButtonDls.Button.Type.SECONDARY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12064a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.dialogs.DialogMultiButtonDls$Button$Type r1 = com.coffeemeetsbagel.dialogs.DialogMultiButtonDls.Button.Type.DESTRUCTIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12064a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.dialogs.DialogMultiButtonDls$Button$Type r1 = com.coffeemeetsbagel.dialogs.DialogMultiButtonDls.Button.Type.DESTRUCTIVE_SECONDARY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.dialogs.DialogMultiButtonDls.a.<clinit>():void");
        }
    }

    public DialogMultiButtonDls(Context context, int i10, int i11, List<Button> list) {
        this(context, context.getString(i10), context.getString(i11), list);
    }

    private CmbTextView b(Button button, Context context) {
        int i10 = a.f12064a[button.f12056a.ordinal()];
        if (i10 == 1) {
            return (CmbTextView) LayoutInflater.from(context).inflate(R.layout.primary_button_dls, this.f12052a, false);
        }
        if (i10 == 2) {
            return (CmbTextView) LayoutInflater.from(context).inflate(R.layout.secondary_button_dls, this.f12052a, false);
        }
        if (i10 == 3) {
            return (CmbTextView) LayoutInflater.from(context).inflate(R.layout.destructive_button_dls, this.f12052a, false);
        }
        if (i10 == 4) {
            return (CmbTextView) LayoutInflater.from(context).inflate(R.layout.destructive_secondary_button_dls, this.f12052a, false);
        }
        throw new IllegalArgumentException("Invalid button type: " + button.f12056a);
    }

    private void f() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.dialog_multi_button_dls);
    }

    public q<x> a(Button button) {
        return this.f12055d.get(button).s();
    }

    public void c(Button button, View.OnClickListener onClickListener) {
        TextView textView = this.f12055d.get(button);
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void d(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12054c;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12054c.setText(str);
    }

    public void e(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12053b;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12053b.setText(str);
    }

    public DialogMultiButtonDls(Context context, String str, String str2, List<Button> list) {
        super(context);
        this.f12055d = new HashMap();
        f();
        this.f12052a = (LinearLayout) findViewById(R.id.dialog_multi_button_view);
        this.f12054c = (CmbTextView) findViewById(R.id.dialog_multi_buttons_text);
        this.f12053b = (CmbTextView) findViewById(R.id.dialog_multi_button_title);
        e(str);
        d(str2);
        for (Button next : list) {
            CmbTextView b10 = b(next, context);
            b10.setGravity(next.f12058c);
            b10.setText(next.f12057b);
            this.f12052a.addView(b10);
            this.f12055d.put(next, b10);
        }
    }

    public static class Button {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Type f12056a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f12057b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f12058c;

        public enum Type {
            PRIMARY,
            SECONDARY,
            DESTRUCTIVE,
            DESTRUCTIVE_SECONDARY
        }

        public Button(Type type, String str) {
            this.f12058c = 17;
            this.f12056a = type;
            this.f12057b = str;
        }

        public Button(Type type, String str, int i10) {
            this.f12056a = type;
            this.f12057b = str;
            this.f12058c = i10;
        }
    }
}
