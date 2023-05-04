package repository;

import models.Qyteti;
import models.Studenti;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QytetiRepository {
    public static Qyteti getQytetiById(int id) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM Qyteti WHERE QId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            Qyteti qyteti = new Qyteti(
                    resultSet.getInt("QId"),
                    resultSet.getString("Emri")
            );
            return qyteti;
        }
        else{
            return null;
        }

        ArrayList<String> qyteti = new ArrayList<String>();
        ArrayList<Integer> ids=new ArrayList<Integer>();
        qyteti.add("Prishtina");
        qyteti.add("Mitrovice");
        qyteti.add("Peje");
        qyteti.add("Prizren");
        qyteti.add("Ferizaj");
        qyteti.add("Gjilan");
        qyteti.add("Gjakove");
        qyteti.add("Podujeve");
        qyteti.add("Vushtri");
        qyteti.add("Rahovec");
        qyteti.add("Drenas");
        qyteti.add("Lipjan");
        qyteti.add("Malisheve");
        qyteti.add("Deqan");
        qyteti.add("Istog");
        qyteti.add("Kline");
        qyteti.add("Kaqanik");
        qyteti.add("Suharek");
        qyteti.add("Viti");

        public static void iterateNames(ArrayList<String>qyteti, ArrayList<Integer> ids) {
            for (int id : ids) {
                System.out.println(names.get(id));
            }
        }

    }
}