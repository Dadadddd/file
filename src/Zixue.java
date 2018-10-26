import java.io.*;

/**
 * 文件读取四步骤
 * ---------要保证文件存在，不能保证就需判断是否存在，在这里手动创建一个文件read.txt以确保存在
 * 1：获取文件
 * 2：将文件写入到文件输入流中<文件输入流是字节流>
 * 3：将文件流写入到输入流InputStreamReader中
 * 4：将输入流文件放到缓冲流BufferReader中
 * 四步骤：执行完毕文件会读入缓冲流
 * 5：从缓冲流中每次读取一行打印输出
 * 6:关闭资源<流>
 * 文件写出同理：
 * @author NEXT_NiGHT
 *
 */
public class Zixue {
    public  static void main(String[] args){
    //第一步，获取文件    因为是文件，所以用File来获取(把文件的路径写上)
    File file=new File("D:\\read.txt");
    //第二部，将获取的文件内容写出来（将文件写入到文件输入流中<文件输入流是字节流>）也就是FileInputStream
    {
        try {
            FileInputStream  fileInputStream = new FileInputStream(file);//file代表的是刚刚从路径中读出来的内容
         //第三步，将文件流FileInputStream写入到输入流Reader中
            //FileInputStream字符流转换成字节流要注意编码;
            try {
                InputStreamReader   inputStreamReader = new InputStreamReader(fileInputStream,"GBK");

            //第四步，将输入流文件放到缓冲流BufferReader中
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            //此时，执行完毕文件会读入缓冲流

            //第五步，从缓冲流中每次读取一行打印输出
                String line;//用来保存读取到的数据
                while((line = bufferedReader.readLine())!=null){//每次读取一行不为空
                    System.out.println(line);
                    //以上是读取文件里的内容，接下来要将读出来的内容写到另一个文件中

//                    //----------------------文件写出

                    PrintWriter pw = new PrintWriter( new FileWriter( "D:\\写入文字.txt" ) );
                    pw.print(line );
                    pw.close();
                }

            //最后要关闭资源<流>
             bufferedReader.close();
             inputStreamReader.close();
              fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    }
}
