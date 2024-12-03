package nc;

import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f41300a = new a();

    private a() {
    }

    public final List<String> a(int i10, Resources resources) {
        j.g(resources, "resources");
        ArrayList arrayList = new ArrayList();
        InputStream openRawResource = resources.openRawResource(i10);
        j.f(openRawResource, "resources.openRawResource(resId)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine);
            } else {
                openRawResource.close();
                bufferedReader.close();
                return arrayList;
            }
        }
    }
}
