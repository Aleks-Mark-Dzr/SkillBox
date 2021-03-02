package com.markov.generics

class Queue<T> {

    val queue: MutableList<T> = mutableListOf()

    fun enqueue(item: T) {
        queue.add(item)
    }

    fun dequeue(): T? {
        if (queue.isEmpty()) {
            return null
        } else {
            return queue.removeAt(0)
        }
    }
}