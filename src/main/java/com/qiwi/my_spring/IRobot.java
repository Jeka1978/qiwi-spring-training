package com.qiwi.my_spring;

import java.lang.ref.WeakReference;
import java.rmi.dgc.DGC;
import java.util.WeakHashMap;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void init(){
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started уборку");
        cleaner.clean();
        speaker.speak("I finished уборку");

    }
}
