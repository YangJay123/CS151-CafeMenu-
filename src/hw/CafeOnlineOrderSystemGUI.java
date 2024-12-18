package hw;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CafeOnlineOrderSystemGUI extends JFrame{
	
	private cafe pugCafe = cafe.DB;
	
	public CafeOnlineOrderSystemGUI() {
        // Set up the this
		Image image;
		JLabel background = new JLabel();
		try {
			image = ImageIO.read(new File("background.jpg"));
			background = new JLabel(new ImageIcon(image));
			this.add(background);
			background.setLayout( new BorderLayout() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("Pug Petting Cafe Co.");
		this.setSize(700, 450);
		this.setLocationRelativeTo(null);
		background.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints gbc = new GridBagConstraints();
		// xxx specify that the component's display area will be from gridx to 
		// xxx the last cell in the row
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		// xxx Make the component wide enough to fill its display area horizontally, Password1!
		// xxx but do not change its height.
        gbc.fill =      GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50); 
        
   		// Welcome title
        JLabel welcomeLabel = new JLabel("Welcome to Pug Petting Cafe!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 32));
      
      
        
        
        
        
        
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        JButton signUpButton = new JButton("Sign up");
       
        
        JLabel notUser = new JLabel("Not a User? Click here to sign up!", SwingConstants.CENTER);
        notUser.setFont(new Font("Sans", Font.BOLD, 16));
        
        background.add(welcomeLabel, gbc);
        background.add(loginButton, gbc);
        background.add(exitButton,gbc);
        background.add(notUser, gbc);
        background.add(signUpButton, gbc);
        
        loginButton.addActionListener(e -> {
            LoginScreen loginScreen = new LoginScreen(CafeOnlineOrderSystemGUI.this, null);
            loginScreen.displayLoginForm();
        });
        signUpButton.addActionListener(e -> {
            SignupScreen signUp = new SignupScreen(CafeOnlineOrderSystemGUI.this, pugCafe);
            signUp.displaySignupForm();
          //  signUp.setVisible(true);
        });
        
        this.setVisible(true);
	}
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> {
	            CafeOnlineOrderSystemGUI gui = new CafeOnlineOrderSystemGUI();
	           // gui.setVisible(true);
	        });
	}
}
