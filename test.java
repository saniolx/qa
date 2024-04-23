public static void main(String[] args) throws SQLException {
            String url ="jdbc:postgresql://localhost:5432/postgres";
            String userName ="postgres";
            String password="postgres";
            Connection conn = DriverManager.getConnection(url,userName, password);
            Statement statement = conn.createStatement();
            String sql = "SELECT customer_id, first_name, last_name, " +
                    "email FROM CUSTOMER where customer_id =1";
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()) {
                System.out.println("customer id: " + rs.getInt(1));
                System.out.println("customer first name: " + rs.getString(2));
                System.out.println("customer last name: " + rs.getString(3));
                System.out.println("customer email: " + rs.getString(4));
            }
            sql = "SELECT customer_id, first_name, last_name, email " +
                    "FROM CUSTOMER order by customer_id limit 5 ";
            ResultSet customerRs = statement.executeQuery(sql);
            System.out.println("**");
            while(customerRs.next()){
                System.out.println("customer id: " + customerRs.getInt(1));
                System.out.println("customer first name: " + customerRs.getString(2));
                System.out.println("customer last name: " + customerRs.getString(3));
                System.out.println("customer email: " + customerRs.getString(4));
                System.out.println();
            }
        }
    }
}
