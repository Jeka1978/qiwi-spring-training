package com.qiwi.profiles_example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
@ActiveProfiles("STAGING")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoTestConf.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@MockBean(QiwiDao.class)
public class QiwiServiceTest {

    @MockBean
    QiwiDao qiwiDao;

    @Autowired
    private QiwiService qiwiService;

    @Autowired
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        Mockito.when(qiwiDao.data()).thenReturn("blablablabl");
    }

    @Test
    public void work() {
        qiwiService.work();

    }
}