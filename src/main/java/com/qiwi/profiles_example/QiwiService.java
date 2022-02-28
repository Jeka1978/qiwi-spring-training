package com.qiwi.profiles_example;

import com.qiwi.my_spring.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class QiwiService {

    private QiwiDao qiwiDao;

    public QiwiService(QiwiDao qiwiDao) {
        this.qiwiDao = qiwiDao;
    }

    public void work(){
        qiwiDao.crud();
    }
}
