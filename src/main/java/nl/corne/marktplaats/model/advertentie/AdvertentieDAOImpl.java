package nl.corne.marktplaats.model.advertentie;

import belastingdienst.marktplaats.exceptions.AuthorizationLevelTooLow;
import belastingdienst.marktplaats.jdbc.DatabaseJDBC;
import belastingdienst.marktplaats.jdbc.gebruiker.GebruikerJDBC;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.GebruikerDAOImpl;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertentieDAOImpl implements AdvertentieDAO {
    @Override
    public Advertentie get(int avdID) throws SQLException {
        Connection con = DatabaseJDBC.getConnection();
        Advertentie advertentie = null;

        String sql = "SELECT adv_id, user_id, hoofdcategorie, naam, prijs, bezorgwijze, omschrijving, status FROM advertenties WHERE adv_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, avdID);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            int aid = rs.getInt("adv_id");
            // Is dit correct hieronder?
            GebruikerDAOImpl tempGebruiker =  new GebruikerDAOImpl();
            GebruikerJDBC myGebruikerJDBC = tempGebruiker.get(rs.getInt("user_id"));

            Hoofdcategorie hoofdcategorie = Hoofdcategorie.valueOf(rs.getString("hoofdcategorie"));
            String naam = rs.getString("naam");
            BigDecimal prijs = rs.getBigDecimal("prijs");
            Bezorgwijze bezorgwijze = Bezorgwijze.valueOf(rs.getString("bezorgwijze"));
            String omschrijving = rs.getString("omschrijving");
            StatusAdvertentie status = StatusAdvertentie.valueOf(rs.getString("status"));

            advertentie = new Advertentie(aid, myGebruikerJDBC, hoofdcategorie, naam, prijs, bezorgwijze, omschrijving);

            if ( status != StatusAdvertentie.BESCHIKBAAR){
               try {
                   advertentie.setStatus(status, advertentie.getMygebruiker());
               } catch (AuthorizationLevelTooLow e){
                   System.out.println(e.getMessage());
               }
            }
        }

        return advertentie;
    }

    @Override
    public List<Advertentie> getAll() throws SQLException {

        Connection con = DatabaseJDBC.getConnection();
        String sql = "SELECT adv_id, user_id, hoofdcategorie, naam, prijs, bezorgwijze, omschrijving, status FROM advertenties";

        List<Advertentie> advertenties = new ArrayList<>();

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int aid = rs.getInt("adv_id");
            GebruikerDAOImpl tempGebruiker =  new GebruikerDAOImpl();
            GebruikerJDBC myGebruikerJDBC = tempGebruiker.get(rs.getInt("user_id"));
            Hoofdcategorie hoofdcategorie = Hoofdcategorie.valueOf(rs.getString("hoofdcategorie"));
            String naam = rs.getString("naam");
            BigDecimal prijs = rs.getBigDecimal("prijs");
            Bezorgwijze bezorgwijze = Bezorgwijze.valueOf(rs.getString("bezorgwijze"));
            String omschrijving = rs.getString("omschrijving");
            StatusAdvertentie status = StatusAdvertentie.valueOf(rs.getString("status"));

            Advertentie advertentie = new Advertentie(aid, myGebruikerJDBC, hoofdcategorie, naam, prijs, bezorgwijze, omschrijving);

            if ( status != StatusAdvertentie.BESCHIKBAAR){
                try {
                    advertentie.setStatus(status, advertentie.getMygebruiker());
                } catch (AuthorizationLevelTooLow e){
                    System.out.println(e.getMessage());
                }
            }

            advertenties.add(advertentie);
        }

        return advertenties;
    }

    @Override
    public int save(Advertentie advertentie) throws SQLException {
        return 0;
    }

    @Override
    public int insert() throws SQLException {
        return 0;
    }

    @Override
    public int insert(Advertentie advertentie) throws SQLException {
        Connection con = DatabaseJDBC.getConnection();

        String sql = "INSERT INTO advertenties (adv_id, user_id, hoofdcategorie, naam, prijs, bezorgwijze, omschrijving, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, advertentie.getAdvID());
        ps.setInt(2, advertentie.getMygebruiker().getUserID());
        ps.setString(3, advertentie.getHoofdcategorie().toString());
        ps.setString(4, advertentie.getNaamAdvertentie());
        ps.setBigDecimal(5, advertentie.getPrijs());
        ps.setString(6, advertentie.getBezorgwijze().toString());
        ps.setString(7, advertentie.getOmschrijvingAdvertentie());
        ps.setString(8, advertentie.getStatus().toString());

        int result = ps.executeUpdate();

        DatabaseJDBC.closePreparedStatement(ps);
        DatabaseJDBC.closeConnection(con);

        return result;
    }

    @Override
    public int update(Advertentie advertentie) throws SQLException {
        Connection con = DatabaseJDBC.getConnection();

        String sql = "UPDATE advertenties SET hoofdcategorie = ?, naam = ?, prijs = ?, bezorgwijze = ?, omschrijving = ?, status = ? WHERE adv_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, advertentie.getHoofdcategorie().toString());
        ps.setString(2, advertentie.getNaamAdvertentie());
        ps.setBigDecimal(3, advertentie.getPrijs());
        ps.setString(4, advertentie.getBezorgwijze().toString());
        ps.setString(5, advertentie.getOmschrijvingAdvertentie());
        ps.setString(6, advertentie.getStatus().toString());
        ps.setInt(7, advertentie.getAdvID());

        int result = ps.executeUpdate();

        DatabaseJDBC.closePreparedStatement(ps);
        DatabaseJDBC.closeConnection(con);

        return result;
    }

    @Override
    public int delete(Advertentie advertentie) throws SQLException {
        Connection con = DatabaseJDBC.getConnection();

        String sql = "DELETE FROM advertenties WHERE adv_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, advertentie.getAdvID());

        int result = ps.executeUpdate();

        DatabaseJDBC.closePreparedStatement(ps);
        DatabaseJDBC.closeConnection(con);

        return result;
    }
}
