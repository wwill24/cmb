package ac;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import lc.f;
import z9.l;

public class a extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final l f34004a;

    public a(l lVar) {
        this.f34004a = lVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        return f.a(strArr[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Bitmap bitmap) {
        this.f34004a.a(bitmap);
    }
}
