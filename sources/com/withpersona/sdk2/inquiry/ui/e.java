package com.withpersona.sdk2.inquiry.ui;

import aj.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class e extends RecyclerView.Adapter<f> {

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f29388d;

    /* renamed from: e  reason: collision with root package name */
    private final UiComponent.InputSelectComponentStyle f29389e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f29390f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<String, Unit> f29391g;

    /* renamed from: h  reason: collision with root package name */
    private final LayoutInflater f29392h;

    /* renamed from: j  reason: collision with root package name */
    private Set<String> f29393j;

    public e(Context context, List<String> list, UiComponent.InputSelectComponentStyle inputSelectComponentStyle, boolean z10, List<String> list2, Function1<? super String, Unit> function1) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        j.g(list2, "initialSelectedValues");
        j.g(function1, "onClick");
        this.f29388d = list;
        this.f29389e = inputSelectComponentStyle;
        this.f29390f = z10;
        this.f29391g = function1;
        this.f29392h = LayoutInflater.from(context);
        Set B0 = CollectionsKt___CollectionsKt.B0(list);
        ArrayList arrayList = new ArrayList();
        for (T next : list2) {
            if (B0.contains((String) next)) {
                arrayList.add(next);
            }
        }
        this.f29393j = CollectionsKt___CollectionsKt.A0(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void K(e eVar, f fVar, View view) {
        j.g(eVar, "this$0");
        j.g(fVar, "$holder");
        eVar.N(fVar.q());
    }

    /* access modifiers changed from: private */
    public static final void L(e eVar, f fVar, View view) {
        j.g(eVar, "this$0");
        j.g(fVar, "$holder");
        eVar.N(fVar.q());
    }

    private final void N(int i10) {
        if (!this.f29390f) {
            this.f29393j.clear();
        }
        String str = this.f29388d.get(i10);
        if (this.f29393j.contains(str)) {
            this.f29393j.remove(str);
        } else {
            this.f29393j.add(str);
        }
        m(i10);
        this.f29391g.invoke(str);
    }

    public final List<String> I() {
        return CollectionsKt___CollectionsKt.x0(this.f29393j);
    }

    /* renamed from: J */
    public void v(f fVar, int i10) {
        j.g(fVar, "holder");
        String str = this.f29388d.get(i10);
        fVar.W().setText(str);
        fVar.f6302a.setOnClickListener(new c(this, fVar));
        fVar.V().setOnClickListener(new d(this, fVar));
        fVar.V().setChecked(this.f29393j.contains(str));
    }

    /* renamed from: M */
    public f x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        m c10 = m.c(this.f29392h, viewGroup, false);
        j.f(c10, "inflate(inflater, parent, false)");
        f fVar = new f(c10);
        UiComponent.InputSelectComponentStyle inputSelectComponentStyle = this.f29389e;
        if (inputSelectComponentStyle != null) {
            com.withpersona.sdk2.inquiry.steps.ui.styling.m.e(fVar.W(), inputSelectComponentStyle.w());
        }
        if (this.f29390f) {
            fVar.V().setVisibility(0);
            fVar.V().setButtonTintList(ColorStateList.valueOf(fVar.W().getCurrentTextColor()));
        } else {
            fVar.V().setVisibility(8);
        }
        return fVar;
    }

    public int g() {
        return this.f29388d.size();
    }
}
