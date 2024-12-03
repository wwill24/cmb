package com.google.android.gms.internal.mlkit_vision_barcode;

import net.bytebuddy.jar.asm.Opcodes;

public enum zznp implements zzdi {
    FORMAT_UNKNOWN(0),
    FORMAT_CODE_128(1),
    FORMAT_CODE_39(2),
    FORMAT_CODE_93(4),
    FORMAT_CODABAR(8),
    FORMAT_DATA_MATRIX(16),
    FORMAT_EAN_13(32),
    FORMAT_EAN_8(64),
    FORMAT_ITF(128),
    FORMAT_QR_CODE(256),
    FORMAT_UPC_A(512),
    FORMAT_UPC_E(1024),
    FORMAT_PDF417(2048),
    FORMAT_AZTEC(Opcodes.ACC_SYNTHETIC);
    
    private final int zzp;

    private zznp(int i10) {
        this.zzp = i10;
    }

    public final int zza() {
        return this.zzp;
    }
}
