package com.ldq.study.designPattern.action.responsibilityChain;

/**
 * 具体责任链实现类，不同的人员的职能不一样，责任也不一样
 */
public class SalerHandlerImpl extends Handler {

    @Override
    public void handlerRequest(double request) {
        if(request<0.05){
            System.out.println(getClass().getName() + "批准了折扣：" + request);
        }else{
            getNextHandler().handlerRequest(request);
        }
    }
}
