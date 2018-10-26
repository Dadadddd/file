import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 import java.io.UnsupportedEncodingException;

 /**
  * 文件读取四步骤
 * ---------要保证文件存在，不能保证就需判断是否存在，在这里手动创建一个文件text.txt以确保存在
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
      public class Write {
      public static void main(String[] args) {
           //----------------------文件读入
                //1
                File file = new File("D:\\read.txt");
                 try {
                       //2
                      FileInputStream fis=new FileInputStream(file);
                      //3
                   InputStreamReader isr=new InputStreamReader(fis,"utf-8");//FileInputStream字符流转换成字节流要注意编码
                     //4
                      BufferedReader br=new BufferedReader(isr);
            //5
                      String line;//用来保存读取到的数据
                        while((line = br.readLine())!=null){//每次读取一行不为空
                            System.out.println(line);
                            }
                  //6
                      br.close();
                     isr.close();
                       fis.close();


             //----------------------文件写出
                      //1链接文件<要写出的位置>
                   File file2=new File("D:\\write.txt");
                       //2文件输出流
                        FileOutputStream fos=new FileOutputStream(file2);
                       //3输出流
                     OutputStreamWriter os=new OutputStreamWriter(fos,"utf-8");
                      //4写入缓冲流
                     BufferedWriter bw=new BufferedWriter(os);
                     //5写入
                       bw.write("七月七日长生殿\n");
                     bw.write("夜半无人私语时\n");
                    bw.write("在天月作比翼鸟\n");
                      bw.write("在地愿为连理枝\n");
                        //6关闭资源
                       bw.close();
                      os.close();
                    fos.close();
                  } catch (FileNotFoundException e) {
                        e.printStackTrace();
                  } catch (UnsupportedEncodingException e) {
                      e.printStackTrace();
                 } catch (IOException e) {
                        e.printStackTrace();
                  }
        }
 }