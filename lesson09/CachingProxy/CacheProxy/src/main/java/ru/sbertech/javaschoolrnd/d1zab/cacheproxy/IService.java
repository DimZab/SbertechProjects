package ru.sbertech.javaschoolrnd.d1zab.cacheproxy;

import java.util.List;

public interface IService {
    @Cache(cacheType = CacheType.MEMORY, identityBy = {String.class, int.class})
    double doHardWork(final String work, final int value);

    @Cache(cacheType = CacheType.FILE, fileNamePrefix = "mуPrefix.zip", zip = true, listLength = 2)
    List<Double> run(final String item);
}