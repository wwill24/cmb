package org.jivesoftware.smackx.ox.selection_strategy;

import en.a;
import java.util.Date;
import java.util.Map;
import nn.b;
import nn.c;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;

public class AnnouncedKeys {

    public static class PubKeyRingSelectionStrategy extends b<Map<a, Date>> {
        public boolean accept(Map<a, Date> map, PGPPublicKeyRing pGPPublicKeyRing) {
            return map.keySet().contains(new a(pGPPublicKeyRing));
        }
    }

    public static class SecKeyRingSelectionStrategy extends c<Map<a, Date>> {
        public boolean accept(Map<a, Date> map, PGPSecretKeyRing pGPSecretKeyRing) {
            return map.keySet().contains(new a(pGPSecretKeyRing));
        }
    }
}
