package w3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import i3.e;
import i3.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import l3.c;
import m3.b;
import net.bytebuddy.jar.asm.Opcodes;

public class j implements f<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f18238a;

    /* renamed from: b  reason: collision with root package name */
    private final f<ByteBuffer, c> f18239b;

    /* renamed from: c  reason: collision with root package name */
    private final b f18240c;

    public j(List<ImageHeaderParser> list, f<ByteBuffer, c> fVar, b bVar) {
        this.f18238a = list;
        this.f18239b = fVar;
        this.f18240c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Opcodes.ACC_ENUM);
        try {
            byte[] bArr = new byte[Opcodes.ACC_ENUM];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            Log.isLoggable("StreamGifDecoder", 5);
            return null;
        }
    }

    /* renamed from: c */
    public c<c> a(@NonNull InputStream inputStream, int i10, int i11, @NonNull e eVar) throws IOException {
        byte[] e10 = e(inputStream);
        if (e10 == null) {
            return null;
        }
        return this.f18239b.a(ByteBuffer.wrap(e10), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(@NonNull InputStream inputStream, @NonNull e eVar) throws IOException {
        if (((Boolean) eVar.a(i.f18237b)).booleanValue() || a.e(this.f18238a, inputStream, this.f18240c) != ImageHeaderParser.ImageType.GIF) {
            return false;
        }
        return true;
    }
}
