package org.apache.commons.digester.plugins;

public interface InitializableRule {
    void postRegisterInit(String str) throws PluginConfigurationException;
}
