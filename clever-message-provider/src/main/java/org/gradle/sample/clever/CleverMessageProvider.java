package org.gradle.sample.clever;

import org.gradle.sample.messenger.MessageProvider;

import java.time.Instant;

public class CleverMessageProvider implements MessageProvider {


    @Override
    public String nextMessage() {
        return "clever message produced at " + Instant.now();
    }
}
