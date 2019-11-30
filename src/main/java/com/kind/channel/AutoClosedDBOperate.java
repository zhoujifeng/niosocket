package com.kind.channel;

/**
 * 验证AutoCloseable接口退出try代码块时，会自动调用close()方法
 */
public class AutoClosedDBOperate implements AutoCloseable{

    public void close() throws Exception {
        System.out.print("关闭连接");
    }

    public static void main(String[] args) {

        try(AutoClosedDBOperate dbo = new AutoClosedDBOperate()){
            System.out.println("使用"+dbo+"开始数据库的操作");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
