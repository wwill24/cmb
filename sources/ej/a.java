package ej;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.withpersona.sdk2.inquiry.ui.i;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f29582a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29583b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f29584c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f29585d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f29586e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f29587f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29588g;

    private a(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull View view2, @NonNull TextView textView) {
        this.f29582a = frameLayout;
        this.f29583b = imageView;
        this.f29584c = linearLayout;
        this.f29585d = view;
        this.f29586e = recyclerView;
        this.f29587f = view2;
        this.f29588g = textView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.withpersona.sdk2.inquiry.ui.h.list_content_separator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.withpersona.sdk2.inquiry.ui.h.shadow;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ej.a a(@androidx.annotation.NonNull android.view.View r10) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.ui.h.imageview_close_input_select_sheet
            android.view.View r1 = z1.b.a(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0046
            int r0 = com.withpersona.sdk2.inquiry.ui.h.list_content
            android.view.View r1 = z1.b.a(r10, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0046
            int r0 = com.withpersona.sdk2.inquiry.ui.h.list_content_separator
            android.view.View r6 = z1.b.a(r10, r0)
            if (r6 == 0) goto L_0x0046
            int r0 = com.withpersona.sdk2.inquiry.ui.h.recyclerview_inquiry_select_list
            android.view.View r1 = z1.b.a(r10, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0046
            int r0 = com.withpersona.sdk2.inquiry.ui.h.shadow
            android.view.View r8 = z1.b.a(r10, r0)
            if (r8 == 0) goto L_0x0046
            int r0 = com.withpersona.sdk2.inquiry.ui.h.textview_input_select_sheet_title
            android.view.View r1 = z1.b.a(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0046
            ej.a r0 = new ej.a
            r3 = r10
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0046:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ej.a.a(android.view.View):ej.a");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_input_select_bottom_sheet, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f29582a;
    }
}
