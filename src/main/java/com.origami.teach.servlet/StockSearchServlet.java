package com.origami.teach.servlet;

import com.origami.teach.model.StockData;
import com.origami.teach.model.StockQuote;
import services.ServiceFactory;
import services.StockService;
import services.StockServiceException;
import util.Interval;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StockSearchServlet extends HttpServlet {

    private StockService databaseStockService = ServiceFactory.getStockService();
    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String START_PARAMETER_KEY = "start";
    private static final String END_PARAMETER_KEY = "end";
    private static final String INTERVAL_PARAMETER_KEY = "interval";
    List<StockQuote> stockQuotes;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String symbol = request.getParameter(SYMBOL_PARAMETER_KEY);
        String startDate = request.getParameter(START_PARAMETER_KEY);
        String endDate = request.getParameter(END_PARAMETER_KEY);
        String interval = request.getParameter(INTERVAL_PARAMETER_KEY);


        try {

            Calendar fromCalendar = makeCalendarFromString(startDate);
            Calendar untilCalendar = makeCalendarFromString(endDate);
            //null pointer exception is marked as occurring here when running page, im guessing because im not getting any results from the database?
            if (interval.equals("day")) {
                stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, Interval.DAY);
            }
            if (interval.equals("minute")){
                stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, Interval.DAY);
            }

            HttpSession session = request.getSession();
            if (stockQuotes != null){
                session.setAttribute("quotes", stockQuotes);
            }



            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/stockquoteResults.jsp");
            dispatcher.forward(request, response);

        } catch (ParseException | StockServiceException e) {
            e.printStackTrace();
        }

        //used for testing form parameters
        /*
        PrintWriter writer = response.getWriter();

        // build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>symbol is: " + symbol + "<br/>";
        htmlResponse += "start date is: " + startDate + "<br/>";
        htmlResponse += "end date is: " + endDate + "</h2>";
        htmlResponse += "</html>";

        // return response
        writer.println(htmlResponse);
        */
    }

    private Calendar makeCalendarFromString(String dateString) throws ParseException {
        DateFormat format = new SimpleDateFormat(StockData.dateFormat, Locale.ENGLISH);
        Date date = format.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }
}