package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import ti.b;

public final class t extends RecyclerView.Adapter<c0> {

    /* renamed from: d  reason: collision with root package name */
    private final List<EnabledIdClass> f26010d;

    /* renamed from: e  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepStyle f26011e;

    /* renamed from: f  reason: collision with root package name */
    private final Function1<IdConfig, Unit> f26012f;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<Integer, Drawable> f26013g = new HashMap<>();

    public t(List<EnabledIdClass> list, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, Function1<? super IdConfig, Unit> function1) {
        j.g(list, "data");
        j.g(function1, "onClick");
        this.f26010d = list;
        this.f26011e = stepStyles$GovernmentIdStepStyle;
        this.f26012f = function1;
    }

    private final void H(c0 c0Var) {
        Double D;
        String V1;
        String a10;
        String l10;
        TextBasedComponentStyle E;
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle = this.f26011e;
        if (!(stepStyles$GovernmentIdStepStyle == null || (E = stepStyles$GovernmentIdStepStyle.E()) == null)) {
            m.e(c0Var.X(), E);
        }
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle2 = this.f26011e;
        if (!(stepStyles$GovernmentIdStepStyle2 == null || (l10 = stepStyles$GovernmentIdStepStyle2.l()) == null)) {
            c0Var.V().setColorFilter(Color.parseColor(l10));
        }
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle3 = this.f26011e;
        if (!(stepStyles$GovernmentIdStepStyle3 == null || (V1 = stepStyles$GovernmentIdStepStyle3.V1()) == null || (a10 = this.f26011e.a()) == null)) {
            c0Var.Z().setBackground(new RippleDrawable(I(Color.parseColor(a10)), new ColorDrawable(Color.parseColor(V1)), (Drawable) null));
        }
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle4 = this.f26011e;
        if (stepStyles$GovernmentIdStepStyle4 != null && (D = stepStyles$GovernmentIdStepStyle4.D()) != null) {
            c0Var.Y().setMinHeight((int) b.a(D.doubleValue()));
        }
    }

    private final ColorStateList I(int i10) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{i10});
    }

    private final Drawable J(Context context, Integer num, Integer num2, Drawable drawable) {
        Drawable mutate;
        ArrayList arrayList = new ArrayList();
        if (num != null) {
            num.intValue();
            drawable.mutate().setTint(num.intValue());
        }
        Drawable b10 = a.b(context, k0.pi2_governmentid_circle_background);
        if (num2 != null) {
            num2.intValue();
            if (!(b10 == null || (mutate = b10.mutate()) == null)) {
                mutate.setTint(num2.intValue());
            }
        }
        if (b10 != null) {
            arrayList.add(b10);
        }
        arrayList.add(drawable);
        return new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[0]));
    }

    /* access modifiers changed from: private */
    public static final void L(t tVar, EnabledIdClass enabledIdClass, View view) {
        j.g(tVar, "this$0");
        j.g(enabledIdClass, "$enabledIdClass");
        tVar.f26012f.invoke(enabledIdClass.c());
    }

    private final void N(c0 c0Var, Drawable drawable) {
        Integer num;
        String t10;
        String u10;
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle = this.f26011e;
        Integer num2 = null;
        if (stepStyles$GovernmentIdStepStyle == null || (u10 = stepStyles$GovernmentIdStepStyle.u()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(Color.parseColor(u10));
        }
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle2 = this.f26011e;
        if (!(stepStyles$GovernmentIdStepStyle2 == null || (t10 = stepStyles$GovernmentIdStepStyle2.t()) == null)) {
            num2 = Integer.valueOf(Color.parseColor(t10));
        }
        Context context = c0Var.Z().getContext();
        j.f(context, "holder.view.context");
        Drawable mutate = J(context, num, num2, drawable).mutate();
        j.f(mutate, "makeDrawable(holder.view…or, drawableRes).mutate()");
        c0Var.W().setImageDrawable(mutate);
    }

    /* renamed from: K */
    public void v(c0 c0Var, int i10) {
        j.g(c0Var, "holder");
        EnabledIdClass enabledIdClass = this.f26010d.get(i10);
        c0Var.X().setText(enabledIdClass.d());
        if (this.f26013g.get(Integer.valueOf(i10)) != null) {
            c0Var.W().setImageDrawable(this.f26013g.get(Integer.valueOf(i10)));
        } else {
            Drawable b10 = a.b(c0Var.Z().getContext(), enabledIdClass.a());
            if (b10 != null) {
                N(c0Var, b10);
                HashMap<Integer, Drawable> hashMap = this.f26013g;
                Integer valueOf = Integer.valueOf(i10);
                Drawable drawable = c0Var.W().getDrawable();
                j.f(drawable, "holder.icon.drawable");
                hashMap.put(valueOf, drawable);
            }
        }
        c0Var.Z().setOnClickListener(new s(this, enabledIdClass));
    }

    /* renamed from: M */
    public c0 x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(m0.pi2_governmentid_idlist, viewGroup, false);
        j.f(inflate, "from(parent.context).inf…nt,\n        false\n      )");
        c0 c0Var = new c0(inflate);
        H(c0Var);
        return c0Var;
    }

    public int g() {
        return this.f26010d.size();
    }
}
