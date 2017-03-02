package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Controller.BaoCaoDT_Controller;
import Model.BaoCaoDT;

@WebServlet("/UploadFile_Servlet")
public class UploadFile_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "upload";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		// checks if the request actually contains upload file
		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		// this path is relative to application's directory
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		String maDT = null;
		BaoCaoDT_Controller ctr = new BaoCaoDT_Controller();
		BaoCaoDT bc = new BaoCaoDT();
		String url="";
		
		try {

			List<FileItem> formItems = upload.parseRequest(request);
			
			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					// if(item.isFormField()){
					// String a =item.getFieldName();
					// b=item.getString();
					// if(a.equals("MaDT")){
					// System.out.println(b);
					// }
					// }
					
					
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);

						// saves the file on disk
						item.write(storeFile);

						bc.setFileBC(UPLOAD_DIRECTORY + "/" + fileName);
						response.getWriter().print(UPLOAD_DIRECTORY + "/" + fileName);
						request.setAttribute("msg", UPLOAD_DIRECTORY + "/" + fileName);
						request.setAttribute("message",
								"Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
					}
					else{
						String a=item.getFieldName();// lay ten ra
						String b=item.getString();// lay value
						if(a.equals("MaDT"))
							maDT=b;		
					}	
				}
				System.out.println(maDT);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String ngay = dateFormat.format(new Date());
				
				int sobc = ctr.getListBaoCao().size() + 1;
				String mabc = "bc" + Integer.toString(sobc);
				String tenbc = "Báo cáo tiến độ " + Integer.toString(sobc);
				bc.setMaBC(mabc);
				bc.setTenBC(tenbc);
				bc.setNgayBC(ngay);
				bc.setMaDT(maDT);
				ctr.insertBaoCao(bc);
			}
		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
			PrintWriter a = response.getWriter();
			a.println("False");
		}
		response.sendRedirect("UploadFile.jsp?MaDT="+maDT);
		//response.setHeader("REFRESH", "0");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
