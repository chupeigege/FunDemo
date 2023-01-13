package com.example.fundemo.test;

import java.io.*;
import java.time.LocalDateTime;

public class ProcessTest {

    public static void main(String[] args) {
        try {

            // 执行脚本文件
//            String cmd = "C:\\A del 1.txt";
//            String cmd = "cmd ipconfig && help";
            String cmd = "cmd /c cd /A/ && del 2.txt && ";
            String cmd2 = "help";
            System.out.println("开始执行命令:" + cmd);
            //主要在这步写入后调用命令
            Process process = Runtime.getRuntime().exec(cmd);
            try (PrintWriter printWriter =
                         new PrintWriter(
                                 new BufferedWriter(new OutputStreamWriter(process.getOutputStream())), true);
                 BufferedReader read =
                         new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//                printWriter.println("cd " + filepath);
//                printWriter.println(cmd2);
//                printWriter.println(cmd);
//                printWriter.println("exit");
                String line;
                while ((line = read.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println(cmd
                    + " 执行状态："
                    + process.waitFor()
                    + " 执行时间："
                    + LocalDateTime.now());
            // Java父线程等待Shell子进程执行完毕
        } catch (Exception e) {
            System.out.println("error:" + e.toString());
        }
    }
}
