package ru.ahomyakov.gt.impl;


import java.util.HashMap;
import java.util.Map;


public class DummyGtTestCoreTest extends GtTestCoreTest<DummyGtTestCore> {

    @Override
    protected Map<String, String> testData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("a","b");
        return data;
    }

    @Override
    protected DummyGtTestCore getCoreInstance() {
        return new DummyGtTestCore();
    }
}