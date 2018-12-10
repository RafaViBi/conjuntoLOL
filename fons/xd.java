import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class pasoParametros extends HttpServlet {
public void doGet(HttpServletRequest peticion,
HttpServletResponse respuesta)
    throws ServletException, IOException {
        respuesta.setContentType("text/html");
        PrintWriter salida = respuesta.getWriter();
        int num1 = Integer.parseInt(peticion.getParameter("num1"));
        int num2 = Integer.parseInt(peticion.getParameter("num2"));
        String operacion = peticion.getParameter("op");
        String res = "";
        
        switch (operacion) {
            case "suma":  operacion = "+";
                          res = Integer.toString(num1 + num2);
                     break;
            case "resta":  operacion = "-";
                         res = Integer.toString(num1 - num2); 
                     break;
            case "multiplicacion":  operacion = "*";
                          res = Integer.toString(num1 * num2); 
                     break;
            case "division":  operacion = "/";
                                if(num2 == 0){
                                    res = "ERROR";
                                } else {
                                    res = Integer.toString(num1 / num2); 
                                }
                     break;
        }
        
        
        String titulo = "Resultado de la operación";
        salida.println("<BODY BGCOLOR=\"#FDF5E6\"><H1 ALIGN=CENTER>" + titulo + "</H1>\n");
        salida.println(num1 + " " + operacion + " " + num2 + " = " + res);
        salida.println("</BODY></HTML>");
    }
}
