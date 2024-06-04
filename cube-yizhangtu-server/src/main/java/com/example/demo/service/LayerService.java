package com.example.demo.service;

import java.util.List;

public interface LayerService<T> {
    List<T> getLayers(String type);
}