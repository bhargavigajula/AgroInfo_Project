package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.dto.Employee;

public class EmployeeDao {

	public int register(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "insert into Register values(?,?,?)";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, employee.getUserName());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getDesignation());

			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return 0;
	}

	public Employee getEmployee(String userName, String password,String designation) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String SELECT = "select * from register where userName=? and password=? and designation=?";
		connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, designation);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				Employee employee = new Employee();
				employee.setUserName(resultSet.getString(1));
				employee.setPassword(resultSet.getString(2));
				employee.setDesignation(resultSet.getString(3));

				return employee;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
	}

	public int Employee(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "insert into empDetails values(?,?,?,?,?,?,?)";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, employee.getFarmerName());
			preparedStatement.setString(2, employee.getLocation());
			preparedStatement.setString(3, employee.getMandal());
			preparedStatement.setString(4, employee.getDistrict());
			preparedStatement.setString(5, employee.getProduct());
			preparedStatement.setInt(6, employee.getQuantity());
			preparedStatement.setString(7, employee.getFarmerMobileNo());

			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return 0;
	}

	public int User(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "insert into userDetails values(?,?,?,?,?,?)";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, employee.getCustomerName());
			preparedStatement.setString(2, employee.getLocation());
			preparedStatement.setString(3, employee.getMandal());
			preparedStatement.setString(4, employee.getDistrict());
			preparedStatement.setString(5, employee.getProduct());
			preparedStatement.setInt(6, employee.getQuantity());

			result = preparedStatement.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Employee getEmployee(String farmerName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = DbConnection.getConnection();
		String SELECT = "select * from empDetails where farmerName = ?";


		try{
			preparedStatement = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, farmerName);

			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				Employee employee = new Employee();
				employee.setFarmerName(resultSet.getString(1));
				employee.setLocation(resultSet.getString(2));
				employee.setMandal(resultSet.getString(3));
				employee.setDistrict(resultSet.getString(4));
				employee.setProduct(resultSet.getString(5));
				employee.setQuantity(resultSet.getInt(6));
				employee.setFarmerMobileNo(resultSet.getString(7));
				return employee;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
}
	public List<Employee> getEmployee() {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		con = DbConnection.getConnection();
		String SELECT = "select * from empDetails";
		List<Employee> arrayList = new ArrayList<Employee>();
		try {
			preparedStatement = con.prepareStatement(SELECT);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setFarmerName(rs.getString(1));
				employee.setMandal(rs.getString(2));
				employee.setDistrict(rs.getString(3));
				employee.setLocation(rs.getString(4));
				employee.setProduct(rs.getString(5));
				employee.setQuantity(rs.getInt(6));
				employee.setFarmerMobileNo(rs.getString(7));
				arrayList.add(employee);
			}
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int delete(String farmerName) {
		Connection con = null;
		PreparedStatement pst = null;
		String DELETE="delete from empDetails where farmerName = ?";
	
			con = DbConnection.getConnection();
			try {
				pst = con.prepareStatement(DELETE);
				pst.setString(1, farmerName);
				int x = pst.executeUpdate();
				return x;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		
	}
	public int update(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		
		String UPDATE = "update empDetails set mandal=?,district=?,location=?,product=?,quantity=?,farmerMobileNo=? where farmerName=?";
		
		connection = DbConnection.getConnection();

		try{
			preparedStatement = connection.prepareStatement(UPDATE);

			preparedStatement.setString(7, employee.getFarmerName());
			preparedStatement.setString(1, employee.getMandal());
			preparedStatement.setString(2, employee.getDistrict());
			preparedStatement.setString(3, employee.getLocation());
			preparedStatement.setString(4, employee.getProduct());
			preparedStatement.setInt(5, employee.getQuantity());
			preparedStatement.setString(6, employee.getFarmerMobileNo());

			result = preparedStatement.executeUpdate();
			return result;

		}catch(SQLException e){
			e.printStackTrace();
		}

		finally{
			try{
				if(connection != null){
					preparedStatement.close();
					connection.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return 0;
	}
	public List<Employee> getEmployee1(String product,String mandal) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		con = DbConnection.getConnection();
		String SELECT = "select * from empDetails where product=? and mandal=?";
		List<Employee> arrayList = new ArrayList<Employee>();
		try {
			preparedStatement = con.prepareStatement(SELECT);
			preparedStatement.setString(1, product);
			preparedStatement.setString(2, mandal);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setFarmerName(rs.getString(1));
				employee.setMandal(rs.getString(2));
				employee.setDistrict(rs.getString(3));
				employee.setLocation(rs.getString(4));
				employee.setProduct(rs.getString(5));
				employee.setQuantity(rs.getInt(6));
				employee.setFarmerMobileNo(rs.getString(7));
				arrayList.add(employee);
			}
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}