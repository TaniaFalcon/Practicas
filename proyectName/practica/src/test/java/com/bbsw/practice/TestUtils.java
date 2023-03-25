package com.bbsw.practice;

import okhttp3.mockwebserver.MockWebServer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;

@Component
public class TestUtils {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final String TEST_STARTED_INFO = "TEST %s STARTED";
    private static final String TEST_FINISHED_INFO = "TEST %s FINISHED";


    @Autowired
    @Qualifier("transactionTemplate")
    TransactionTemplate transactionTemplate;

    private MockWebServer mockWebServer;

    public void initializeMockWebServer() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(9999);
    }

    public void shutDownMockWebServer() throws IOException {
        mockWebServer.shutdown();
    }

    public MockWebServer getMockWebServer() {
        return mockWebServer;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void printInfo(String testName, boolean started) {
        log.info(StringUtils.repeat("*", 60));
        log.info(String.format(started ? TEST_STARTED_INFO : TEST_FINISHED_INFO, testName));
        log.info(StringUtils.repeat("*", 60));
    }


}
