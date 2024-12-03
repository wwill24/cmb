package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface$CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public class j extends k {
    private Font h(@NonNull FontFamily fontFamily, int i10) {
        int i11;
        int i12;
        if ((i10 & 1) != 0) {
            i11 = Constants.FROZEN_FRAME_TIME;
        } else {
            i11 = 400;
        }
        if ((i10 & 2) != 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        FontStyle fontStyle = new FontStyle(i11, i12);
        Font font = fontFamily.getFont(0);
        int i13 = i(fontStyle, font.getStyle());
        for (int i14 = 1; i14 < fontFamily.getSize(); i14++) {
            Font font2 = fontFamily.getFont(i14);
            int i15 = i(fontStyle, font2.getStyle());
            if (i15 < i13) {
                font = font2;
                i13 = i15;
            }
        }
        return font;
    }

    private static int i(@NonNull FontStyle fontStyle, @NonNull FontStyle fontStyle2) {
        int i10;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        return abs + i10;
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        int i11;
        try {
            FontFamily.Builder builder = null;
            for (e.d dVar : cVar.a()) {
                try {
                    Font.Builder weight = new Font.Builder(resources, dVar.b()).setWeight(dVar.e());
                    if (dVar.f()) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    Font build = weight.setSlant(i11).setTtcIndex(dVar.c()).setFontVariationSettings(dVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface$CustomFallbackBuilder(build2).setStyle(h(build2, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, @NonNull g.b[] bVarArr, int i10) {
        ParcelFileDescriptor openFileDescriptor;
        int i11;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (g.b bVar : bVarArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), StreamManagement.AckRequest.ELEMENT, cancellationSignal);
                    if (openFileDescriptor != null) {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(bVar.e());
                        if (bVar.f()) {
                            i11 = 1;
                        } else {
                            i11 = 0;
                        }
                        Font build = weight.setSlant(i11).setTtcIndex(bVar.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } else if (openFileDescriptor == null) {
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface$CustomFallbackBuilder(build2).setStyle(h(build2, i10).getStyle()).build();
            throw th;
        } catch (Exception unused2) {
            return null;
        }
    }

    public Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        try {
            Font build = new Font.Builder(resources, i10).build();
            return new Typeface$CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public g.b g(g.b[] bVarArr, int i10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
