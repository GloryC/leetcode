package p460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Glory
 * @date 2020/4/6 16:33
 */
public class Solution {
    static class LFUCache {
        Map<Integer, Node> cache;  // 存储缓存的内容
        Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
        int size;
        int capacity;
        int min; // 存储当前最小频次


        public LFUCache(int capacity) {
            this.cache = new HashMap<>(capacity);
            this.freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            freqInc(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                freqInc(node);
            } else {
                if (size == capacity) {
                    Node deadNode = removeNode();
                    cache.remove(deadNode.key);
                    size--;
                }
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addNode(newNode);
                size++;
            }
        }

        void freqInc(Node node) {
            // 从原freq对应的链表里移除, 并更新min
            int freq = node.freq;
            LinkedHashSet<Node> set = freqMap.get(freq);
            set.remove(node);
            if (freq == min && set.size() == 0) {
                min = freq + 1;
            }
            // 加入新freq对应的链表
            node.freq++;
            LinkedHashSet<Node> newSet = freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>());
            newSet.add(node);
        }

        void addNode(Node node) {
            LinkedHashSet<Node> set = freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
            set.add(node);
            min = 1;
        }

        Node removeNode() {
            LinkedHashSet<Node> set = freqMap.get(min);
            Node deadNode = set.iterator().next();
            set.remove(deadNode);
            return deadNode;
        }

    }

    static class Node {
        int key;
        int value;
        int freq = 1;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

