package xi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import java.util.List;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class a extends ArrayAdapter<String> {

    /* renamed from: a  reason: collision with root package name */
    private final TextBasedComponentStyle f33963a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, int i10, List<String> list, TextBasedComponentStyle textBasedComponentStyle) {
        super(context, i10, list);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "objects");
        this.f33963a = textBasedComponentStyle;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView;
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        View view2 = super.getView(i10, view, viewGroup);
        j.f(view2, "super.getView(position, convertView, parent)");
        TextBasedComponentStyle textBasedComponentStyle = this.f33963a;
        if (textBasedComponentStyle != null) {
            if (view2 instanceof TextView) {
                textView = (TextView) view2;
            } else {
                textView = null;
            }
            if (textView != null) {
                m.e(textView, textBasedComponentStyle);
            }
        }
        return view2;
    }
}
