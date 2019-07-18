package com.ldq.study.designPattern.action.iterator;

/**
 * 获取迭代对象
 */
public class NameRepository implements Container {
    private String[] names = {"lily", "lucy", "jack", "ming"};

    @Override
    public Iterator getIterator() {
        return new NameIteratorImpl();
    }

    /**
     * 具体的迭代实例，实现迭代接口
     */
    private class NameIteratorImpl implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
