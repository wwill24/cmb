package s8;

import android.content.Context;
import android.view.View;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17523a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final List<d> b(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            String string = context.getString(R.string.report_post_connection_cta_title);
            j.f(string, "context.getString(R.stri…ost_connection_cta_title)");
            String string2 = context.getString(R.string.hide_post_connection_cta_title);
            j.f(string2, "context.getString(R.stri…ost_connection_cta_title)");
            return q.m(new d(R.drawable.ic_overflow_report, string, onClickListener2, (Integer) null, 8, (DefaultConstructorMarker) null), new d(R.drawable.ic_overflow_unmatch, string2, onClickListener, (Integer) null, 8, (DefaultConstructorMarker) null));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context, f17523a.b(context, onClickListener, onClickListener2));
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(onClickListener, "unmatchOnClickListener");
        j.g(onClickListener2, "reportOnClickListener");
    }
}
