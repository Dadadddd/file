import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        //用print写入具体内容(第一种)
        PrintWriter pw = new PrintWriter( new FileWriter( "D:\\写入文字.txt" ) );
        pw.print("百度知道" );
        pw.close();

                 //1链接文件<要写出的位置>（第二种）
//                    File file2=new File("D:\\write.txt");
//                    //2文件输出流
//                    FileOutputStream fos=new FileOutputStream(file2);
//                    //3输出流
//                    OutputStreamWriter os=new OutputStreamWriter(fos);
//                    //4写入缓冲流
//                    BufferedWriter bw=new BufferedWriter(os);
//                    bw.write(line);


    }
}
