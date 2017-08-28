/*
 * (C) Copyright 2017-2019 ElasTest (http://elastest.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.elastest.eus.test.e2e;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.elastest.eus.app.EusSpringBootApp;

/**
 * Timeout test.
 *
 * @author Boni Garcia (boni.garcia@urjc.es)
 * @since 0.0.1
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EusSpringBootApp.class, webEnvironment = RANDOM_PORT)
@TestPropertySource(properties = { "hub.timeout=10" })
public class TimeoutTest {

    final Logger log = LoggerFactory.getLogger(TimeoutTest.class);

    WebDriver driver;

    @LocalServerPort
    int serverPort;

    @Value("${server.contextPath}")
    String contextPath;

    @BeforeEach
    void setup() throws MalformedURLException {
        String eusUrl = "http://localhost:" + serverPort + contextPath;
        Capabilities capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL(eusUrl), capabilities);
        log.debug("EUS URL: {}", eusUrl);
    }

    @Test
    void test() throws InterruptedException {
        // Do nothing a period of time > hub.timeout
        Thread.sleep(12000);

        Throwable exception = assertThrows(WebDriverException.class,
                () -> driver.get("http://elastest.io/"));

        log.debug("Exception {} -- due to timeout", exception.getMessage());
        driver = null;
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}