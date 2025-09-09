package com.example.barber.utils.managermode;


public final class ModeManager {
    private static Mode mode = Mode.REAL;

    private ModeManager() {}

    public static Mode get() { return mode; }
    public static void set(Mode m) { mode = m; }

    public static boolean isDemo() { return mode == Mode.DEMO; }
}

