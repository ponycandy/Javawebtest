package chargeup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class Chargeup
 */
@WebServlet("/Chargeup")
public class Chargeup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chargeup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		// Load the Excel file
		FileInputStream fileInputStream = new FileInputStream("your_file.xlsx");
		Workbook workbook = new XSSFWorkbook(fileInputStream);

		// Get the first sheet (assuming there is only one sheet)
		Sheet sheet = workbook.getSheetAt(0);

		// Iterate through rows and cells to extract data
		for (Row row : sheet) {
		    for (Cell cell : row) {
		        // Retrieve cell data based on cell type (string, numeric, date, etc.)
		        switch (cell.getCellType()) {
		            case STRING:
		                String cellValue = cell.getStringCellValue();
		                // Add cellValue to your data structure or database
		                break;
		            case NUMERIC:
		                double numericValue = cell.getNumericCellValue();
		                // Add numericValue to your data structure or database
		                break;
		            // Handle other cell types as needed
		        }
		    }
		}

		// Close the input stream and workbook
		fileInputStream.close();
		workbook.close();

	}

}
