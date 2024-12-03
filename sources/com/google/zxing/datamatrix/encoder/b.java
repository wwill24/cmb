package com.google.zxing.datamatrix.encoder;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import net.bytebuddy.jar.asm.Opcodes;

final class b implements e {
    b() {
    }

    private static char c(char c10, int i10) {
        int i11 = c10 + ((i10 * Opcodes.FCMPL) % 255) + 1;
        return i11 <= 255 ? (char) i11 : (char) (i11 - 256);
    }

    public void a(f fVar) {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(0);
        while (true) {
            if (!fVar.i()) {
                break;
            }
            sb2.append(fVar.c());
            fVar.f22076f++;
            if (g.n(fVar.d(), fVar.f22076f, b()) != b()) {
                fVar.o(0);
                break;
            }
        }
        int length = sb2.length() - 1;
        int a10 = fVar.a() + length + 1;
        fVar.q(a10);
        if (fVar.g().a() - a10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (fVar.i() || z10) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb2.setCharAt(0, (char) ((length / MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT) + 249));
                sb2.insert(1, (char) (length % MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb2.length();
        for (int i10 = 0; i10 < length2; i10++) {
            fVar.r(c(sb2.charAt(i10), fVar.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
