package listagem.dao;

import listagem.model.listagem;

import java.sql.*;

public class CometDAO {

    private static final String URL = "jdbc:h2:mem:comet;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";

    public static Comet find(int usuarioID) throws SQLException {
        // Abrir uma conex�o com o banco de dados.
        Connection conn = DriverManager.getConnection(URL);
        String sql2 = "CREATE TABLE COMET(ID INT PRIMARY KEY, NAME VARCHAR(255))";
        PreparedStatement preparedStatement = conn.prepareStatement(sql2);
        preparedStatement.execute();
        preparedStatement.close();
        // Executar instru��o SQL.
        String sql = "SELECT * FROM COMET WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, usuarioID);
        ResultSet resultSet = pstmt.executeQuery();
        System.out.println(resultSet.getObject(1));
        Comet comet = (Comet) pstmt.executeQuery();
        // Fechar senten�a.
        pstmt.close();
        // Fechar conex�o.
        conn.close();
        return comet;
    }


}
