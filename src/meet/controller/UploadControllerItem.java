package meet.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meet.util.db.SisDbConnectionUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadControllerItem
 */
public class UploadControllerItem extends HttpServlet {
	Connection con =null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Upload Controller for Item init called");
		try {
			con  = SisDbConnectionUtil.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//TODO open connection
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println(" destroy called");
		//TODO con close
		try {
			SisDbConnectionUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = null;

		
		String fileName = null;
		long fileSize = 0 ;
		InputStream docInputStream = null;
		
		boolean isMultipleContent = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipleContent){
			ServletFileUpload requestparser = null;
			requestparser = new ServletFileUpload(new DiskFileItemFactory());
			
			try {
				List<FileItem> filelist = requestparser.parseRequest(request);
				
				FileItem iditem = filelist.get(0);
				FileItem docItem = filelist.get(1);
				
				id = Long.parseLong(iditem.getString());
				
				docInputStream = docItem.getInputStream();
				fileSize = docItem.getSize();
				fileName = docItem.getName();
				
			
				PreparedStatement pstmt = null;
				
				try {
					
					String sql = "update Meat_Item set "
					+ " Item_file_name=?,Item_file_data=?"
					+ "where Item_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,fileName);
					pstmt.setBinaryStream(2,docInputStream,(int)fileSize);
					pstmt.setLong(3,id);

					int r = pstmt.executeUpdate();
					if(r==1){
						response.getWriter().print("uploaded");
						response.setHeader("refresh","1,Upload.jsp");
					
					}else {
						response.getWriter().print("uploaded failed");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
					
		}
		else {
			response.getWriter().print("Form is not multiper");
			
		}
	}
}
