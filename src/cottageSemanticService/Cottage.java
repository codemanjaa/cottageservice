package cottageSemanticService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cottage
 */
@WebServlet("/Cottage")
public class Cottage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cottage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	public static String generateBookingReference() {
		 String uniqueID = UUID.randomUUID().toString();
		 /*
		 UUID uuid = UUID.randomUUID();

	        long lsb = uuid.getLeastSignificantBits();
	        long msb = uuid.getMostSignificantBits();

	        byte[] uuidBytes = ByteBuffer.allocate(16).putLong(msb).putLong(lsb).array();

	        // Strip down the '==' at the end and make it url friendly   
	        return Base64.Encoder(uuidBytes)
	                    .substring(0, 22)
	                    .replace("/", "_")
	                    .replace("+", "-");
		//return uniqueID;
	    */
		 return Base64.getEncoder().encodeToString(uniqueID.getBytes());
		 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SWDB mediator = new SWDB();
		String bookerName = null;
		System.out.println("BOOKING REF "+generateBookingReference());
		if(request.getParameter("reqType").toString().equals("doQuery")){
			bookerName = request.getParameter("bookerName").toString();
			int nPlaces = Integer.parseInt(request.getParameter("nPlaces").toString());
			int nRooms = Integer.parseInt(request.getParameter("nRooms").toString());
			int lakeDistance = Integer.parseInt(request.getParameter("lakeDistance").toString());
			int cityDistance = Integer.parseInt(request.getParameter("cityDistance").toString());
			//System.out.println("Believe in yourself...");
			//String pathToDB = this.getServletContext().getRealPath("/res/BookingDB.ttl");
			//mediator.searchForResult(pathToDB, bookerName, noOfPlaces, noOfRooms);
			String pathToDB = this.getServletContext().getRealPath("/res/CottageDBO.ttl");
			mediator.searchForCottageResult(pathToDB, bookerName, nPlaces, nRooms, lakeDistance, cityDistance);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(mediator.getResult());  
	
		/*
		 // not recommended using this way, handle the client code totally separately 
		    out.println("<html>");
	        out.println("<head><title>Cottage Booking Result:rs</title></head>");
	        out.println("<body bgcolor='blue'>");
	        out.println("<ul>");
	        out.println("<li>" + "Booker Name: " + bookerName + "</li>");
	      
	        out.println("</ul>");
	        RequestDispatcher rd= request.getRequestDispatcher("/WebContent/result.html");
            //rd.include(request, response);
	        //rd.forward(request, response);
	        out.println("</body></html>");
	       
	       // RequestDispatcher rd = request.getRequestDispatcher("result.html");
	        //rd.forward(request, response);
	         */ 
	         
	    System.out.println("on the Cottage call....");
		out.flush();
	    out.close();
		

	}

}
