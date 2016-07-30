/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.fasojug.servlets;

import bf.fasojug.models.Dog;
import bf.fasojug.models.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Drabo Constantin
 *
 * This servlet test the default mapping part of the specification file (JSR
 * 367)
 *
 */
public class DefaultMapping extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Create an instance of Dog
        Dog milou = new Dog();
        milou.age = 4;        
        milou.name = "Milou";        
        milou.bitable = true;        
        milou.numberofleg = 4;

        //Second instance of Dog
        Dog kappa = new Dog();
        kappa.age = 7;        
        kappa.name = "Kappa";        
        kappa.bitable = true;
        kappa.numberofleg = 4;

        //Serialize a dog instance ; 
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(milou);        
        
        List<Dog> doglist = new ArrayList<>();
        doglist.add(kappa);
        doglist.add(milou);
        
        Jsonb jsonbforlist = JsonbBuilder.create();
        String doglists = jsonbforlist.toJson(doglist);

        //Instance of a person
        Person person = new Person("Tintin", "Tintin", new Date(), "Belgium", "Chateau Moulinsard", "Belgium", "0003200343", "Belgium");        
        person.setAge(12);
        person.setSexe('M');
        person.setSalary(234.89f);
        LocalDate hiredate  = LocalDate.of(1987, Month.JUNE, 4);
        person.setHiredate(hiredate);
        

        //Serialize a person
        Jsonb jsonperson = JsonbBuilder.create();
        String resultperson = jsonb.toJson(person);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DogServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h5>Dog serialized is : " + result + "</h5>");
            out.println("</br> <h5><font color = green> Here the list of dogs :" + doglists + "</font> </h5>");
            out.println("</br> <h5><font color = green> Here a person :" + resultperson + "</font> </h5>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
