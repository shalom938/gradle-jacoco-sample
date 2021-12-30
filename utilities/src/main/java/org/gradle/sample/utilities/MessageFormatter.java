package org.gradle.sample.utilities;

import java.io.IOException;
import java.util.Properties;

public class MessageFormatter {

    private static Properties PROPS;

    static {
        try {
            PROPS = new Properties();
            PROPS.load(MessageFormatter.class.getResourceAsStream("/message-formatter.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String messagePreview(String msg){
        int msgPreviewLength = Integer.parseInt(PROPS.getProperty("msg.preview.length","30"));
        int endIndex = Math.min(msg.length(),msgPreviewLength);
        String preview = msg.substring(0,endIndex);
        if (endIndex < msg.length()){
            preview += "...";
        }
        return preview;
    }

}
