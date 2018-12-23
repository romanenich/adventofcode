package com.romanenich;

import java.util.List;

/**
 * Created by Roman on 23.12.2018.
 */
public interface DataLoader<T extends Data> {
    List<T> loadData();
}
