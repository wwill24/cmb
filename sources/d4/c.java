package d4;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.leanplum.messagetemplates.MessageTemplateConstants;

public class c implements g<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f14436a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14437b;

    /* renamed from: c  reason: collision with root package name */
    private d f14438c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f14439a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14440b;

        public a() {
            this(MessageTemplateConstants.Values.CENTER_POPUP_WIDTH);
        }

        public c a() {
            return new c(this.f14439a, this.f14440b);
        }

        public a(int i10) {
            this.f14439a = i10;
        }
    }

    protected c(int i10, boolean z10) {
        this.f14436a = i10;
        this.f14437b = z10;
    }

    private f<Drawable> b() {
        if (this.f14438c == null) {
            this.f14438c = new d(this.f14436a, this.f14437b);
        }
        return this.f14438c;
    }

    public f<Drawable> a(DataSource dataSource, boolean z10) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return e.b();
        }
        return b();
    }
}
