package cat.devsofthecoast.artporfolio.common.screens.controllers;

public interface BackPressDispatcher {
    void registerListener(BackPressedListener listener);
    void unregisterListener(BackPressedListener listener);
}
