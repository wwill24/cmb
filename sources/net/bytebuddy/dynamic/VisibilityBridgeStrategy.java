package net.bytebuddy.dynamic;

import net.bytebuddy.description.method.MethodDescription;

public interface VisibilityBridgeStrategy {

    public enum Default implements VisibilityBridgeStrategy {
        ALWAYS {
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return true;
            }
        },
        ON_NON_GENERIC_METHOD {
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return !methodDescription.isGenerified();
            }
        },
        NEVER {
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return false;
            }
        }
    }

    boolean generateVisibilityBridge(MethodDescription methodDescription);
}
