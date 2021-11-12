package mvc.Use.Case;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AverageController
 */
@WebServlet("/AverageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int firstNumber = 0;
		int secondNumber = 0;

		try {
			firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
			secondNumber = Integer.parseInt(request.getParameter("secondNumber"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		AverageCalcualtor averageCalcualtor = new AverageCalcualtor();
		int average = averageCalcualtor.averageCalMethod(firstNumber, secondNumber);
		request.setAttribute("average", average);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/average.jsp");
		dispatcher.forward(request, response);
	}

}
