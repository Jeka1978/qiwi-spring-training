package com.qiwi.my_spring;

import java.lang.ref.WeakReference;
import java.rmi.dgc.DGC;
import java.util.WeakHashMap;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);

    public void cleanRoom() {
        speaker.speak("I started уборку");
        cleaner.clean();
        speaker.speak("I finished уборку");

    }
}
