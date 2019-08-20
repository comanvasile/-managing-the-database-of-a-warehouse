package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import connection.ConnectionFactory;
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}
	
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	private String createSelectQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		return sb.toString();
	}
	private String createDeleteQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE id = ? ");
		return sb.toString();
	}
	private String createInsertQuery(T t) {
		StringBuilder sb = new StringBuilder();
		StringBuilder values=new StringBuilder();
		StringBuilder columns=new StringBuilder();
		sb.append(" INSERT INTO ");
		sb.append(type.getSimpleName());
		sb.append(" ( ");
		for (Field field : type.getDeclaredFields()) {
			PropertyDescriptor propertyDescriptor = null;
			try {
				propertyDescriptor = new PropertyDescriptor(field.getName(), type);
				Method method = propertyDescriptor.getReadMethod();
				Object value = method.invoke(t);
				if(columns.length()>0)
				{
					columns.append(",");
					values.append(",");
				}
				columns.append(field.getName());
				values.append(" \" "+value+" \" ");
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		sb.append(columns);
		sb.append(" ) ");
		sb.append(" VALUES ");
		sb.append(" ( "+values+" ) ");
		
		return sb.toString();
	}
	private String createUpdateQuery(T t)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE ");
		sb.append(type.getSimpleName());
		sb.append(" SET ");
		int c=0;
		for (Field field : type.getDeclaredFields())
		{
			c++;
		}
		for (Field field : type.getDeclaredFields()) {
			PropertyDescriptor propertyDescriptor = null;
			try {
				propertyDescriptor = new PropertyDescriptor(field.getName(), type);
				Method method = propertyDescriptor.getReadMethod();
				Object value = method.invoke(t);
				c--;
				if(c>0)
				{
					sb.append(field.getName()+" = \" "+ value+" \" , ");
				}
				else
				{
					sb.append(field.getName()+" =\" "+ value+" \" ");
				}
				
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		sb.append(" WHERE id = ? ");
	
		
		return sb.toString();
	}
	
	public List<T> findAll() {
		
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String query=createSelectQuery();
		try
		{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(query);
			resultSet=statement.executeQuery();
			
			return createObjects(resultSet);
		}
		catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll" + e.getMessage());
		} 
		finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void update(T t,int id) {
		Connection connection=null;
		PreparedStatement statement=null;
	
		String query=createUpdateQuery(t);
		try
		{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,id);
			statement.executeUpdate();
		}
		catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update" + e.getMessage());
		} 
		finally {
		
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		
		
	}
	public void insert(T t) {
		Connection connection=null;
		PreparedStatement statement=null;

		String query=createInsertQuery(t);
		try
		{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
	
		}
		catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert" + e.getMessage());
		} 
		finally {
		
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		
	
	}
	
	public void delete(int id) {
		Connection connection=null;
		PreparedStatement statement=null;
	
		String query=createDeleteQuery();
		try
		{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,id);
			statement.executeUpdate();
		
		}
		catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:delete" + e.getMessage());
		} 
		finally {
		
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
	
		
	}
	public T findByName(String nume) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("nume");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, nume);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findByName " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	
}
