package r9;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature_flag_toggle.interactor.h;
import com.coffeemeetsbagel.features.models.FeatureFlag;
import net.bytebuddy.jar.asm.Opcodes;

public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f17412a = ((TextView) findViewById(R.id.feature_flag_name));

    /* renamed from: b  reason: collision with root package name */
    private TextView f17413b = ((TextView) findViewById(R.id.feature_flag_value));

    /* renamed from: c  reason: collision with root package name */
    private TextView f17414c = ((TextView) findViewById(R.id.true_override_button));

    /* renamed from: d  reason: collision with root package name */
    private TextView f17415d = ((TextView) findViewById(R.id.false_override_button));

    /* renamed from: e  reason: collision with root package name */
    private FeatureFlag f17416e;

    /* renamed from: f  reason: collision with root package name */
    private h f17417f;

    public e(Context context) {
        super(context);
        View.inflate(context, R.layout.feature_flag_list_item, this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(h hVar, View view) {
        hVar.e(true);
        h();
        this.f17416e.setOverrideValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(h hVar, View view) {
        hVar.e(false);
        g();
        this.f17416e.setOverrideValue(Boolean.FALSE);
    }

    private void g() {
        this.f17414c.setBackgroundColor(0);
        this.f17415d.setBackgroundColor(Opcodes.V_PREVIEW);
    }

    private void h() {
        this.f17414c.setBackgroundColor(Opcodes.V_PREVIEW);
        this.f17415d.setBackgroundColor(0);
    }

    public void c(h hVar) {
        this.f17417f = hVar;
        this.f17414c.setOnClickListener(new c(this, hVar));
        this.f17415d.setOnClickListener(new d(this, hVar));
    }

    public void d(FeatureFlag featureFlag) {
        this.f17416e = featureFlag;
        this.f17412a.setText(featureFlag.getKey());
        this.f17413b.setText(String.valueOf(featureFlag.getValue()));
        if (featureFlag.getOverrideValue() == null) {
            this.f17414c.setBackgroundColor(0);
            this.f17415d.setBackgroundColor(0);
        } else if (featureFlag.getOverrideValue().booleanValue()) {
            h();
        } else {
            g();
        }
    }
}
