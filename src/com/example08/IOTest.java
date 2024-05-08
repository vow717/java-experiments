package com.example08;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class IOTest {

    // 将传入的文件绝对路径字符串转为Path，如果路径不存在则先创建目录，创建文件，文件存在则忽略操作
    public static void convertPathAndCreateFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                System.out.println("文件创建成功。路径：" + path);
            } else {
                System.out.println("文件已存在，忽略操作。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 将传入的文件绝对路径字符串转为Path，通过Files创建文件所在目录，将字符串直接写入文件
    // 如果文件存在，则覆盖写入
    public static void writeToFileUsingFiles(String filePath, String content) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());
            Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("内容写入文件成功，使用 Files 工具类。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将传入的文件绝对路径字符串转为Path，通过Files创建文件所在目录，将字符串基于Files工具类直接写入
    // 写入方法，文件不存在创建并写入，存在则覆盖写入
    public static void writeToFileUsingFilesAppend(String filePath, String content) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());
            Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("内容写入文件成功，追加写入，使用 Files 工具类。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 基于基本IO和字节数组缓冲区，复制文件，并打印读写次数
    public static void copyFileUsingIO(String sourceFile, String destinationFile) {
        try (InputStream is = new FileInputStream(sourceFile);
             OutputStream os = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytesCopied = 0;
            int iterations = 0;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                totalBytesCopied += bytesRead;
                iterations++;
            }
            System.out.println("总共复制字节数: " + totalBytesCopied);
            System.out.println("读写迭代次数: " + iterations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 基于NIO，实现文件的复制
    public static void copyFileUsingNIO(String sourceFile, String destinationFile) {
        try {
            Path sourcePath = Paths.get(sourceFile);
            Path destinationPath = Paths.get(destinationFile);
            Files.createDirectories(destinationPath.getParent());
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件复制成功，使用 NIO。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 遍历打印指定目录下全部目录/文件名称，并根据needReverse参数决定是否逆序
    public static void listDirectoryContents(String directoryPath, boolean needReverse) {
        try {
            List<Path> paths = Files.walk(Paths.get(directoryPath)).collect(Collectors.toList());
            if (needReverse) {
                for (int i = paths.size() - 1; i >= 0; i--) {
                    System.out.println(paths.get(i).getFileName());
                }
            } else {
                for (Path path : paths) {
                    System.out.println(path.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 删除指定文件
    public static void deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
            System.out.println("文件删除成功。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath1 = "D:/IdeaProjects/java-experiments/src/com/example08/test1.txt";
        String filePath2 = "D:/IdeaProjects/java-experiments/src/com/example08/test2.txt";
        String content = "你好，世界！";
        String directoryPath = "D:/IdeaProjects/java-experiments/src/com/example08";

        convertPathAndCreateFile(filePath1);
        writeToFileUsingFiles(filePath1, content);
        writeToFileUsingFilesAppend(filePath1, " 追加内容。");
        copyFileUsingIO(filePath1, filePath2);
        copyFileUsingNIO(filePath1, filePath2);
        listDirectoryContents(directoryPath, true); // 逆序遍历目录内容
        //deleteFile(filePath1);
    }
}
