package game;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {

    public Application() {
        initUI();
    }
    
    private void initUI() {
        
        add(new Scene());

        setSize(Scene.SCENE_MAX_X, Scene.SCENE_MAX_Y);

        setResizable(false);
        
        setTitle("Messages Matter");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
}