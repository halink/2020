package com.halink.gobserver;


import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;

class GuavaEventTest {

    @Test
    public void test() {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");
    }
}