package w3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import f4.a;
import i3.e;
import i3.g;
import java.io.File;
import java.io.IOException;
import l3.c;

public class d implements g<c> {
    @NonNull
    public EncodeStrategy b(@NonNull e eVar) {
        return EncodeStrategy.SOURCE;
    }

    /* renamed from: c */
    public boolean a(@NonNull c<c> cVar, @NonNull File file, @NonNull e eVar) {
        try {
            a.e(cVar.get().c(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
