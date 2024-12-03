package org.jivesoftware.smack.provider;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ProviderFileLoader implements ProviderLoader {
    private static final Logger LOGGER = Logger.getLogger(ProviderFileLoader.class.getName());
    private List<Exception> exceptions;
    private final Collection<ExtensionProviderInfo> extProviders;
    private final Collection<IQProviderInfo> iqProviders;
    private final Collection<StreamFeatureProviderInfo> sfProviders;

    public ProviderFileLoader(InputStream inputStream) {
        this(inputStream, ProviderFileLoader.class.getClassLoader());
    }

    public Collection<ExtensionProviderInfo> getExtensionProviderInfo() {
        return this.extProviders;
    }

    public Collection<IQProviderInfo> getIQProviderInfo() {
        return this.iqProviders;
    }

    public List<Exception> getLoadingExceptions() {
        return Collections.unmodifiableList(this.exceptions);
    }

    public Collection<StreamFeatureProviderInfo> getStreamFeatureProviderInfo() {
        return this.sfProviders;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01a9, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r14.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01ae, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01af, code lost:
        LOGGER.log(java.util.logging.Level.SEVERE, "Unknown error occurred while parsing provider file", r13);
        r12.exceptions.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:52:0x019e, B:56:0x01a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProviderFileLoader(java.io.InputStream r13, java.lang.ClassLoader r14) {
        /*
            r12 = this;
            r12.<init>()
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r12.iqProviders = r0
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r12.extProviders = r0
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r12.sfProviders = r0
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r12.exceptions = r0
            org.jivesoftware.smack.xml.XmlPullParser r0 = org.jivesoftware.smack.util.PacketParserUtils.getParserFor((java.io.InputStream) r13)     // Catch:{ all -> 0x01a2 }
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r0.getEventType()     // Catch:{ all -> 0x01a2 }
        L_0x0027:
            org.jivesoftware.smack.xml.XmlPullParser$Event r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ all -> 0x01a2 }
            if (r1 != r2) goto L_0x0194
            java.lang.String r1 = r0.getName()     // Catch:{ all -> 0x01a2 }
            java.lang.String r2 = "smackProviders"
            boolean r2 = r2.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0171 }
            if (r2 != 0) goto L_0x0194
            r0.next()     // Catch:{ IllegalArgumentException -> 0x0171 }
            r0.next()     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.String r2 = r0.nextText()     // Catch:{ IllegalArgumentException -> 0x0171 }
            r0.next()     // Catch:{ IllegalArgumentException -> 0x0171 }
            r0.next()     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.String r3 = r0.nextText()     // Catch:{ IllegalArgumentException -> 0x0171 }
            r0.next()     // Catch:{ IllegalArgumentException -> 0x0171 }
            r0.next()     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.String r4 = r0.nextText()     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.Class r5 = r14.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r6 = -1
            int r7 = r1.hashCode()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r8 = -797518000(0xffffffffd076d750, float:-1.65652234E10)
            r9 = 2
            r10 = 1
            r11 = 0
            if (r7 == r8) goto L_0x0085
            r8 = 80611175(0x4ce0767, float:4.8437165E-36)
            if (r7 == r8) goto L_0x007b
            r8 = 1834143545(0x6d52cf39, float:4.077648E27)
            if (r7 == r8) goto L_0x0071
            goto L_0x008e
        L_0x0071:
            java.lang.String r7 = "iqProvider"
            boolean r7 = r1.equals(r7)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            if (r7 == 0) goto L_0x008e
            r6 = r11
            goto L_0x008e
        L_0x007b:
            java.lang.String r7 = "streamFeatureProvider"
            boolean r7 = r1.equals(r7)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            if (r7 == 0) goto L_0x008e
            r6 = r9
            goto L_0x008e
        L_0x0085:
            java.lang.String r7 = "extensionProvider"
            boolean r7 = r1.equals(r7)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            if (r7 == 0) goto L_0x008e
            r6 = r10
        L_0x008e:
            if (r6 == 0) goto L_0x0105
            if (r6 == r10) goto L_0x00c6
            if (r6 == r9) goto L_0x00ac
            java.util.logging.Logger r2 = LOGGER     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.String r5 = "Unknown provider type: "
            r3.append(r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r3.append(r1)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.String r3 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r2.warning(r3)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            goto L_0x0194
        L_0x00ac:
            java.lang.Class[] r6 = new java.lang.Class[r11]     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.Object[] r6 = new java.lang.Object[r11]     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            org.jivesoftware.smack.provider.ExtensionElementProvider r5 = (org.jivesoftware.smack.provider.ExtensionElementProvider) r5     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.util.Collection<org.jivesoftware.smack.provider.StreamFeatureProviderInfo> r6 = r12.sfProviders     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            org.jivesoftware.smack.provider.StreamFeatureProviderInfo r7 = new org.jivesoftware.smack.provider.StreamFeatureProviderInfo     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r7.<init>(r2, r3, r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r6.add(r7)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            goto L_0x0194
        L_0x00c6:
            java.lang.Class<org.jivesoftware.smack.provider.ExtensionElementProvider> r6 = org.jivesoftware.smack.provider.ExtensionElementProvider.class
            boolean r6 = r6.isAssignableFrom(r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            if (r6 == 0) goto L_0x00e8
            java.lang.Class[] r6 = new java.lang.Class[r11]     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.Object[] r6 = new java.lang.Object[r11]     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            org.jivesoftware.smack.provider.ExtensionElementProvider r5 = (org.jivesoftware.smack.provider.ExtensionElementProvider) r5     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.util.Collection<org.jivesoftware.smack.provider.ExtensionProviderInfo> r6 = r12.extProviders     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            org.jivesoftware.smack.provider.ExtensionProviderInfo r7 = new org.jivesoftware.smack.provider.ExtensionProviderInfo     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r7.<init>(r2, r3, r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r6.add(r7)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            goto L_0x0194
        L_0x00e8:
            java.util.List<java.lang.Exception> r2 = r12.exceptions     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r5.append(r4)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.String r6 = " is not a PacketExtensionProvider"
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.String r5 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r3.<init>(r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r2.add(r3)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            goto L_0x0194
        L_0x0105:
            java.lang.Class<org.jivesoftware.smack.provider.IqProvider> r6 = org.jivesoftware.smack.provider.C0522IqProvider.class
            boolean r6 = r6.isAssignableFrom(r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            if (r6 == 0) goto L_0x0126
            java.lang.Class[] r6 = new java.lang.Class[r11]     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.Object[] r6 = new java.lang.Object[r11]     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            org.jivesoftware.smack.provider.IqProvider r5 = (org.jivesoftware.smack.provider.C0522IqProvider) r5     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.util.Collection<org.jivesoftware.smack.provider.IQProviderInfo> r6 = r12.iqProviders     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            org.jivesoftware.smack.provider.IQProviderInfo r7 = new org.jivesoftware.smack.provider.IQProviderInfo     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r7.<init>(r2, r3, r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r6.add(r7)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            goto L_0x0194
        L_0x0126:
            java.util.List<java.lang.Exception> r2 = r12.exceptions     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r5.append(r4)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.String r6 = " is not a IQProvider"
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            java.lang.String r5 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r3.<init>(r5)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            r2.add(r3)     // Catch:{ ClassNotFoundException -> 0x0161, InstantiationException -> 0x0142 }
            goto L_0x0194
        L_0x0142:
            r2 = move-exception
            java.util.logging.Logger r3 = LOGGER     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0171 }
            r6.<init>()     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.String r7 = "Could not instanciate "
            r6.append(r7)     // Catch:{ IllegalArgumentException -> 0x0171 }
            r6.append(r4)     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.String r4 = r6.toString()     // Catch:{ IllegalArgumentException -> 0x0171 }
            r3.log(r5, r4, r2)     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.util.List<java.lang.Exception> r3 = r12.exceptions     // Catch:{ IllegalArgumentException -> 0x0171 }
            r3.add(r2)     // Catch:{ IllegalArgumentException -> 0x0171 }
            goto L_0x0194
        L_0x0161:
            r2 = move-exception
            java.util.logging.Logger r3 = LOGGER     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.lang.String r5 = "Could not find provider class"
            r3.log(r4, r5, r2)     // Catch:{ IllegalArgumentException -> 0x0171 }
            java.util.List<java.lang.Exception> r3 = r12.exceptions     // Catch:{ IllegalArgumentException -> 0x0171 }
            r3.add(r2)     // Catch:{ IllegalArgumentException -> 0x0171 }
            goto L_0x0194
        L_0x0171:
            r2 = move-exception
            java.util.logging.Logger r3 = LOGGER     // Catch:{ all -> 0x01a2 }
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x01a2 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a2 }
            r5.<init>()     // Catch:{ all -> 0x01a2 }
            java.lang.String r6 = "Invalid provider type found ["
            r5.append(r6)     // Catch:{ all -> 0x01a2 }
            r5.append(r1)     // Catch:{ all -> 0x01a2 }
            java.lang.String r1 = "] when expecting iqProvider or extensionProvider"
            r5.append(r1)     // Catch:{ all -> 0x01a2 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01a2 }
            r3.log(r4, r1, r2)     // Catch:{ all -> 0x01a2 }
            java.util.List<java.lang.Exception> r1 = r12.exceptions     // Catch:{ all -> 0x01a2 }
            r1.add(r2)     // Catch:{ all -> 0x01a2 }
        L_0x0194:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r0.next()     // Catch:{ all -> 0x01a2 }
            org.jivesoftware.smack.xml.XmlPullParser$Event r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_DOCUMENT     // Catch:{ all -> 0x01a2 }
            if (r1 != r2) goto L_0x0027
            if (r13 == 0) goto L_0x01bd
            r13.close()     // Catch:{ Exception -> 0x01ae }
            goto L_0x01bd
        L_0x01a2:
            r14 = move-exception
            if (r13 == 0) goto L_0x01ad
            r13.close()     // Catch:{ all -> 0x01a9 }
            goto L_0x01ad
        L_0x01a9:
            r13 = move-exception
            r14.addSuppressed(r13)     // Catch:{ Exception -> 0x01ae }
        L_0x01ad:
            throw r14     // Catch:{ Exception -> 0x01ae }
        L_0x01ae:
            r13 = move-exception
            java.util.logging.Logger r14 = LOGGER
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE
            java.lang.String r1 = "Unknown error occurred while parsing provider file"
            r14.log(r0, r1, r13)
            java.util.List<java.lang.Exception> r14 = r12.exceptions
            r14.add(r13)
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.provider.ProviderFileLoader.<init>(java.io.InputStream, java.lang.ClassLoader):void");
    }
}
