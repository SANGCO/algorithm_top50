package com.example.algorithm_top50.graph_dfs_bfs;

import java.util.*;

public class A07_WordLadder {

    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","log","cog"};
//		String[] words = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
        A07_WordLadder a = new A07_WordLadder();
        System.out.println(a.ladderLength_neighbor("hit","cog", wordList));
    }

    public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        int level = 1;

        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String str = queue.poll();

                if (str.equals(endWord)) return level;

                for (String neighbor : neighbors(str, dict)) {
                    System.out.println("neighbor : " + neighbor);
                    queue.offer(neighbor);
                }
            }
            level++;
        }

        return 0;
    }

    public List<String> neighbors(String s, Set<String> dict) {
        List<String> res = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                String word = new String(chars);

                if (dict.remove(word)) res.add(word);
                chars[i] = ch;
            }
        }
        return res;
    }

}
