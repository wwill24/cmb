package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import q5.i;
import q5.k;
import s5.c;

public final class DialogPrimarySecondaryVertical extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12065a = new a((DefaultConstructorMarker) null);

    public enum PrimaryCtaStyle {
        NORMAL(k.primary_button_selector),
        DESTRUCTIVE(k.destructive_button_selector);
        
        private final int value;

        private PrimaryCtaStyle(int i10) {
            this.value = i10;
        }

        public final int b() {
            return this.value;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(a aVar, Context context, PrimaryCtaStyle primaryCtaStyle, Integer num, int i10, int i11, int i12, Function0 function0, Integer num2, Function0 function02, Function0 function03, int i13, Object obj) {
            PrimaryCtaStyle primaryCtaStyle2;
            Integer num3;
            Integer num4;
            Function0 function04;
            Function0 function05;
            int i14 = i13;
            if ((i14 & 2) != 0) {
                primaryCtaStyle2 = PrimaryCtaStyle.NORMAL;
            } else {
                primaryCtaStyle2 = primaryCtaStyle;
            }
            if ((i14 & 4) != 0) {
                num3 = null;
            } else {
                num3 = num;
            }
            if ((i14 & 128) != 0) {
                num4 = null;
            } else {
                num4 = num2;
            }
            if ((i14 & 256) != 0) {
                function04 = null;
            } else {
                function04 = function02;
            }
            if ((i14 & 512) != 0) {
                function05 = null;
            } else {
                function05 = function03;
            }
            aVar.a(context, primaryCtaStyle2, num3, i10, i11, i12, function0, num4, function04, function05);
        }

        public static /* synthetic */ void d(a aVar, Context context, PrimaryCtaStyle primaryCtaStyle, Integer num, String str, String str2, String str3, Function0 function0, String str4, Function0 function02, Function0 function03, int i10, Object obj) {
            PrimaryCtaStyle primaryCtaStyle2;
            Integer num2;
            String str5;
            Function0 function04;
            Function0 function05;
            int i11 = i10;
            if ((i11 & 2) != 0) {
                primaryCtaStyle2 = PrimaryCtaStyle.NORMAL;
            } else {
                primaryCtaStyle2 = primaryCtaStyle;
            }
            if ((i11 & 4) != 0) {
                num2 = null;
            } else {
                num2 = num;
            }
            if ((i11 & 128) != 0) {
                str5 = null;
            } else {
                str5 = str4;
            }
            if ((i11 & 256) != 0) {
                function04 = null;
            } else {
                function04 = function02;
            }
            if ((i11 & 512) != 0) {
                function05 = null;
            } else {
                function05 = function03;
            }
            aVar.b(context, primaryCtaStyle2, num2, str, str2, str3, function0, str5, function04, function05);
        }

        public final void a(Context context, PrimaryCtaStyle primaryCtaStyle, Integer num, int i10, int i11, int i12, Function0<Unit> function0, Integer num2, Function0<Unit> function02, Function0<Unit> function03) {
            String str;
            Context context2 = context;
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(primaryCtaStyle, "style");
            j.g(function0, "primaryClickListener");
            Resources resources = context.getResources();
            String string = resources.getString(i10);
            j.f(string, "resources.getString(title)");
            String string2 = resources.getString(i11);
            j.f(string2, "resources.getString(text)");
            String string3 = resources.getString(i12);
            j.f(string3, "resources.getString(primary)");
            if (num2 != null) {
                str = resources.getString(num2.intValue());
            } else {
                str = null;
            }
            new DialogPrimarySecondaryVertical(context, primaryCtaStyle, num, string, string2, string3, function0, str, function02, function03, (DefaultConstructorMarker) null).show();
        }

        public final void b(Context context, PrimaryCtaStyle primaryCtaStyle, Integer num, String str, String str2, String str3, Function0<Unit> function0, String str4, Function0<Unit> function02, Function0<Unit> function03) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(primaryCtaStyle, "style");
            String str5 = str;
            j.g(str5, "title");
            String str6 = str2;
            j.g(str6, "text");
            String str7 = str3;
            j.g(str7, "primary");
            Function0<Unit> function04 = function0;
            j.g(function04, "primaryClickListener");
            new DialogPrimarySecondaryVertical(context, primaryCtaStyle, num, str5, str6, str7, function04, str4, function02, function03, (DefaultConstructorMarker) null).show();
        }
    }

    private DialogPrimarySecondaryVertical(Context context, PrimaryCtaStyle primaryCtaStyle, Integer num, String str, String str2, String str3, Function0<Unit> function0, String str4, Function0<Unit> function02, Function0<Unit> function03) {
        super(context, 16973834);
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawableResource(i.black_transparent_60pc);
        }
        c c10 = c.c(LayoutInflater.from(context));
        j.f(c10, "inflate(LayoutInflater.from(context))");
        setContentView(c10.getRoot());
        if (num != null) {
            c10.f17489d.setImageDrawable(androidx.core.content.a.getDrawable(context, num.intValue()));
            c10.f17489d.setVisibility(0);
        } else {
            c10.f17489d.setVisibility(8);
        }
        c10.f17488c.setText(str);
        c10.f17487b.setText(str2);
        c10.f17490e.setText(str3);
        c10.f17490e.setOnClickListener(new t(function0, this));
        c10.f17490e.setBackground(androidx.core.content.a.getDrawable(context, primaryCtaStyle.b()));
        if (str4 != null) {
            c10.f17491f.setText(str4);
            c10.f17491f.setVisibility(0);
            c10.f17491f.setOnClickListener(new u(function02, this));
        } else {
            c10.f17491f.setVisibility(8);
        }
        setOnCancelListener(new v(function03));
    }

    public /* synthetic */ DialogPrimarySecondaryVertical(Context context, PrimaryCtaStyle primaryCtaStyle, Integer num, String str, String str2, String str3, Function0 function0, String str4, Function0 function02, Function0 function03, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, primaryCtaStyle, num, str, str2, str3, function0, str4, function02, function03);
    }

    /* access modifiers changed from: private */
    public static final void d(Function0 function0, DialogPrimarySecondaryVertical dialogPrimarySecondaryVertical, View view) {
        j.g(function0, "$primaryClickListener");
        j.g(dialogPrimarySecondaryVertical, "this$0");
        function0.invoke();
        dialogPrimarySecondaryVertical.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void e(Function0 function0, DialogPrimarySecondaryVertical dialogPrimarySecondaryVertical, View view) {
        j.g(dialogPrimarySecondaryVertical, "this$0");
        if (function0 != null) {
            function0.invoke();
        }
        dialogPrimarySecondaryVertical.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void f(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}
