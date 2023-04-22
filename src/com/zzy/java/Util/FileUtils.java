package com.zzy.java.Util;

import java.io.File;
import java.net.URI;

public class FileUtils {
    /**
     * 创建一个新文件
     * 如果文件不存在，保证了在路径文件夹都创建出来之后，再创建文件；
     * 如果文件存在，不做处理；
     * @param uri 文件的URI
     * @return 创建成功返回true，否则返回false
     */
    public static boolean createFileIfNotExists(URI uri) {
        return createFile(new File(uri), false);
    }

    /**
     * 创建一个新文件
     * 如果文件不存在，保证了在路径文件夹都创建出来之后，再创建文件；
     * 如果文件存在，不做处理；
     * @param path 文件的URI
     * @return 创建成功返回true，否则返回false
     */
    public static boolean createFileIfNotExists(String path) {
        return createFile(new File(path), false);
    }

    /**
     * 创建一个新文件
     * 如果文件不存在，保证了在路径文件夹都创建出来之后，再创建文件；
     * 如果文件存在，删除旧文件，重新创建；
     * @param uri 文件的URI
     * @return 创建成功返回true，否则返回false
     */
    public static boolean createFileIgnoreExists(URI uri) {
        return createFile(new File(uri), true);
    }

    /**
     * 创建一个新文件
     * 如果文件不存在，保证了在路径文件夹都创建出来之后，再创建文件；
     * 如果文件存在，删除旧文件，重新创建；
     * @param path 文件的URI
     * @return 创建成功返回true，否则返回false
     */
    public static boolean createFileIgnoreExists(String path) {
        return createFile(new File(path), true);
    }

    public static boolean createFile(File file, boolean ignoreExists) {
        if (ignoreExists) {
            if (file.exists() && file.delete()) {
                System.out.println("delete file exists.");
            }
        } else {
            if (file.exists()) return true;
        }

        File parentFile = file.getParentFile();
        boolean parentFileExists = false;
        if (parentFile != null && !parentFile.exists()) {
            parentFileExists = parentFile.mkdirs();
        }

        if (parentFileExists) {
            try {
                return file.createNewFile();
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 删除文件或者文件夹，并返回移除的文件数量（文件数量 + 文件夹数量
     * 深度优先遍历
     * @param root 根结点
     */
    public static int deleteFile(File root) {
        if (root == null || !root.exists()) return 0;
        int count = 0;
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File f : files) {
                    count += deleteFile(f);
                }
            }
        }

        try {
            String name = root.getName();
            boolean delete = root.delete();
            count ++;
            System.out.println(name + " " + delete);
        } catch (Exception ignore) {
        }

        return count;
    }

}
