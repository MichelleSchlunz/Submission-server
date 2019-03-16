package com.submission.server.resource;

import com.submission.server.exception.InternalServerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootTest
public class SubmissionsTest {

    private Submissions submissions;
    private InternalServerException exceptionThrown;

    @Before
    public void beforeTest(){
        submissions = new Submissions();
        exceptionThrown = null;
    }

    @Test
    public void test_ValidateLimit_LimitReached(){
        submissions.setTotal(new AtomicLong(Long.MAX_VALUE));

        try{
            submissions.validateLimit();
        }catch (InternalServerException ise){
            exceptionThrown = ise;
        }

        Assert.assertEquals("Server maximum count has been reached.", exceptionThrown.getMessage());
    }

    @Test
    public void test_IncrementAndGet_Success(){

        Assert.assertEquals(0, submissions.getTotal().longValue());
        Assert.assertEquals(1, submissions.incrementAndGet());
        Assert.assertEquals(1, submissions.getTotal().longValue());
        Assert.assertEquals(2, submissions.incrementAndGet());
        Assert.assertEquals(2, submissions.getTotal().longValue());
        Assert.assertNull(exceptionThrown);
    }

}
