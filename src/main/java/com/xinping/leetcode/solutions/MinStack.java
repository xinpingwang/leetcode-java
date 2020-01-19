package com.xinping.leetcode.solutions;

import java.util.ArrayList;

/**
 * 两个数组，一个记录添加的元素，另一个记录目前为止的最小值
 * <p>
 * 6ms, 98.29%
 */
public class MinStack {

    final private ArrayList<Integer> array;
    final private ArrayList<Integer> minArray;

    public MinStack() {
        this.array = new ArrayList<>();
        this.minArray = new ArrayList<>();
    }

    public void push(int x) {
        this.array.add(x);
        if (this.minArray.size() > 0 && this.minArray.get(this.minArray.size() - 1) < x) {
            this.minArray.add(this.minArray.get(this.minArray.size() - 1));
        } else {
            this.minArray.add(x);
        }
    }

    public void pop() {
        if (this.array.size() == 0) {
            return;
        }

        int index = this.array.size() - 1;
        array.remove(index);
        minArray.remove(index);
    }

    public int top() {
        if (this.array.size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return this.array.get(this.array.size() - 1);
    }

    public int getMin() {
        if (this.minArray.size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return this.minArray.get(this.minArray.size() - 1);
    }
}
