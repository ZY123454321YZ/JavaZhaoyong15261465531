package com.springmvc.servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CheckTestServlet
 */
@WebServlet("/CheckTestServlet")
public class CheckTest extends HttpServlet {
//	private static final Logger logger = LoggerFactory.getLogger(CheckTest.class);

	private static final long serialVersionUID = 1L;

	// ��֤��ͼƬ�Ŀ��
	private int width = 82;
	// ��֤��ͼƬ�ĸ߶�
	private int height = 25;
	// ��֤���ַ�����
	private int codeCount = 4;

	private int x = 0;
	// ����߶�
	private int fontHeight;
	private int codeY;

	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z' };

	/**
	 * ��ʼ����֤ͼƬ����
	 */
	public void init() throws ServletException {
		// ��web.xml�л�ȡ��ʼ��Ϣ
		// ���
		String strWidth = this.getInitParameter("width");
		// �߶�
		String strHeight = this.getInitParameter("height");
		// �ַ�����
		String strCodeCount = this.getInitParameter("codeCount");

		// �����õ���Ϣת������ֵ
		try {
			if (strWidth != null && strWidth.length() != 0) {
				width = Integer.parseInt(strWidth);
			}
			if (strHeight != null && strHeight.length() != 0) {
				height = Integer.parseInt(strHeight);
			}
			if (strCodeCount != null && strCodeCount.length() != 0) {
				codeCount = Integer.parseInt(strCodeCount);
			}
		} catch (NumberFormatException e) {
//			logger.error("��֤�����ָ�ʽ������", e);
		}
		x = width / (codeCount + 1);
		fontHeight = height - 2;
		codeY = height - 4;
	}

	public CheckTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ͼ��buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();

		// ����һ���������������
		Random random = new Random();

		// ��ͼ�����Ϊ��ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�����
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		// ��������
		g.setFont(font);

		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);

		// �������20�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		g.setColor(Color.BLACK);
		for (int i = 0; i < 20; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// �������codeCount���ֵ���֤��
		for (int i = 0; i < codeCount; i++) {
			// �õ������������֤�����֡�
			String strRand = String.valueOf(codeSequence[random.nextInt(62)]);
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// �������������ɫ����֤����Ƶ�ͼ����
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * x, codeY);

			// ���������ĸ�����������һ��
			randomCode.append(strRand);
		}
		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = request.getSession();
		session.setAttribute("VALIDATECODE", randomCode.toString());
        
		// ��ֹͼ�񻺴�
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf8");
		// ��ͼ�������Servlet�������
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
