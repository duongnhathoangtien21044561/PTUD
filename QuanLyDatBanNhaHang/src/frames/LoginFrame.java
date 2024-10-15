package frames;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.ui.FlatBorder;
import custom_components.RoundCornerPanel;
import java.awt.*;
import java.awt.event.*;
import static java.util.regex.Pattern.matches;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class LoginFrame extends JFrame implements ActionListener, MouseListener{
    //Define variables
    private JPanel pnlBackGround;
    private RoundCornerPanel pnlLogin;
    private GridBagConstraints gbc;
    private JLabel lblTitle, lblTaiKhoan, lblMatKhau;
    private JTextField txtTaiKhoan;
    private JPasswordField pfMatKhau;
    private JButton btnLogin;
    
    public LoginFrame() {
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setExtendedState(this.MAXIMIZED_BOTH);
        
        //Create
        pnlBackGround = new JPanel(new GridBagLayout());
        pnlLogin = new RoundCornerPanel(30);
        pnlLogin.setLayout(new MigLayout());
        gbc = new GridBagConstraints();
        lblTitle = new JLabel("ĐĂNG NHẬP");
        txtTaiKhoan = new JTextField();
        pfMatKhau = new JPasswordField();
        btnLogin = new JButton("Đăng Nhập");
        
        //Add
        add(pnlBackGround, BorderLayout.CENTER);
        pnlBackGround.add(pnlLogin, gbc);
        pnlLogin.add(lblTitle, "wrap, gapleft 30, gaptop 20");
        pnlLogin.add(txtTaiKhoan, "wrap, gapleft 30, gaptop 20, gapright 30");
        pnlLogin.add(pfMatKhau, "wrap, gapleft 30, gaptop 10, gapright 30");
        pnlLogin.add(btnLogin, "wrap, gaptop 20, gapleft 30, gapright 30");
        
        //Modify
        pnlBackGround.setBackground(new Color(55, 189, 219));
        pnlLogin.setPreferredSize(new Dimension(300, 270));
        pnlLogin.putClientProperty("JComponent.roundRect", true);
        pnlLogin.setBackground(Color.white);
        gbc.anchor = GridBagConstraints.CENTER;
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        lblTitle.setForeground(new Color(55, 189, 219));
        txtTaiKhoan.setFont(new Font("Roboto", Font.PLAIN,  16));
        txtTaiKhoan.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        txtTaiKhoan.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tài khoản");
        txtTaiKhoan.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("svg/person.svg"));
        txtTaiKhoan.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        pfMatKhau.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Mật khẩu");
        pfMatKhau.setFont(new Font("Roboto", Font.PLAIN,  16));
        pfMatKhau.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        pfMatKhau.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("svg/key.svg"));
        pfMatKhau.putClientProperty(FlatClientProperties.STYLE, "showRevealButton: true");
        btnLogin.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        btnLogin.setBackground(new Color(55, 189, 219));
        btnLogin.setForeground(Color.white);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(btnLogin)){
            if(check()){
                System.out.println("check thành công");
            }
        }
    }
    
    
    
    public static void main(String args[]){
        FlatLightFlatIJTheme.setup();
        new LoginFrame().setVisible(true);
    }
    
    public boolean check(){
        String taiKhoanPattern = "^[A-Z]\\d+";
        String matKhauPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
        char[] passwordChars = pfMatKhau.getPassword();
        String password = new String(passwordChars);
        if(!matches(taiKhoanPattern, txtTaiKhoan.getText())){
            JOptionPane.showMessageDialog(null, "Sai cú pháp tài khoản");
            return false;
        } else if(!matches(matKhauPattern, password)){
            JOptionPane.showConfirmDialog(null, "Sai cú pháp mật khẩu");
            return false;
        }
        return true;
    }
}
