package com.qiwi.my_spring;

/**
 * @author Evgeny Borisov
 */
public class LoggableCleaner implements Cleaner {

    @InjectByType
    private CleanerImpl cleaner;

    @Override
    public void clean() {
        System.out.println("clean working");
        cleaner.clean();
        System.out.println("clean finished");
    }
}
