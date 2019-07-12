package com.ldq.study.designPattern.action.visitor;

/**
 * 定义同一个操作的接口
 */
public interface ComputerPart {
    void accept(CommuterPartVisitor visitor);
}
