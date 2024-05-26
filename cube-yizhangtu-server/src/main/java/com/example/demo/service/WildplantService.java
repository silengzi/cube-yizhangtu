package com.example.demo.service;
import com.example.demo.module.Wildplant;

import java.util.List;
import java.util.Map;

public interface WildplantService {
    List<Wildplant> getWildplant();

    Map<String, Integer> getWildplantNums();
}