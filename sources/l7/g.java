package l7;

import android.content.Intent;
import com.coffeemeetsbagel.models.constants.Extra;

public class g implements e {

    /* renamed from: a  reason: collision with root package name */
    private f f16047a;

    /* renamed from: b  reason: collision with root package name */
    private String f16048b;

    /* renamed from: c  reason: collision with root package name */
    private String f16049c;

    public g(f fVar, Intent intent) {
        this.f16047a = fVar;
        if (intent != null) {
            this.f16048b = intent.getStringExtra(Extra.IMAGE_URI);
            this.f16049c = intent.getStringExtra("image_url");
            if (this.f16048b != null) {
                fVar.d();
            }
        }
    }

    public void q() {
        String str = this.f16048b;
        if (str != null) {
            this.f16047a.c(str);
        }
    }

    public void r() {
        this.f16047a.a();
    }

    public void start() {
        String str = this.f16048b;
        if (str != null) {
            this.f16047a.e(str);
            return;
        }
        String str2 = this.f16049c;
        if (str2 != null) {
            this.f16047a.b(str2);
        }
    }
}
