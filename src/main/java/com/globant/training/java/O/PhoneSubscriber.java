package com.globant.training.java.O;

import java.util.List;

public class PhoneSubscriber extends Subscriber {

    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(this.getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return (double) (totalDuration * this.getBaseRate()) /100;
    }
}