package control;

import dao.DAOUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Coordinate;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import persistence.HibernateUtil;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        //createDataBase();
        //HibernateUtil.shutdown();
        Controller controller = new Controller();
        ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(11.00002,19.99999));
        coordinates.add(new Coordinate(11.00002,5.4));
        controller.addRoute("Valsequillo", "01/01/2020", "iki", coordinates, 1);
        
        //controller.getNumberLikes(1);


    }


    private static void createDataBase() {   
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }       
}
