import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Registrationform implements ActionListener {
	JFrame frame;
	//Creating objects
	
	JLabel nameLabel=new JLabel("NAME");
	JLabel emailLabel=new JLabel("Email");
	JLabel passwordLabel=new JLabel("PASSWORD");
	JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
	JLabel mobilenumberLabel=new JLabel("MOBILE NO.");
	JTextField nameTextField=new JTextField();
	JTextField emailTextField=new JTextField();
	JPasswordField passwordField =new JPasswordField();
	JPasswordField confirmpasswordField =new JPasswordField();
	JTextField mobilenumberTextField=new JTextField();
	JButton registerButton=new JButton("REGISTER");
	JButton resetButton=new JButton("RESET");
	//Creating constructor
	Registrationform()
	{
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();//calling method from constructor
	}
	public void createWindow()
	{
		frame=new JFrame();
		frame.setTitle("Registration Form");
		frame.setBounds(40,40,380,600);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setResizable(false);
	}
	public void setLocationAndSize()
	{
		//setting location and size of each component 
		nameLabel.setBounds(20,20,40,70);
		emailLabel.setBounds(20,220,100,70);
		passwordLabel.setBounds(20,70,100,70);
		confirmPasswordLabel.setBounds(20,120,140,70);
		mobilenumberLabel.setBounds(20,170,100,70);
		nameTextField.setBounds(180,43,165,23);
		emailTextField.setBounds(180,243,165,23);
		passwordField.setBounds(180,93,165,23);
		confirmpasswordField.setBounds(180,143,165,23);
		mobilenumberTextField.setBounds(180,193,165,23);
		registerButton.setBounds(70,300,100,35);
		resetButton.setBounds(220,300,100,35);
	}
	public void addComponentsToFrame()
	{
		//adding components to frame
		frame.add(nameLabel);
		frame.add(emailLabel);
		frame.add(passwordLabel);
		frame.add(confirmPasswordLabel);
		frame.add(mobilenumberLabel);
		frame.add(nameTextField);
		frame.add(emailTextField);
		frame.add(passwordField);
		frame.add(confirmpasswordField);
		frame.add(mobilenumberTextField);
		frame.add(registerButton);
		frame.add(resetButton);
	}
	public void actionEvent()
	{
		//adding action listener to buttons
		registerButton.addActionListener(this);
		resetButton.addActionListener(this);
	}
@Override

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==registerButton)
	{
		try {
			//creating Connection object 
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","M@hi13@13");
			
			// prepared statement
			PreparedStatement Pst=connection.prepareStatement("insert into registration values(?,?,?,?,?)");
			//Specifying the values of it's parameter
			Pst.setString(1,nameTextField.getText());
			Pst.setString(2,emailTextField.getText());
		    Pst.setString(3,passwordField.getPassword().toString());
			Pst.setString(4,confirmpasswordField.getPassword().toString());
			Pst.setString(5,mobilenumberTextField.getText());
			//Checking for the Password match
			if(passwordField.getPassword().toString().equalsIgnoreCase(confirmpasswordField.getPassword().toString()))
			{
				//Executing query
			Pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data Registered Successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"password did not match");
			}
		   }catch(SQLException e1) {
			   e1.printStackTrace();
		   }
					
				
			
		}
	if(e.getSource()==resetButton)
	{
		//clearing fields
		nameTextField.setText("");
		emailTextField.setText("");
		passwordField.setText("");
		confirmpasswordField.setText("");
		mobilenumberTextField.setText("");
	}
}
}


