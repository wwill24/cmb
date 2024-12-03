package com.coffeemeetsbagel.whatsnew;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.whatsnew.WhatsNewViewModel;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class b extends RecyclerView.Adapter<C0474b> {

    /* renamed from: d  reason: collision with root package name */
    private List<WhatsNewViewModel.a> f37624d;

    /* renamed from: e  reason: collision with root package name */
    private final a f37625e;

    public interface a {
        void d();

        void e();
    }

    /* renamed from: com.coffeemeetsbagel.whatsnew.b$b  reason: collision with other inner class name */
    public final class C0474b extends RecyclerView.d0 {
        private final LinearLayout A;
        final /* synthetic */ b B;

        /* renamed from: u  reason: collision with root package name */
        private final ImageView f37626u;

        /* renamed from: v  reason: collision with root package name */
        private final TextView f37627v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f37628w;

        /* renamed from: x  reason: collision with root package name */
        private final TextView f37629x;

        /* renamed from: y  reason: collision with root package name */
        private final TextView f37630y;

        /* renamed from: z  reason: collision with root package name */
        private final TextView f37631z;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0474b(b bVar, View view) {
            super(view);
            j.g(view, "itemView");
            this.B = bVar;
            View findViewById = view.findViewById(R.id.imageView);
            j.f(findViewById, "itemView.findViewById(R.id.imageView)");
            this.f37626u = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.title);
            j.f(findViewById2, "itemView.findViewById(R.id.title)");
            this.f37627v = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.subTitle);
            j.f(findViewById3, "itemView.findViewById(R.id.subTitle)");
            this.f37628w = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.descriptionText);
            j.f(findViewById4, "itemView.findViewById(R.id.descriptionText)");
            this.f37629x = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.primaryButton);
            j.f(findViewById5, "itemView.findViewById(R.id.primaryButton)");
            this.f37630y = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.secondaryButton);
            j.f(findViewById6, "itemView.findViewById(R.id.secondaryButton)");
            this.f37631z = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.pageCounter);
            j.f(findViewById7, "itemView.findViewById(R.id.pageCounter)");
            this.A = (LinearLayout) findViewById7;
        }

        private final void X(int i10) {
            boolean z10;
            int dimensionPixelSize = this.A.getContext().getResources().getDimensionPixelSize(R.dimen.margin_xxsmall);
            int dimensionPixelSize2 = this.A.getContext().getResources().getDimensionPixelSize(R.dimen.margin_xxxxxxsmall);
            int size = this.B.G().size();
            for (int i11 = 0; i11 < size; i11++) {
                ImageView imageView = new ImageView(this.A.getContext());
                imageView.setImageResource(R.drawable.selectable_circle_primary_color);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.setMargins(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                imageView.setLayoutParams(layoutParams);
                if (i10 == i11) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                imageView.setSelected(z10);
                this.A.addView(imageView);
            }
        }

        /* access modifiers changed from: private */
        public static final void Z(b bVar, View view) {
            j.g(bVar, "this$0");
            bVar.H().e();
        }

        /* access modifiers changed from: private */
        public static final void a0(b bVar, View view) {
            j.g(bVar, "this$0");
            bVar.H().d();
        }

        public final void Y(WhatsNewViewModel.a aVar) {
            boolean z10;
            j.g(aVar, "content");
            this.f37627v.setText(aVar.g());
            this.f37628w.setText(aVar.f());
            this.f37630y.setText(aVar.d());
            this.f37631z.setText(aVar.e());
            this.f37629x.setText(aVar.a());
            CharSequence text = this.f37631z.getText();
            j.f(text, "secondaryButton.text");
            boolean z11 = true;
            if (text.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f37631z.setVisibility(4);
            } else {
                this.f37631z.setVisibility(0);
            }
            X(aVar.c());
            if (aVar.b().length() != 0) {
                z11 = false;
            }
            if (z11) {
                this.f37626u.setImageResource(R.drawable.onboarding_illustration_pinky_promise);
            } else {
                b0(aVar.b(), this.f37626u);
            }
            this.f37630y.setOnClickListener(new c(this.B));
            this.f37631z.setOnClickListener(new d(this.B));
        }

        public final void b0(String str, ImageView imageView) {
            String str2 = str;
            j.g(str2, "url");
            ImageView imageView2 = imageView;
            j.g(imageView2, "imageView");
            com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context = imageView.getContext();
            j.f(context, "imageView.context");
            ImageLoaderContract.a.a(bVar, context, str2, imageView2, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, q.j(), h0.i(), (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 2048, (Object) null);
        }
    }

    public b(List<WhatsNewViewModel.a> list, a aVar) {
        j.g(list, "contentList");
        j.g(aVar, "listener");
        this.f37624d = list;
        this.f37625e = aVar;
    }

    public final List<WhatsNewViewModel.a> G() {
        return this.f37624d;
    }

    public final a H() {
        return this.f37625e;
    }

    /* renamed from: I */
    public void v(C0474b bVar, int i10) {
        j.g(bVar, "holder");
        bVar.Y(this.f37624d.get(i10));
    }

    /* renamed from: J */
    public C0474b x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.whats_new_content, viewGroup, false);
        j.f(inflate, "from(parent.context)\n   …w_content, parent, false)");
        return new C0474b(this, inflate);
    }

    public final void K(List<WhatsNewViewModel.a> list) {
        j.g(list, "pages");
        this.f37624d.clear();
        this.f37624d.addAll(list);
        l();
    }

    public int g() {
        return this.f37624d.size();
    }
}
