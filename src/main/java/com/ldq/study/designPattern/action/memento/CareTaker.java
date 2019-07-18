package com.ldq.study.designPattern.action.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录历史类
 * 可以通过索引回退到不同的备忘录状态
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento){
        mementoList.add(memento);
    }

    public Memento getMemento(int index){
        return mementoList.get(index);
    }
}
