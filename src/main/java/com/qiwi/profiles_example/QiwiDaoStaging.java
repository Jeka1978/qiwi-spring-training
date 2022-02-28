package com.qiwi.profiles_example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */
@Repository
@Profile("STAGING")
public class QiwiDaoStaging implements QiwiDao {
    @Override
    public void crud() {
        System.out.println("saved to staging");
    }



    @Override
    public String data() {
        return "stagingdata";
    }
}
