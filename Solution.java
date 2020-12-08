package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File directory = new File(root);
        queue.offer(directory);

        while (true) {
            File file = queue.peek();
            if (file == null) {
                break;
            } else if (file.isDirectory()) {
                for (File item : file.listFiles()) {
                    queue.offer(item);
                }
                queue.poll();
            } else if (!file.isDirectory()) {
                File fileForList = queue.poll();
                list.add(fileForList.getAbsolutePath());
            }
        }
        return list;

    }

    public static void main(String[] args) {

    }
}
