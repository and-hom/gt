package ru.ahomyakov.gt.impl;

import junit.framework.TestCase;
import ru.ahomyakov.gt.GtTestCore;

import java.util.Map;


/**
 * Created by and-hom on 08.06.14.
 */
public abstract class GtTestCoreTest<T extends GtTestCore> extends TestCase {

    public void testProcess() {
        T core = getCoreInstance();
        for (Map.Entry<String, String> data : testData().entrySet()) {
            assertEquals(core.process(data.getKey()), data.getValue());
        }
    }

    protected abstract Map<String, String> testData();

    protected abstract T getCoreInstance();

}
