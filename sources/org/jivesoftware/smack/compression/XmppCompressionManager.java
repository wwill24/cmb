package org.jivesoftware.smack.compression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.compress.packet.Compress;

public class XmppCompressionManager {
    private static final List<XmppCompressionFactory> xmppCompressionFactories = new ArrayList(4);

    public static XmppCompressionFactory getBestFactory(Compress.Feature feature) {
        List<String> methods = feature.getMethods();
        List<XmppCompressionFactory> list = xmppCompressionFactories;
        synchronized (list) {
            for (XmppCompressionFactory next : list) {
                if (methods.contains(next.getCompressionMethod())) {
                    return next;
                }
            }
            return null;
        }
    }

    public static XmppCompressionFactory registerXmppCompressionFactory(XmppCompressionFactory xmppCompressionFactory) {
        XmppCompressionFactory xmppCompressionFactory2;
        String compressionMethod = xmppCompressionFactory.getCompressionMethod();
        List<XmppCompressionFactory> list = xmppCompressionFactories;
        synchronized (list) {
            Iterator<XmppCompressionFactory> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    xmppCompressionFactory2 = null;
                    break;
                }
                xmppCompressionFactory2 = it.next();
                if (xmppCompressionFactory2.getCompressionMethod().equals(compressionMethod)) {
                    it.remove();
                    break;
                }
            }
            List<XmppCompressionFactory> list2 = xmppCompressionFactories;
            list2.add(xmppCompressionFactory);
            Collections.sort(list2);
        }
        return xmppCompressionFactory2;
    }
}
