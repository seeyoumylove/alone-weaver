package com.weaver.common.redis.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
  * @author: stone
  * date: 2024/5/29
  * description: 锁对象
  */
@AllArgsConstructor
public class ZLock implements AutoCloseable {
    @Getter
    private final Object lock;

    private final DistributedLock locker;

    @Override
    public void close() throws Exception {
        locker.unlock(lock);
    }
}
