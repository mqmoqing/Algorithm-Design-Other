package study.test;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.ws.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

/**
 * @author mq
 * @create 2022-11-24 15:27
 */
public class Test {
//    public static void main(String[] args) {
//        pressImage("H:\\mq\\dingding\\网站\\水印logo.png",
//                "D:/oid/uploadPath/profile/upload/2024/09/25/微信图片_20240829173456_20240925140608A007.jpg",
//                "D:/oid/uploadPath/profile/upload/2024/09/25/微信图片_20240829173456_20240925140608A007.jpg",
//                0.2);
//    }
    public static void main(String[] args) {
        String pre = "1.2.156.4000.4301000001.01.240822000201";
        String[] split = pre.split("\\.");
        System.out.println(split[split.length-1].substring(6));
        System.out.println(pre.substring(0,33) );
    }
    public static String addNum(String str) {
        String numStr = str.substring(str.length() - 4); //取出最后四位数字
        if (!numStr.equals("")) { //如果最后四位不是数字，抛NumberFormatException异常
            int n = numStr.length(); //取出字符串的长度o
            int num = Integer.parseInt(numStr) + 1; //将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return str.subSequence(0, str.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

    /**
     * 把水印印刷到图片上
     *
     * @param pressImg  -- 水印文件
     * @param targetImg -- 目标文件
     * @param newImg    -- 新文件
     * @param degree    水印旋转角度
     */
    public static void pressImage(String pressImg, String targetImg, String newImg, double degree) {
        try {
            // 目标文件
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
            g.setComposite(alpha);
            g.rotate(degree);
            int fontSize = (width+height) / 40;
            // 间隔
            int split = fontSize*2;
            // 水印文件
            File _filebiao = new File(pressImg);
            Image src_biao = ImageIO.read(_filebiao);
            int width_biao = src_biao.getWidth(null)/10;
            int height_biao = src_biao.getHeight(null)/10;
            // 水印坐标
            int xCanNum = width / width_biao + 1;
            int yCanNum = height / fontSize + 1;
            for (int i = 1; i <= yCanNum; i++) {
                int y = fontSize * i + split * i;
                for (int j = 0; j < xCanNum; j++) {
                    int x = width_biao  * j + split * j;
                    g.drawImage(src_biao, x, y-(fontSize+split)*j, width_biao, height_biao, null);
                }
            }
            // 水印文件结束
            g.dispose();
            FileOutputStream out = new FileOutputStream(newImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (Exception e) {
            System.out.println("把水印印刷到图片上出错了" + e);
        }
    }

}
