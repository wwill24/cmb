package cj;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.google.android.material.button.MaterialButton;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.a;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import kotlin.jvm.internal.j;
import vi.d;

public final class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final d f24937a;

    /* renamed from: b  reason: collision with root package name */
    private final a f24938b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24939c;

    /* renamed from: d  reason: collision with root package name */
    private final MaterialButton f24940d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, a aVar) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        d b10 = d.b(LayoutInflater.from(getContext()), this);
        j.f(b10, "inflate(LayoutInflater.from(context), this)");
        this.f24937a = b10;
        this.f24940d = b(this, (Integer) null, 1, (Object) null);
        this.f24938b = aVar;
        c();
    }

    private final MaterialButton a(Integer num) {
        MaterialButton materialButton;
        if (num == null) {
            materialButton = new MaterialButton(getContext());
        } else {
            materialButton = new MaterialButton(getContext(), (AttributeSet) null, num.intValue());
        }
        addView(materialButton, 0);
        return materialButton;
    }

    static /* synthetic */ MaterialButton b(b bVar, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        return bVar.a(num);
    }

    private final void c() {
        getProgressBar().setIndeterminateTintList(ColorStateList.valueOf(this.f24940d.getCurrentTextColor()));
    }

    private final void d() {
        String n10;
        a aVar = this.f24938b;
        if (aVar != null && (n10 = aVar.n()) != null) {
            getProgressBar().setIndeterminateTintList(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(n10)}));
        }
    }

    private final void e() {
        if (this.f24939c) {
            this.f24940d.setTextScaleX(0.0f);
            getProgressBar().setVisibility(0);
        } else {
            this.f24940d.setTextScaleX(1.0f);
            getProgressBar().setVisibility(8);
        }
        a aVar = this.f24938b;
        if (aVar != null) {
            ButtonStylingKt.c(this.f24940d, aVar, this.f24939c, false, 4, (Object) null);
            if (this.f24939c) {
                d();
            }
        }
    }

    public final MaterialButton getButton() {
        return this.f24940d;
    }

    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.f24937a.f33909b;
        j.f(progressBar, "binding.progressBar");
        return progressBar;
    }

    public final CharSequence getText() {
        CharSequence text = this.f24940d.getText();
        j.f(text, "button.text");
        return text;
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f24940d.setEnabled(z10);
        e();
    }

    public final void setIsLoading(boolean z10) {
        if (this.f24939c != z10) {
            this.f24939c = z10;
            e();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f24940d.setOnClickListener(onClickListener);
    }

    public final void setText(CharSequence charSequence) {
        j.g(charSequence, "value");
        this.f24940d.setText(charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, int i10) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        d b10 = d.b(LayoutInflater.from(getContext()), this);
        j.f(b10, "inflate(LayoutInflater.from(context), this)");
        this.f24937a = b10;
        this.f24940d = a(Integer.valueOf(i10));
        this.f24938b = null;
        c();
    }
}
