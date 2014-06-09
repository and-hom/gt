package ru.ahomyakov.gt.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ahomyakov.gt.GtTestCore;

/**
 * Created by and-hom on 08.06.14.
 */
public class DummyGtTestCore implements GtTestCore {
    Logger logger = LoggerFactory.getLogger(DummyGtTestCore.class);

    @Override
    public String process(String value) {
        StringBuilder sb = new StringBuilder();
        for (char c : value.toCharArray()) {
            sb.append((char) (c + 1));
        }
        return sb.toString();
    }
}
