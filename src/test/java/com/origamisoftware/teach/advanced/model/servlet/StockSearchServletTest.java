package com.origamisoftware.teach.advanced.model.servlet;

import com.origami.teach.servlet.StockSearchServlet;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;


public class StockSearchServletTest extends Mockito {

        @Test
        public void testServlet() throws Exception {
            HttpServletRequest request = mock(HttpServletRequest.class);
            HttpServletResponse response = mock(HttpServletResponse.class);

            when(request.getParameter("symbol")).thenReturn("AMZN");
            when(request.getParameter("start")).thenReturn("2015-02-09 00:01:01");
            when(request.getParameter("end")).thenReturn("2015-02-11 01:08:01");
            when(request.getParameter("interval")).thenReturn("day");

            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            when(response.getWriter()).thenReturn(writer);

            new StockSearchServlet().doPost(request, response);

            verify(request, atLeast(1)).getParameter("symbol");
            writer.flush();
            assertTrue(stringWriter.toString().contains("AMZN"));
        }
}
