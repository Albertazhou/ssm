package com.cetc.weiwen.commons.qrcode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 本类用于对我们二维码进行参数的设定,生成我们的二维码
 * 
 * @author liqiaofei 2018年9月11日
 */

public class QRCodeFactory {

	
	public BufferedImage setMatrixLogo(BufferedImage matrixImage, String logUri) throws IOException {
		
		Graphics2D g2 = matrixImage.createGraphics();
		int matrixWidth = matrixImage.getWidth();
		int matrixHeigh = matrixImage.getHeight();
		BufferedImage logo = ImageIO.read(new File(logUri));
		g2.drawImage(logo, matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, null);
		BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(stroke);
		RoundRectangle2D.Float round = new RoundRectangle2D.Float(matrixWidth / 5 * 2, matrixHeigh / 5 * 2,
				matrixWidth / 5, matrixHeigh / 5, 20, 20);
		g2.setColor(Color.white);
		g2.draw(round);
		BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(stroke2);
		RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth / 5 * 2 + 2, matrixHeigh / 5 * 2 + 2,
				matrixWidth / 5 - 4, matrixHeigh / 5 - 4, 20, 20);
		g2.setColor(new Color(128, 128, 128));
		g2.draw(round2);
		g2.dispose();
		matrixImage.flush();
		return matrixImage;
	}

	public static void CreatQrImageToStream(String content, String format, OutputStream stream, String logUri,
			int... size) throws IOException, WriterException {

		int width = 430; // 二维码图片宽度 430
		int height = 430; // 二维码图片高度430

		// 如果存储大小的不为空，那么对我们图片的大小进行设定
		if (size.length == 2) {
			width = size[0];
			height = size[1];
		} else if (size.length == 1) {
			width = height = size[0];
		}

		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 内容所使用字符集编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		// hints.put(EncodeHintType.MAX_SIZE, 350);//设置图片的最大值
		// hints.put(EncodeHintType.MIN_SIZE, 100);//设置图片的最小值
		hints.put(EncodeHintType.MARGIN, 1);// 设置二维码边的空度，非负数

		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, // 要编码的内容
				// 编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,
				// Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,
				// MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E
				// 1D,UPC/EAN extension,UPC_EAN_EXTENSION
				BarcodeFormat.QR_CODE, width, // 条形码的宽度
				height, // 条形码的高度
				hints);// 生成条形码时的一些配置,此项可选

		// 生成二维码图片写入流中
		MatrixToImageWriter.writeToStream(bitMatrix, format, stream, logUri);
	}
	
	public static String imgToBase64Str(String content,String format, int width,int height) {
		
		int[] size=new int[]{width,height};
	    ByteArrayOutputStream outputStream = null;   
	    try {
        	outputStream = new ByteArrayOutputStream();
	        CreatQrImageToStream(content, format, outputStream, null,size);
	        return Base64.encodeBase64String(outputStream.toByteArray());
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return null;
	    } catch (WriterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return null;
	    }   
	  
	}
}