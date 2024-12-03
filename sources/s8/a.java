package s8;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import java.util.List;
import lc.n;

public class a extends Dialog {
    a(Context context, List<d> list) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setDimAmount(0.0f);
        getWindow().requestFeature(1);
        getWindow().setGravity(53);
        setContentView(R.layout.dialog_base_overflow);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.overflow_items_container);
        linearLayout.setBackground(context.getResources().getDrawable(R.drawable.rounded_solid_white_6dp));
        LayoutInflater from = LayoutInflater.from(context);
        for (d next : list) {
            View inflate = from.inflate(R.layout.overflow_item_dls, linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.label);
            TextView textView2 = (TextView) inflate.findViewById(R.id.notification);
            Drawable drawable = androidx.core.content.a.getDrawable(context, next.a());
            n.a(context, drawable, R.color.dark_gray);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setText(next.b());
            inflate.setOnClickListener(next.d());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.margin_med);
            if (next.c().intValue() > 0) {
                textView2.setVisibility(0);
                textView2.setText(String.valueOf(next.c()));
                textView.setPadding(dimensionPixelSize, 0, 0, 0);
            } else {
                textView2.setVisibility(8);
                textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            linearLayout.addView(inflate);
        }
    }
}
