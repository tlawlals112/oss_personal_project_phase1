import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private JFrame mainMenuFrame; // 메인 메뉴의 프레임 참조를 필드로 추가

    public MainMenu(JFrame mainMenuFrame) { // 생성자에서 메인 메뉴의 프레임을 전달받음
        this.mainMenuFrame = mainMenuFrame; // 전달받은 메인 메뉴의 프레임을 필드에 저장
        setLayout(new GridLayout(3, 1, 0, 10)); // 3행 1열의 그리드 레이아웃, 간격은 세로 10px
        
        JButton startButton = new JButton("Start");
        JButton optionButton = new JButton("Option");
        JButton exitButton = new JButton("Exit");
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        
        optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOptionDialog();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitGame();
            }
        });
        
        add(startButton);
        add(optionButton);
        add(exitButton);
    }
    
    private void startGame() {
        // 게임이 시작될 때 메인 메뉴를 숨기기 위해 setVisible(false) 호출
        mainMenuFrame.setVisible(false);
        
        JFrame gameFrame = new JFrame("Stickman Fighting Game");
        GamePanel gamePanel = new GamePanel();
        gameFrame.add(gamePanel);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
    }
    
    private void showOptionDialog() {
        // Option dialog will be shown here.
    }
    
    private void exitGame() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // 화면 가운데 정렬
        frame.add(new MainMenu(frame));
        frame.setVisible(true);
    }
}
