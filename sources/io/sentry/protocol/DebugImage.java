package io.sentry.protocol;

import com.leanplum.internal.Constants;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class DebugImage implements c1 {
    public static final String PROGUARD = "proguard";
    /* access modifiers changed from: private */
    public String arch;
    /* access modifiers changed from: private */
    public String codeFile;
    /* access modifiers changed from: private */
    public String codeId;
    /* access modifiers changed from: private */
    public String debugFile;
    /* access modifiers changed from: private */
    public String debugId;
    /* access modifiers changed from: private */
    public String imageAddr;
    /* access modifiers changed from: private */
    public Long imageSize;
    /* access modifiers changed from: private */
    public String type;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String uuid;

    public static final class a implements s0<DebugImage> {
        /* renamed from: b */
        public DebugImage a(y0 y0Var, h0 h0Var) throws Exception {
            DebugImage debugImage = new DebugImage();
            y0Var.b();
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1840639000:
                        if (y10.equals("debug_file")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1443345323:
                        if (y10.equals("image_addr")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1442803611:
                        if (y10.equals("image_size")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1127437170:
                        if (y10.equals("code_file")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3002454:
                        if (y10.equals("arch")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 3601339:
                        if (y10.equals(Constants.Params.UUID)) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 547804807:
                        if (y10.equals("debug_id")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 941842605:
                        if (y10.equals("code_id")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = debugImage.debugFile = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = debugImage.imageAddr = y0Var.H0();
                        break;
                    case 2:
                        Long unused3 = debugImage.imageSize = y0Var.x0();
                        break;
                    case 3:
                        String unused4 = debugImage.codeFile = y0Var.H0();
                        break;
                    case 4:
                        String unused5 = debugImage.arch = y0Var.H0();
                        break;
                    case 5:
                        String unused6 = debugImage.type = y0Var.H0();
                        break;
                    case 6:
                        String unused7 = debugImage.uuid = y0Var.H0();
                        break;
                    case 7:
                        String unused8 = debugImage.debugId = y0Var.H0();
                        break;
                    case 8:
                        String unused9 = debugImage.codeId = y0Var.H0();
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            y0Var.h();
            debugImage.setUnknown(hashMap);
            return debugImage;
        }
    }

    public String getArch() {
        return this.arch;
    }

    public String getCodeFile() {
        return this.codeFile;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public String getDebugFile() {
        return this.debugFile;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public Long getImageSize() {
        return this.imageSize;
    }

    public String getType() {
        return this.type;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.uuid != null) {
            a1Var.N(Constants.Params.UUID).I(this.uuid);
        }
        if (this.type != null) {
            a1Var.N("type").I(this.type);
        }
        if (this.debugId != null) {
            a1Var.N("debug_id").I(this.debugId);
        }
        if (this.debugFile != null) {
            a1Var.N("debug_file").I(this.debugFile);
        }
        if (this.codeId != null) {
            a1Var.N("code_id").I(this.codeId);
        }
        if (this.codeFile != null) {
            a1Var.N("code_file").I(this.codeFile);
        }
        if (this.imageAddr != null) {
            a1Var.N("image_addr").I(this.imageAddr);
        }
        if (this.imageSize != null) {
            a1Var.N("image_size").G(this.imageSize);
        }
        if (this.arch != null) {
            a1Var.N("arch").I(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.unknown.get(next));
            }
        }
        a1Var.h();
    }

    public void setArch(String str) {
        this.arch = str;
    }

    public void setCodeFile(String str) {
        this.codeFile = str;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public void setDebugFile(String str) {
        this.debugFile = str;
    }

    public void setDebugId(String str) {
        this.debugId = str;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public void setImageSize(Long l10) {
        this.imageSize = l10;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setImageSize(long j10) {
        this.imageSize = Long.valueOf(j10);
    }
}
