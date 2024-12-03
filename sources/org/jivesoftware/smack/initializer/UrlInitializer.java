package org.jivesoftware.smack.initializer;

import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackInitialization;
import org.jivesoftware.smack.provider.ProviderFileLoader;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;

public abstract class UrlInitializer implements SmackInitializer {
    private static final Logger LOGGER = Logger.getLogger(UrlInitializer.class.getName());

    private static void maybeClose(InputStream inputStream) {
        CloseableUtil.maybeClose(inputStream, LOGGER);
    }

    /* access modifiers changed from: protected */
    public String getConfigUri() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getProvidersUri() {
        return null;
    }

    public List<Exception> initialize() {
        ClassLoader classLoader = getClass().getClassLoader();
        LinkedList linkedList = new LinkedList();
        String providersUri = getProvidersUri();
        InputStream inputStream = null;
        if (providersUri != null) {
            try {
                URI create = URI.create(providersUri);
                inputStream = FileUtils.getStreamForUri(create, classLoader);
                Logger logger = LOGGER;
                Level level = Level.FINE;
                logger.log(level, "Loading providers for providerUri [" + create + "]");
                ProviderFileLoader providerFileLoader = new ProviderFileLoader(inputStream, classLoader);
                ProviderManager.addLoader(providerFileLoader);
                linkedList.addAll(providerFileLoader.getLoadingExceptions());
            } catch (Exception e10) {
                Logger logger2 = LOGGER;
                Level level2 = Level.SEVERE;
                logger2.log(level2, "Error trying to load provider file " + providersUri, e10);
                linkedList.add(e10);
            } catch (Throwable th2) {
                maybeClose(inputStream);
                throw th2;
            }
            maybeClose(inputStream);
        }
        String configUri = getConfigUri();
        if (configUri != null) {
            try {
                inputStream = FileUtils.getStreamForUri(URI.create(configUri), classLoader);
                SmackInitialization.processConfigFile(inputStream, linkedList, classLoader);
            } catch (Exception e11) {
                linkedList.add(e11);
            } catch (Throwable th3) {
                maybeClose(inputStream);
                throw th3;
            }
            maybeClose(inputStream);
        }
        return linkedList;
    }
}
