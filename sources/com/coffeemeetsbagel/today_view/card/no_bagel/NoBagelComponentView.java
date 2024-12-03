package com.coffeemeetsbagel.today_view.card.no_bagel;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.mparticle.identity.IdentityHttpResponse;
import fc.l;
import io.reactivex.subjects.PublishSubject;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import qj.q;
import w9.b;

public class NoBagelComponentView extends ConstraintLayout {
    private final PublishSubject<NoBagelClickOption> F;
    private CmbTextView G;
    private CmbTextView H;
    private CmbTextView I;
    private ImageView J;
    private ImageView K;
    private LinearLayout L;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NoBagelComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoBagelComponentView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* access modifiers changed from: private */
    public static final void D(NoBagelComponentView noBagelComponentView, NoBagelClickOption noBagelClickOption, View view) {
        j.g(noBagelComponentView, "this$0");
        j.g(noBagelClickOption, "$noBagelClickOption");
        noBagelComponentView.F.d(noBagelClickOption);
    }

    public q<NoBagelClickOption> C() {
        q<NoBagelClickOption> P = this.F.P();
        j.f(P, "clickSubject.hide()");
        return P;
    }

    public void E(List<? extends NetworkPhoto> list) {
        ImageView imageView;
        List<? extends NetworkPhoto> list2 = list;
        j.g(list2, "photos");
        LinearLayout linearLayout = this.L;
        if (linearLayout == null) {
            j.y("stars");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        ImageView imageView2 = this.J;
        if (imageView2 == null) {
            j.y(SoftwareInfoForm.ICON);
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        if (!list.isEmpty()) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.photo_size_large);
            b bVar = b.f13967a;
            Context context = getContext();
            j.f(context, IdentityHttpResponse.CONTEXT);
            String url = ((NetworkPhoto) list2.get(0)).getUrl();
            j.f(url, "photos[0].url");
            ImageView imageView3 = this.K;
            if (imageView3 == null) {
                j.y("avatar");
                imageView = null;
            } else {
                imageView = imageView3;
            }
            ImageLoaderContract.b bVar2 = new ImageLoaderContract.b(dimensionPixelSize, dimensionPixelSize);
            List e10 = p.e(b.a.f18329a);
            Map emptyMap = Collections.emptyMap();
            j.f(emptyMap, "emptyMap()");
            ImageLoaderContract.a.a(bVar, context, url, imageView, (Integer) null, (Integer) null, bVar2, e10, emptyMap, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 3864, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.textView_explanation0);
        j.f(findViewById, "findViewById(R.id.textView_explanation0)");
        this.G = (CmbTextView) findViewById;
        View findViewById2 = findViewById(R.id.textView_explanation1);
        j.f(findViewById2, "findViewById(R.id.textView_explanation1)");
        this.H = (CmbTextView) findViewById2;
        View findViewById3 = findViewById(R.id.button_bottom);
        j.f(findViewById3, "findViewById(R.id.button_bottom)");
        this.I = (CmbTextView) findViewById3;
        View findViewById4 = findViewById(R.id.image_top_icon);
        j.f(findViewById4, "findViewById(R.id.image_top_icon)");
        this.J = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.image_avatar);
        j.f(findViewById5, "findViewById(R.id.image_avatar)");
        this.K = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.no_bagel_stars);
        j.f(findViewById6, "findViewById(R.id.no_bagel_stars)");
        this.L = (LinearLayout) findViewById6;
    }

    public void setButtonClickListener(NoBagelClickOption noBagelClickOption) {
        j.g(noBagelClickOption, "noBagelClickOption");
        CmbTextView cmbTextView = this.I;
        if (cmbTextView == null) {
            j.y("button");
            cmbTextView = null;
        }
        cmbTextView.setOnClickListener(new l(this, noBagelClickOption));
    }

    public void setButtonText(String str) {
        j.g(str, "buttonText");
        CmbTextView cmbTextView = this.I;
        if (cmbTextView == null) {
            j.y("button");
            cmbTextView = null;
        }
        cmbTextView.setText(str);
    }

    public void setDescriptionText(String str) {
        j.g(str, "descriptionText");
        CmbTextView cmbTextView = this.H;
        if (cmbTextView == null) {
            j.y("description");
            cmbTextView = null;
        }
        cmbTextView.setText(str);
    }

    public void setTitleText(String str) {
        j.g(str, "titleText");
        CmbTextView cmbTextView = this.G;
        if (cmbTextView == null) {
            j.y("title");
            cmbTextView = null;
        }
        cmbTextView.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoBagelComponentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        PublishSubject<NoBagelClickOption> C0 = PublishSubject.C0();
        j.f(C0, "create<NoBagelClickOption>()");
        this.F = C0;
    }
}
