package com.halink.delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {
    private Map<String, IEmployee> targets = new HashMap<>();

    public Leader() {
        targets.put("上天", new EmployeeA());
        targets.put("下地", new EmployeeB());
    }

    @Override
    public void doing(String task) {
        IEmployee iEmployee = targets.get(task);
        if (null != iEmployee) {
            iEmployee.doing(task);
        } else {
            throw new RuntimeException("弄不了");
        }
    }
}
