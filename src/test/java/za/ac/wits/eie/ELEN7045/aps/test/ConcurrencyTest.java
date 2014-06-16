/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package za.ac.wits.eie.ELEN7045.aps.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.concurrency.ConcurrentScrapingExecutor;
import za.ac.wits.eie.ELEN7045.aps.concurrency.ScrapingSession;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class ConcurrencyTest extends BaseTest {
    
    @Inject
    Logger log;
    
    @Inject
    ConcurrentScrapingExecutor scraper;
    
    @Test
    public void test() throws Exception {
        try {
            for (ScrapingSession scrapingSession : getScrapingSessions()) {
                Future<?> task = scraper.submit(scrapingSession);
                log.info("scraping session submitted...");
                try {
                   Object result = task.get();
                   Assert.assertNull(result);
                } catch (InterruptedException | ExecutionException ex) {
                    throw new IllegalStateException("Cannot get the answer", ex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private  List<ScrapingSession> getScrapingSessions() {
        List<ScrapingSession> sessions = new ArrayList<ScrapingSession>();
    
        return sessions;
    }
}
