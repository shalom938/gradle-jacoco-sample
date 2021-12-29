package org.gradle.sample.messenger;

import org.apache.commons.lang3.StringUtils;

public interface MessageProvider {


    String nextMessage();

    //TODO: see java 9 features to functional interface and implement

    default String capitalize(String message){
        return StringUtils.capitalize(message);
    }

}
