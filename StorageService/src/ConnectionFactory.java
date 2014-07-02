import java.sql.*;

/**
 * Created by tales on 29/06/14.
 */
public class ConnectionFactory {
    private Connection con;

    public void getConnection(String user,String password){
        try{
            System.out.println("REALIZANDO CONEXAO");
            try{
                Class.forName("com.mysql.jdbc.Driver");

            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/imageService",user,password);
        }catch (SQLException e){
            System.out.println("CONEXAO NAO REALIZADA");
            throw new RuntimeException(e);
        }
    }

    public boolean insert(String name,byte[] bin){
        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO pictures (name, image) VALUES (?,?)");
            ps.setString(1, name);
            ps.setBytes(2, bin);
            int cont = ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] download(String name){
        System.out.println("imprimindo");
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM pictures WHERE name = '" + name + "'");
            res.next();
//            name = res.getString("name");
            byte[] binario = res.getBytes("binario");
            res.close();
            st.close();
            System.out.println("Encontramos imagem");
            return binario;
        } catch (SQLException ex) {
            return null;
        }
    }
}
