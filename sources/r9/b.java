package r9;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature_flag_toggle.interactor.h;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f17407a;

    public b(Context context) {
        super(context);
        View.inflate(context, R.layout.footer, this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TextView textView = (TextView) findViewById(R.id.footer_button);
        this.f17407a = textView;
        textView.setText(context.getString(R.string.clear_feature_flag_override));
    }

    public void b(h hVar) {
        this.f17407a.setOnClickListener(new a(hVar));
    }
}
