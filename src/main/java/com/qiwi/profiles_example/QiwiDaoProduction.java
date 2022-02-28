package com.qiwi.profiles_example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */
@Repository
@Profile("PROD")
public class QiwiDaoProduction implements QiwiDao {
    @Override
    public void crud() {
        System.out.println("saved to prod");
    }

    @Override
    public String data() {
        return "proddata";
    }
}
