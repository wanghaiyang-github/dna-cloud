package com.bazl.dna.dpznsy.util;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ImgUtils {

    public static String generateImage(String imgStr, String path) {
        BufferedImage image = null;
        byte[] imageByte = null;
        String imgType =  "";
        if(StringUtils.isNotBlank(imgStr)){
            String[] img = imgStr.split(",");
            imgStr = img[1];
            imgType = img[0].substring(img[0].indexOf("/")+1, img[0].indexOf(";"));
        }else{
            return null;
        }
        //获取图片存储路径
        String filePath = path;
        File file = new File(filePath);
        if (!file .exists()  && !file .isDirectory()) {
            //不存在就创建
            file.mkdirs();
        }
        path = path+System.currentTimeMillis()+"."+imgType;

        try {
            imageByte = DatatypeConverter.parseBase64Binary(imgStr);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(new ByteArrayInputStream(imageByte));
            bis.close();

            File outputfile = new File(path);
            ImageIO.write(image, "png", outputfile);

            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        String path = generateImage("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQIAAAECCAYAAAAVT9lQAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyhpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTQ1IDc5LjE2MzQ5OSwgMjAxOC8wOC8xMy0xNjo0MDoyMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTkgKE1hY2ludG9zaCkiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkNCNEJEMjIwQ0VGMTFFOUE0QjlDRDJBMkY0RTJGN0YiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkNCNEJEMjMwQ0VGMTFFOUE0QjlDRDJBMkY0RTJGN0YiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpCQ0I0QkQyMDBDRUYxMUU5QTRCOUNEMkEyRjRFMkY3RiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpCQ0I0QkQyMTBDRUYxMUU5QTRCOUNEMkEyRjRFMkY3RiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PgF7lxoAACRESURBVHja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","D:/img/person_img/");

        System.out.println(path);
        String s = UplodFtpUtils.uploadFtpFile("192.168.1.124", "21", "test", "test", "person_img",path);
        String[] split = path.split("/");
        System.out.println(split[split.length-1]);
        String imgpath="ftp://" + "192.168.1.124" + s + "/" + split[split.length-1];
        System.out.println(imgpath);

    }


}