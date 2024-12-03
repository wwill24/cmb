package com.coffeemeetsbagel.activities.main;

import android.content.res.Resources;
import android.os.AsyncTask;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import n8.s;

public class b extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f10929a;

    /* renamed from: b  reason: collision with root package name */
    private final x5.a f10930b;

    /* renamed from: c  reason: collision with root package name */
    s f10931c;

    /* renamed from: d  reason: collision with root package name */
    s9.a f10932d;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.coffeemeetsbagel.activities.main.b$b  reason: collision with other inner class name */
    public interface C0124b {
        s9.a b();

        s n();
    }

    b(Resources resources, x5.a aVar) {
        this.f10929a = resources;
        this.f10930b = aVar;
        d.a().b(Bakery.j()).a().a(this);
    }

    private void c(String str) {
        x5.b b10 = this.f10930b.b(R.id.bottom_nav_item_chat);
        if (b10 != null) {
            b10.d(str);
            this.f10930b.d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Integer doInBackground(Void... voidArr) {
        int intValue = this.f10931c.z().intValue();
        int A = this.f10931c.A();
        if (intValue > 0) {
            A = -1;
        }
        return Integer.valueOf(A);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Integer num) {
        String str;
        if (num.intValue() > 0) {
            if (num.intValue() > 99) {
                str = this.f10929a.getQuantityString(R.plurals.many_chats, 99, new Object[]{99});
            } else {
                str = String.valueOf(num);
            }
            c(str);
        } else if (num.intValue() == -1) {
            c("!");
        } else {
            c((String) null);
        }
    }
}
