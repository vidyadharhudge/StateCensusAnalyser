package com.statecensusanalyser;

import java.io.BufferedReader;
import java.util.Iterator;

public interface ICSVBuilder<E>
{
    public Iterator<E> getCSVfile(BufferedReader reader, Class<E> csvClass);
}
