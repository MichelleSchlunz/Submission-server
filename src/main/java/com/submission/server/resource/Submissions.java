package com.submission.server.resource;

import com.submission.server.exception.InternalServerException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Submissions {

    private AtomicLong total = new AtomicLong(0);

    public long incrementAndGet(){
        validateLimit();
        return total.incrementAndGet();
    }

    protected void validateLimit() throws InternalServerException{
        if (Long.MAX_VALUE == total.longValue()) {
            throw new InternalServerException("Server maximum count has been reached.");
        }
    }

    public void setTotal(AtomicLong total) {
        this.total = total;
    }

    public AtomicLong getTotal() {
        return total;
    }
}
