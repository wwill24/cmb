package n7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f16636a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f16637b = ((LinearLayout) this.f16645j.findViewById(R.id.linearLayout_message));

    /* renamed from: c  reason: collision with root package name */
    public ImageView f16638c = ((ImageView) this.f16645j.findViewById(R.id.imageView_avatar_other));

    /* renamed from: d  reason: collision with root package name */
    public View f16639d = this.f16645j.findViewById(R.id.live_typing_circle_1);

    /* renamed from: e  reason: collision with root package name */
    public View f16640e = this.f16645j.findViewById(R.id.live_typing_circle_2);

    /* renamed from: f  reason: collision with root package name */
    public View f16641f = this.f16645j.findViewById(R.id.live_typing_circle_3);

    /* renamed from: g  reason: collision with root package name */
    public CmbTextView f16642g = ((CmbTextView) this.f16645j.findViewById(R.id.textView_message));

    /* renamed from: h  reason: collision with root package name */
    public CmbTextView f16643h = ((CmbTextView) this.f16645j.findViewById(R.id.textView_date));

    /* renamed from: i  reason: collision with root package name */
    public CmbTextView f16644i = ((CmbTextView) this.f16645j.findViewById(R.id.textView_date_message));

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f16645j;

    public a(LayoutInflater layoutInflater, ListView listView) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.row_view_message_from_other, listView, false);
        this.f16645j = viewGroup;
        this.f16636a = (RelativeLayout) viewGroup.findViewById(R.id.relativeLayout_message_container);
    }
}
